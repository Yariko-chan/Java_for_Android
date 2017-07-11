package main;

import entities.News;
import threads.GetDataThread;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private static Logger log = Logger.getLogger(Data.class.getName());

    private final OnDataChangesListener dataChangesListener;
    private final OnDataErrorsListener dataErrorsListener;

    private Controller.SortMode currentSortMode;
    private GetDataThread getDataThread;
    private ArrayList<News> newsList;

    public Data(OnDataChangesListener dataChangesListener, OnDataErrorsListener dataErrorsListener) {
        this.dataChangesListener = dataChangesListener;
        this.dataErrorsListener = dataErrorsListener;
    }

    public void downloadData(Controller.FileMode fileMode, Controller.SortMode currentSortMode) {
        getDataThread = new GetDataThread(fileMode, completionHandler, errorHandler);
        this.currentSortMode = currentSortMode;
        getDataThread.start();
    }

    // when GetdataThread ends, completionHandler or errorHandler
    // would be invoked to return to main thread
    public Runnable completionHandler = new Runnable() {
        @Override
        public void run() {

            // check thread is not null
            if (null == getDataThread) {
                dataErrorsListener.onDataError("Внутренняя ошибка: getDataThread is null");
                return;
            }

            // get data from thread
            newsList = getDataThread.getNewsList();

            // check data not null
            if (null == newsList) {
                dataErrorsListener.onDataError("Внутренняя ошибка: newsList is null");
            } else {
                // return sorted list (by date by default)

                // get comparator
                Comparator<News> comparator = (Controller.SortMode.KEYS_MODE == currentSortMode) ? News.keysComparator : News.dateComparator;

                // sort in other thread (can be long)
                new Thread(() -> { // lambda expr for Runnable
                    newsList.sort(comparator);

                    // return to main thread and transfer data to controller
                    SwingUtilities.invokeLater(() -> { // lambda expr for Runnable
                        dataChangesListener.onDataChanged(newsList);
                    });
                }).start();


            }
        }
    };

    public Runnable errorHandler = new Runnable() {
        @Override
        public void run() {

            if (null == getDataThread) {
                dataErrorsListener.onDataError("Внутренняя ошибка: getDataThread is null");
                return;
            }

            String errorMessage = getDataThread.getErrorMessage();
            dataErrorsListener.onDataError(errorMessage);
        }
    };

    public void search(String query) {
        if (null == newsList) {

            dataErrorsListener.onDataError("Список новостей пуст");
        }
        // search may be long, so do it in other thread
        new Thread(() -> { // lambda expr for Runnable
            // create copy to not affect original data
            ArrayList<News> result = new ArrayList<>(newsList);

            // delete all News,
            // which doesn'contain any word from query
            // in title, description or keys
            filter(query, result);

            // return to main thread and transfer data to controller
            SwingUtilities.invokeLater(() -> { // lambda expr for Runnable
                dataChangesListener.onDataChanged(result);
            });
        }).start();
    }

    // delete all News,
    // which doesn'contain any word from query
    // in title, description or keys
    private void filter(String query, ArrayList<News> result) {
        // create regular expression from query
        // to find all words with 0..any count of symbols
        // before, after and between them
        String[] words = query.split(" ");
        String anySymbols = "(.|\n)*";
        String caseInsensive = "(?i)";
        StringBuilder builder =  new StringBuilder();
        for (int i = 0; i < words.length - 1; i++) {
            builder.append("(").append(anySymbols).append("").append(caseInsensive).append(words[i]).append(anySymbols).append(")");
            builder.append("||");
        }
        // append last word without ||
        builder.append("(").append(anySymbols).append(caseInsensive).append(words[words.length - 1]).append(anySymbols).append(")");
        Pattern pattern = Pattern.compile(builder.toString());

        // remove News from list if
        // it's description, title and keys doesn't contain query
        result.removeIf(n -> // predicate
                !(
                        pattern.matcher(n.getTitle()).matches()
                        || pattern.matcher(n.getDescription()).matches()
                        || pattern.matcher(Arrays.toString(n.getKeywords())).matches() // convert String[] keys to one String
                )
        );
        result.trimToSize();
    }

    public interface OnDataChangesListener {
        public void onDataChanged(ArrayList<News> jsonList);
    }

    public interface OnDataErrorsListener {
        public void onDataError(String message);
    }
}
