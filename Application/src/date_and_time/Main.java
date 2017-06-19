package date_and_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by user on 05.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        // для хранения
        Date date = new Date();
        System.out.println(date.getTime());

        // для отображения
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        System.out.println(sdf.format(date));

        // для расчетов
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        System.out.println(calendar.get(GregorianCalendar.DATE));
        System.out.println(calendar.get(GregorianCalendar.MONTH));
        System.out.println(calendar.get(GregorianCalendar.YEAR));
        System.out.println(calendar.get(GregorianCalendar.DAY_OF_WEEK));
        calendar.setFirstDayOfWeek(Calendar.SATURDAY);
        System.out.println(calendar.get(GregorianCalendar.DAY_OF_WEEK));
    }
}
