package main;

import entities.News;
import threads.DownloaderThread;
import threads.ParserThread;

import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Data {
    private ArrayList<News> jsonList;
    private ArrayList<News> xmlList;

    private final OnDataChangesListener listener;

    public Data(OnDataChangesListener listener) {
        this.listener = listener;
        getData();
    }

    private void getData() {

        /**
         * Parser                    |     Data(main)        | Download
         * --------------------------------------------------------------------------
         *                           |   <-   start   ->     |
         * wait()                    | wait()                | download JSON
         *                           |                       | parserThread.notify()
         * parse JSON                |                       | wait()
         * downloaderThread.notify() |                       |
         * wait()                    |                       | download XML
         *                           |                       | [END]
         * parse XML                 |                       |
         * mainThread.notify()       |                       |
         * wait()                    | parseThread.getJSON() |
         *                           | parseThread.getXML()  |
         *                           | parseThread.notify()  |
         * [END]                     | ...                   |
         */

        Thread currentThread = Thread.currentThread();
        DownloaderThread downloadThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();

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
        jsonList = parserThread.getJsonList();
        xmlList = parserThread.getXmlList();
        synchronized (parserThread) {
            parserThread.notify();
        }
    }


    public interface OnDataChangesListener {

        public void OnDataChanged();
    }
}
