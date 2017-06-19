package date_and_time;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 07.06.2017.
 */
public class DateTime {

    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat begin = new SimpleDateFormat("MMMMM d'e', h:mm a");
        System.out.println(begin.format(date));
    }
}
