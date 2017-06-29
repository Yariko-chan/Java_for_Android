package multithreading.homework2806;

/**
 * Created by user on 28.06.2017.
 */
public class DownloaderThread extends Thread {
    // start
    // downloaded file
    // wait
    // tell parser to start
    // wait from parser command to start
    // etc
    ////////////////////////////

    private ParserThread parserThread;

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }

    @Override
    public void run() {

        try {

            parserThread.start();

            // download JSON
            System.out.println("Download thread - download JSON");
            Thread.sleep(5000);

            // wake Parser
            synchronized (parserThread) {
                System.out.println("Download thread - wake Parser");
                parserThread.notifyAll();
            }
            synchronized (this) {
                // and wait
                System.out.println("Download thread - and wait");
                wait();
            }

            //------------------------------------------------------------

            // download XML
            System.out.println("Download thread - download XML");
            Thread.sleep(5000);

            // wake Parser
            synchronized (parserThread) {
                System.out.println("Download thread - wake Parser");
                parserThread.notifyAll();
            }

           /* synchronized (this) {
                // and wait
                System.out.println("Download thread - and wait");
                wait();
            }*/

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("DownloadThread - end");
    }
}
