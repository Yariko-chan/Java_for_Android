package Lesson8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Diana on 12.06.2017.
 */
public class DateTasks {

    public static void main(String[] args) {
        task3();
        System.out.println();
        task4();
    }

    private static void task4() {
        String s = "2017-06-05 20:25";
        SimpleDateFormat parseSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d = parseSdf.parse(s);
            SimpleDateFormat printSdf = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
            System.out.println(printSdf.format(d));
        } catch (ParseException e) {
            System.out.println("Error parsing string");
        }
    }

    private static void task3() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("LLLL d'е', h:mm a"); // LLLL is month in nominative case
        System.out.println("Today is ");
        System.out.println(sdf.format(d));
    }
}
