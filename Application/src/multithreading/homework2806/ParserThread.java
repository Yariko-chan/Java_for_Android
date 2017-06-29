package multithreading.homework2806;

/**
 * Created by user on 28.06.2017.
 */
public class ParserThread extends Thread{

    // wait

    // start
    // parsed xml
    // wait
    // tell downloader to start
    // etc
    ///////////////////////////////////

    private DownloaderThread downloaderThread;

    public void setDownloaderThread(DownloaderThread downloaderThread) {
        this.downloaderThread = downloaderThread;
    }

    @Override
    public void run() {
        try {

            // sleep
            synchronized (this) {
                System.out.println("                                                    ParserThread - wait()");
                wait();
            }

            // wake up, parse
            System.out.println("                                                    ParserThread - parse JSON");
            Thread.sleep(5000);

            // wake up downloaderThread
            System.out.println("                                                    ParserThread - wake up downloaderThread");
            synchronized (downloaderThread) {
                downloaderThread.notifyAll();
            }

            // sleep
            synchronized (this) {
                System.out.println("                                                    ParserThread - wait");
                wait();
            }

            //------------------------------------
            // wake up, parse
            System.out.println("                                                    ParserThread - parse XML");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("                                                    ParserThread - end");
    }

}
