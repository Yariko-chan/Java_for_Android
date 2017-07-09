package main;

import entities.News;
import threads.DownloaderThread;
import threads.ParserThread;

import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private ArrayList<News> newsList;

    private final OnDataChangesListener listener;

    public Data(OnDataChangesListener listener, Controller.FileMode currentFileMode) {
        this.listener = listener;
        getData(currentFileMode);
    }

    private void getData(Controller.FileMode currentFileMode) {

        /**
         * Parser                    |     Data(main)            | Download
         * --------------------------------------------------------------------------
         *                           |   <-   start   ->         |
         * wait()                    | wait()                    | download JSON/XML
         *                           |                           | parserThread.notify()
         * parse JSON/XML            |                           | [END]
         * mainThread.notify()       |                           |
         * wait()                    | parseThread.getNewsList() |
         *                           | parseThread.notify()      |
         * [END]                     | ...                       |
         */

        Thread currentThread = Thread.currentThread();
        DownloaderThread downloadThread = new DownloaderThread(currentFileMode);
        ParserThread parserThread = new ParserThread(currentFileMode);

        downloadThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloadThread);
        parserThread.setMainThread(currentThread);

        downloadThread.start();
        parserThread.start();
        try {
            synchronized (currentThread) {
                currentThread.wait();
            }

        } catch (InterruptedException e) {
            // TODO handle exception
            e.printStackTrace();
        }
        newsList = parserThread.getNewsList();
        synchronized (parserThread) {
            parserThread.notify();
        }
        listener.OnDataChanged(newsList);
    }


    public interface OnDataChangesListener {

        public void OnDataChanged(ArrayList<News> jsonList);
    }
}
