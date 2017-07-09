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

    private ArrayList<News> newsList;

    private final OnDataChangesListener dataChangesListener;
    private final OnDataErrorsListener dataErrorsListener;

    public Data(OnDataChangesListener dataChangesListener, OnDataErrorsListener dataErrorsListener) {
        this.dataChangesListener = dataChangesListener;
        this.dataErrorsListener = dataErrorsListener;
    }

    public void getData(Controller.FileMode fileMode) {

        /**
         *      Data(main)            | getDataThread
         * -----------------------------------------------
         *  start   ->                |
         *  wait()                    | download JSON/XML
         *                            | parse JSON/XML
         *                            | mainThread.notify()
         *  parseThread.getNewsList() | wait()
         *  parseThread.notify()      |
         *  ...                       | [END]
         */

        Thread currentThread = Thread.currentThread();
        GetDataThread getDataThread = new GetDataThread(fileMode);
        getDataThread.setMainThread(currentThread);
        getDataThread.start();
        try {
            synchronized (currentThread) {
                currentThread.wait();
            }

        } catch (InterruptedException e) {
            log.log(Level.SEVERE, "Main thread was interrupted. Exception: ", e);
            // do noting, because main thread can't be interrupted
        }

        newsList = getDataThread.getNewsList();

        if (null == newsList) {
            // if list is null it means error occured
            String errorMessage = getDataThread.getErrorMessage();
            dataErrorsListener.displayError(errorMessage);
        } else {
            dataChangesListener.OnDataChanged(newsList);
        }

        synchronized (getDataThread) {
            getDataThread.notify();
        }

    }


    public interface OnDataChangesListener {

        public void OnDataChanged(ArrayList<News> jsonList);
    }

    public interface OnDataErrorsListener {

        public void displayError(String message);
    }
}
