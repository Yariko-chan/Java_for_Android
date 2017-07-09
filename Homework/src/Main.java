import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Diana on 09.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        String date = "2014-10-25 12:35:00 +0300";
        DateFormat parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
        try {
            Date d = parse.parse(date);
            SimpleDateFormat printSdf = new SimpleDateFormat("dd MMMM yyyy, HH:mm");
            System.out.println(printSdf.format(d));
        } catch (ParseException e) {
            System.out.println("Error parsing string");
        }
    }
}
