package threads;

import java.util.logging.Logger;

/**
 * waits until DownloaderThread notifies
 * parses JSON, then let DownloaderThread download XML and wait
 * parses XML
 */
public class ParserThread extends Thread{

    private static Logger log = Logger.getLogger(DownloaderThread.class.getName());

    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
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
        parse();

        // wake up downloaderThread
        synchronized (downloaderThread) {
            downloaderThread.notifyAll();
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
        parse();
    }

    private void parse() {

    }

}
