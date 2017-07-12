package data;

import data.entities.News;
import controller.Controller;
import data.threads.GetDataThread;
import utils.FileMode;
import utils.Period;
import utils.SortMode;

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

    private GetDataThread getDataThread;
    private ArrayList<News> newsList;

    public Data(OnDataChangesListener dataChangesListener, OnDataErrorsListener dataErrorsListener) {
        this.dataChangesListener = dataChangesListener;
        this.dataErrorsListener = dataErrorsListener;
    }

    public void downloadData(FileMode fileMode, SortMode sortMode, Period period) {
        getDataThread = new GetDataThread(fileMode, completionHandler, errorHandler);
        getDataThread.setCurrentSortMode(sortMode);
        getDataThread.setCurrentPeriod(period);
        getDataThread.start();
    }

    // when GetdataThread ends, completionHandler or errorHandler
    // would be invoked to return to main thread
    public Runnable completionHandler = new Runnable() {
        @Override
        public void run() {

            // check thread is not null
            if (null == getDataThread) {
                dataErrorsListener.onDataError("Internal error: getDataThread is null");
                return;
            }

            // get data from thread
            newsList = getDataThread.getNewsList();

            // check data not null
            if (null == newsList) {
                dataErrorsListener.onDataError("Internal error: newsList is null");
            } else {
                // transfer data to controller
                dataChangesListener.onDataChanged(newsList);
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
            News.filter(result, query);

            // return to main thread and transfer data to controller
            SwingUtilities.invokeLater(() -> { // lambda expr for Runnable
                dataChangesListener.onDataChanged(result);
            });
        }).start();
    }

    // delete all News,
    // which doesn't contain any word from query


    public interface OnDataChangesListener {
        public void onDataChanged(ArrayList<News> jsonList);
    }

    public interface OnDataErrorsListener {
        public void onDataError(String message);
    }
}
