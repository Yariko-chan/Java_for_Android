package multithreading.homework2806;

/**
 * Created by user on 28.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        // new DownloaderThread.start
        // new ParserThread.start
        DownloaderThread downloadThread = new DownloaderThread();
        ParserThread parserThread = new ParserThread();

        downloadThread.setParserThread(parserThread);
        parserThread.setDownloaderThread(downloadThread);

        downloadThread.start();
    }


}
