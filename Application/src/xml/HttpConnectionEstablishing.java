package xml;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by user on 16.06.2017.
 */
public class HttpConnectionEstablishing {

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
                     * temporary storage for info required
                     * saving in InputStream will cause big operative memory usage
                     * downloading piece by piece size of buffer (depends on user system, not on your program)
                     * in.read(buffer) - reads from @connection count of bytes = sizeof(buffer) and writes to buffer
                     * returns count of readed bytes (may be less than sizeof(buffer because of error of EOF)
                     * -1 = EOF
                      */
                    out.write(buffer, 0, byteRead);
                    /**
                     * write to @out from @buffer starting from 0 [byteRead] count of bytes
                     * will be writed not all 1024 elements from @buffer,
                     * but the readed count only(see while),other elements can be null or can store old info
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
