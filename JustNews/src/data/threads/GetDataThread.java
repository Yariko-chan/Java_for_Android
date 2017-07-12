package data.threads;

import data.entities.News;
import data.entities.Root;
import data.parsers.JSONParser;
import data.parsers.Parser;
import data.parsers.XMLParser;
import utils.FileMode;
import utils.Period;
import utils.SortMode;

import javax.swing.*;
import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Downloads file (XML or JSON depending on parameter in constructor)
 * parses downloaded file
 *
 */
public class GetDataThread extends Thread {
    public static final String JSON_LINK = "http://kiparo.ru/t/it_news.json";
    public static final String XML_LINK = "http://kiparo.ru/t/it_news.xml";
    public static final String FILE_DIR_NAME = "\\JustNews\\";
    public static final String JSON_FILE_NAME = "\\JustNews\\news.json";
    public static final String XML_FILE_NAME = "\\JustNews\\news.xml";

    // log any errors
    private static Logger log = Logger.getLogger(GetDataThread.class.getName());

    // JSON or XML
    private final FileMode fileMode;
    private final Runnable completionHandler;
    private final Runnable errorHandler;
    private SortMode currentSortMode;
    private Period currentPeriod;

    // result
    private ArrayList<News> newsList;

    private String errorMessage = "Unknown error";

    public GetDataThread(FileMode fileMode, Runnable completionHandler, Runnable errorHandler) {
        this.fileMode = fileMode;
        this.completionHandler = completionHandler;
        this.errorHandler = errorHandler;
    }

    // not necessary field
    public void setCurrentSortMode(SortMode currentSortMode) {
        this.currentSortMode = currentSortMode;
    }

    // not necessary field
    public void setCurrentPeriod(Period currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public class Builder {

    }

    @Override
    public void run() {

        // select link and file name
        String link = (fileMode == FileMode.JSON_MODE) ? JSON_LINK : XML_LINK;
        String fileName = (fileMode == FileMode.JSON_MODE) ? JSON_FILE_NAME : XML_FILE_NAME;

        try {
            // download file
            downloadFile(link, fileName);

            // parse
            parseFile();

            // filter by date
            if (null != currentPeriod) News.filter(newsList, currentPeriod);

            // get comparator
            Comparator<News> comparator = (SortMode.KEYS_MODE == currentSortMode)
                    ? News.keysComparator
                    : News.dateComparator; // date by default
            // return sorted list
            newsList.sort(comparator);

            SwingUtilities.invokeLater(completionHandler);
        } catch (HTTPException | IOException e) {
            // if errors occured, nothing to do, just end thread
            // catch error here to be able to exit thread
            SwingUtilities.invokeLater(errorHandler);
            return;
        }
    }

    private void downloadFile(String link, String fileName) throws IOException {
        InputStream in = null;
        OutputStream out = null;
        URL url;

        try {
            url = new URL(link);

            // establish connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK != response) {
                log.log(Level.SEVERE, "Http response = " + response);
                errorMessage = "Http response = " + response + " " + connection.getResponseMessage();
                throw new HTTPException(response);
            } else {
                in = connection.getInputStream();

                // create file
                File file = new File(fileName);
                if (!file.exists()) {
                    File dir = new File(FILE_DIR_NAME);
                    dir.mkdir();
                    file.createNewFile();
                }
                out = new FileOutputStream(file);

                // write to file
                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while ((byteRead = in.read(buffer)) != -1) {
                    // reads to buffer from connection
                    // writes to out from buffer
                    out.write(buffer, 0, byteRead);
                }
            }
            // catch all exceptions, log and throw again
            // (will be catched in run())
            // close connection and file in finally
        } catch (HTTPException e) {
            throw e;
        } catch (UnknownHostException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Unable to access: " + e.getMessage() +
                    "\n " + "Perhaps, no internet connection";
            throw e;
        } catch (ConnectException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Host cannot be found: " + e.getMessage();
            throw e;
        } catch (MalformedURLException e){
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Internal error: " + e.getMessage();
            throw e;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Internal error: " + e.getMessage();
            throw e;
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
                errorMessage = "Internal error: " + e.getMessage();
                throw e;
            }
        }
    }

    private void parseFile()  throws IOException{
        // select file and parser
        Parser parser = (fileMode == FileMode.JSON_MODE) ? new JSONParser() : new XMLParser();
        String fileName = (fileMode == FileMode.JSON_MODE) ? JSON_FILE_NAME : XML_FILE_NAME;

        // parse
        Root root = null; // all file
        try {
            root = parser.parse(fileName);
            newsList = root.getNews(); // we need only news List
        } catch (IOException e) {
            // catch exception, log and throw again
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Internal error: " + e.getMessage();
            throw e;
        }
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
