package main;

import entities.News;
import threads.GetDataThread;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private static Logger log = Logger.getLogger(Data.class.getName());

    private GetDataThread getDataThread;;

    private final OnDataChangesListener dataChangesListener;
    private final OnDataErrorsListener dataErrorsListener;

    public Data(OnDataChangesListener dataChangesListener, OnDataErrorsListener dataErrorsListener) {
        this.dataChangesListener = dataChangesListener;
        this.dataErrorsListener = dataErrorsListener;
    }

    public void getData(Controller.FileMode fileMode) {
        getDataThread = new GetDataThread(fileMode, completionHandler, errorHandler);
        getDataThread.start();
    }


    public interface OnDataChangesListener {
        public void OnDataChanged(ArrayList<News> jsonList);
    }

    public interface OnDataErrorsListener {

        public void displayError(String message);
    }


    public Runnable completionHandler = new Runnable() {
        @Override
        public void run() {

            if (null == getDataThread) {
                dataErrorsListener.displayError("Внутренняя ошибка: getDataThread is null");
                return;
            }

            ArrayList<News> newsList = getDataThread.getNewsList();

            if (null == newsList) {
                dataErrorsListener.displayError("Внутренняя ошибка: newsList is null");
            } else {
                dataChangesListener.OnDataChanged(newsList);
            }
        }
    };
    public Runnable errorHandler = new Runnable() {
        @Override
        public void run() {

            if (null == getDataThread) {
                dataErrorsListener.displayError("Внутренняя ошибка: getDataThread is null");
                return;
            }


            String errorMessage = getDataThread.getErrorMessage();
            dataErrorsListener.displayError(errorMessage);
        }
    };
}
