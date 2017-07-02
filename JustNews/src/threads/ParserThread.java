package threads;

import entities.News;
import entities.Root;
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

    private DownloaderThread downloaderThread;
    private Thread mainThread;
    private ArrayList<News> jsonList;
    private ArrayList<News> xmlList;

    private static Logger log = Logger.getLogger(DownloaderThread.class.getName());

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
        parseJSON();

        // wake up downloaderThread
        synchronized (downloaderThread) {
            downloaderThread.notify();
        }

        // sleep
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("ParserThread was interrupted");
                Thread.currentThread().interrupt();
            }
        }

        //------------------------------------
        // wake up, parse
        parseXML();

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

    private void parseXML() {
        // TODO check xml and json valid
        Parser parser = new XMLParser();
        try {
            Root root = parser.parse(XML_FILE_NAME);
            xmlList = root.getNews();
        } catch (IOException e) {
            // TODO handle xception
        }
    }

    private void parseJSON() {
        Parser parser = new JSONParser();
        try {
            Root root = parser.parse(JSON_FILE_NAME);
            jsonList = root.getNews();
        } catch (IOException e) {
            // TODO handle xception
        }
    }

    public ArrayList<News> getJsonList() {
        return jsonList;
    }

    public ArrayList<News> getXmlList() {
        return xmlList;
    }
}
