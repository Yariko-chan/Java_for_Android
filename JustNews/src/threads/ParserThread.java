package threads;

import entities.News;
import entities.Root;
import main.Controller;
import parsers.JSONParser;
import parsers.Parser;
import parsers.XMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * waits until DownloaderThread notifies
 * parses JSON, then let DownloaderThread download XML and wait
 * parses XML
 */
public class ParserThread extends Thread{
    public static final String JSON_FILE_NAME = "\\JustNews\\news.json";
    public static final String XML_FILE_NAME = "\\JustNews\\news.xml";

    // JSON or XML
    private final Controller.FileMode currentFileMode;

    private DownloaderThread downloaderThread;
    private Thread mainThread;
    private ArrayList<News> jsonList;
    private ArrayList<News> newsList;

    private static Logger log = Logger.getLogger(DownloaderThread.class.getName());

    public ParserThread(Controller.FileMode currentFileMode) {
        this.currentFileMode = currentFileMode;
    }

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }

    public void setMainThread(Thread mainThread) {
        this.mainThread = mainThread;
    }

    @Override
    public void run() {
        // sleep
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("ParserThread was interrupted");
                Thread.currentThread().interrupt();
            }
        }

        // wake up, parse
        parseFile();

        // wake up main
        synchronized (mainThread) {
            mainThread.notify();
        }

        // wait until main gets data and then interrupts or notifies, then interrupt inside
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("ParserThread was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }

    private void parseFile() {
        // TODO check xml and json valid

        // select file and parser
        Parser parser = (currentFileMode == Controller.FileMode.JSON_MODE) ? new JSONParser() : new XMLParser();
        String fileName = (currentFileMode == Controller.FileMode.JSON_MODE) ? JSON_FILE_NAME : XML_FILE_NAME;

        // parse
        try {
            Root root = parser.parse(fileName);
            newsList = root.getNews();
        } catch (IOException e) {
            // TODO handle xception
        }
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }
}
