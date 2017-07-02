package threads;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Downloads JSON first and lets ParserThread parse JSON
 * then waits until parser wake this thread
 * then downloads XML and lets ParserThread parse XML
 */
public class DownloaderThread extends Thread {
    public static final String JSON_LINK = "http://kiparo.ru/t/it_news.json";
    public static final String XML_LINK = "http://kiparo.ru/t/it_news.xml";
    public static final String FILE_DIR_NAME = "\\JustNews\\";
    public static final String JSON_FILE_NAME = "news.json";
    public static final String XML_FILE_NAME = "news.xml";

    private static Logger log = Logger.getLogger(DownloaderThread.class.getName());

    private ParserThread parserThread; // may be null!

    public void setParserThread(ParserThread parserThread) {
        this.parserThread = parserThread;
    }

    @Override
    public void run() {

        // download JSON
        downloadFile(JSON_LINK, JSON_FILE_NAME);

        // wake Parser
        synchronized (parserThread) {
            parserThread.notify();
        }
        synchronized (this) {
            // and wait
            try {
                wait();
            } catch (InterruptedException e) {
                log.info("DownloaderThread was interrupted");
                Thread.currentThread().interrupt();// is it correct handling?
            }
        }

        //------------------------------------------------------------

        // download XML
        downloadFile(XML_LINK, XML_FILE_NAME);

        // wake Parser
        synchronized (parserThread) {
            parserThread.notify();
        }
    }

    private void downloadFile(String link, String fileName) {
        InputStream in = null;
        OutputStream out = null;
        URL url;

        try {
            url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK != response) {
                log.log(Level.SEVERE, "Http response = " + response);
                // TODO: some interface reaction
                return;
            } else {
                in = connection.getInputStream();

                File file = new File(FILE_DIR_NAME + fileName);
                if (!file.exists()) {
                    File dir = new File(FILE_DIR_NAME);
                    dir.mkdir();
                    file.createNewFile();
                }
                out = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while((byteRead = in.read(buffer)) != -1) {
                    // reads to buffer from connection
                    // writes to out from buffer
                    out.write(buffer, 0, byteRead);
                }
            }
        } catch (MalformedURLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            // TODO: some interface reaction
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            // TODO: some interface reaction (error with internet?)
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }

            } catch (IOException e) {
                log.log(Level.SEVERE, "Exception: ", e);
                // TODO: some interface reaction (error closing file)
            }
        }
    }
}
