package main;

import entities.News;
import threads.GetDataThread;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private static Logger log = Logger.getLogger(Data.class.getName());

    private GetDataThread getDataThread;;

    private final OnDataChangesListener dataChangesListener;
    private final OnDataErrorsListener dataErrorsListener;
    private Controller.SortMode currentSortMode;

    public Data(OnDataChangesListener dataChangesListener, OnDataErrorsListener dataErrorsListener) {
        this.dataChangesListener = dataChangesListener;
        this.dataErrorsListener = dataErrorsListener;
    }

    public void getData(Controller.FileMode fileMode, Controller.SortMode currentSortMode) {
        getDataThread = new GetDataThread(fileMode, completionHandler, errorHandler);
        this.currentSortMode = currentSortMode;
        getDataThread.start();
    }


    public interface OnDataChangesListener {
        public void onDataChanged(ArrayList<News> jsonList);
    }

    public interface OnDataErrorsListener {
        public void onDataError(String message);
    }


    public Runnable completionHandler = new Runnable() {
        @Override
        public void run() {

            if (null == getDataThread) {
                dataErrorsListener.onDataError("Внутренняя ошибка: getDataThread is null");
                return;
            }

            ArrayList<News> newsList = getDataThread.getNewsList();

            if (null == newsList) {
                dataErrorsListener.onDataError("Внутренняя ошибка: newsList is null");
            } else {
                // return sorted list (date by default)
                Comparator<News> comparator = (currentSortMode == Controller.SortMode.KEYS_MODE) ? News.keysComparator : News.dateComparator;
                newsList.sort(comparator);
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
}
