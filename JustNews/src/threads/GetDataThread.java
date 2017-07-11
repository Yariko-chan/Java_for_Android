package threads;

import entities.News;
import entities.Root;
import main.Controller;
import parsers.JSONParser;
import parsers.Parser;
import parsers.XMLParser;

import javax.swing.*;
import javax.xml.ws.http.HTTPException;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
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
    private final Controller.FileMode fileMode;
    private final Runnable completionHandler;
    private final Runnable errorHandler;

    // result
    private ArrayList<News> newsList;

    private String errorMessage = "Unknown error";

    public GetDataThread(Controller.FileMode fileMode, Runnable completionHandler, Runnable errorHandler) {
        this.fileMode = fileMode;
        this.completionHandler = completionHandler;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {

        // select link and file name
        String link = (fileMode == Controller.FileMode.JSON_MODE) ? JSON_LINK : XML_LINK;
        String fileName = (fileMode == Controller.FileMode.JSON_MODE) ? JSON_FILE_NAME : XML_FILE_NAME;

        try {
            // download file
            downloadFile(link, fileName);

            // parse
            parseFile();

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
            errorMessage = "Невозможно получить доступ: " + e.getLocalizedMessage() +
                    "\n " + "Возможно, отсутствует подключние к Интернету";
            throw e;
        } catch (ConnectException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Сайт недоступен: " + e.getLocalizedMessage();
            throw e;
        } catch (MalformedURLException e){
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Внутренняя ошибка: " + e.getLocalizedMessage();
            throw e;
        } catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Внутренняя ошибка: " + e.getLocalizedMessage();
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
                errorMessage = "Внутренняя ошибка: " + e.getLocalizedMessage();
                throw e;
            }
        }
    }

    private void parseFile()  throws IOException{
        // select file and parser
        Parser parser = (fileMode == Controller.FileMode.JSON_MODE) ? new JSONParser() : new XMLParser();
        String fileName = (fileMode == Controller.FileMode.JSON_MODE) ? JSON_FILE_NAME : XML_FILE_NAME;

        // parse
        Root root = null; // all file
        try {
            root = parser.parse(fileName);
            newsList = root.getNews(); // we need only news List
        } catch (IOException e) {
            // catch exception, log and throw again
            log.log(Level.SEVERE, "Exception: ", e);
            errorMessage = "Внутренняя ошибка: " + e.getLocalizedMessage();
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
