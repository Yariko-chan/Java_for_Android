package xml;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 16.06.2017.
 */
public class MainHttpUrlConnection {

    private static final String LINK = "https://www.dropbox.com/s/71qlrpwlhduf9va/test.xml?dl=0";

    public static void main(String[] args) {

        /**
         * специально, чтобы можно было в finally закрыть
         * объявлены вне try catch
         */
        InputStream in = null;
        OutputStream out = null;

        try {
            URL url = new URL(LINK);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                in = connection.getInputStream();

                File file = new File("C:\\Users\\user\\g.diana\\test.xml");
                out = new FileOutputStream(file);

                int byteRead = -1;
                byte[] buffer = new byte[1024];
                while((byteRead = in.read(buffer)) != -1) {
                    /**
                     * нужно место, куда временно складировать инфу.
                     * нелья её хранить в инпутстриме - это оперативка!
                     * скачивать будем кусочками по buffer (зависит от мощности системы, но не программы)
                     * in.read(buffer) - вычитывает с connections количество байт = buffer и записывает в buffer
                     * возвращает количество прочтинаных байт
                     * -1 = файл кончился
                      */
                    out.write(buffer, 0, byteRead);
                    /**
                     * запиши в out из buffer начиная с 0 такое вот количество (byteRead)
                     * т. е. запишется не весь массив Buffer 1024 элемента,
                     * а только то количество, которое было считано (см. условие в while)
                     *
                      */
                }

            }


        } catch (MalformedURLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
            }

            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
