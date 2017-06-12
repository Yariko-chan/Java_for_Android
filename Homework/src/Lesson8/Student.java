package Lesson8;

import com.sun.org.apache.xerces.internal.util.XMLStringBuffer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Diana on 11.06.2017.
 */
public class Student {
    public static final boolean MALE = true;
    public static final boolean FEMALE = false;

    private static final int SUCCESS = 0;
    private static final int ERROR_DATA_PARSE = 0;

    private static final String[] YEAR_FORMS =
            {"год", "года", "лет"};
    private static final String[] MONTH_FORMS =
            {"месяц", "месяца", "месяцев"};
    private static final String[] DAY_FORMS =
            {"день", "дня", "дней"};
    private static final String[] HOUR_FORMS =
            {"час", "часа", "часов"};
    private static final String[] MINUTE_FORMS =
            {"минута", "минуты", "минут"};

    private String name;
    private boolean gender;
    private Date birthDate;

    public Student(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    /**
     *
     * @param s date in String format "dd.MM.yyyy"
     * @return ERROR_DATA_PARSE if  error parsing @s occured
     *         SUCCESS if date successfully parsed
     */
    private int setBirthDate(String s) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            birthDate = sdf.parse(s);
            return SUCCESS;
        } catch (ParseException e) {
            return ERROR_DATA_PARSE;
        }
    }

    private void setGender(int i) {
        if (i > 0) gender = MALE;
        else gender = FEMALE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter count of students: ");
        int count = sc.nextInt();

        Student[] st = new Student[count];

        // filling the array from console
        System.out.println("Enter data for students: ");
        for (int i = 0; i < count; i++) {
            sc = new Scanner(System.in);
            System.out.println((i + 1) + ": ");

            System.out.println("Name                                : ");
            st[i] = new Student(sc.nextLine());

            int err;
            do { /* try until string parsed correctly */
                System.out.println("Birth date (in format \"dd.mm.yyyy\"): ");
                err = st[i].setBirthDate(sc.nextLine());
            } while (err != SUCCESS);

            System.out.println("Gender (0 for female, 1 for male)   : ");
            st[i].setGender(sc.nextInt());
        }

        // find the average
        GregorianCalendar averageAge = findAverageAge(st);
        System.out.println("Average age is: ");
        System.out.println(dateToString(averageAge));
    }

    /**
     * returns average age of array of Students
     */
    private static GregorianCalendar findAverageAge(Student[] st) {
        long aveDate = 0L;

        // find average date of birth
        for (int i = 0; i < st.length; i++) {
            aveDate += st[i].getBirthDate().getTime();
        }
        aveDate = aveDate/st.length;

        GregorianCalendar d1 = new GregorianCalendar();
        d1.setTime(new Date(aveDate));
        GregorianCalendar d2 = new GregorianCalendar();
        d2.setTime(new Date());

        d2.add(Calendar.YEAR, -d1.get(Calendar.YEAR));
        d2.add(Calendar.MONTH, -d1.get(Calendar.MONTH));
        d2.add(Calendar.DAY_OF_MONTH, -d1.get(Calendar.DAY_OF_MONTH) + 1);
        return d2;
    }

    /**
     * @param c date/time in GregorianCalendar
     * @return String like [50 лет 3 месяца 5 дней 10 часов и 5 минут]
     */
    private static String dateToString(GregorianCalendar c) {

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int days = c.get(Calendar.DAY_OF_MONTH);
        int hours = c.get(Calendar.HOUR);
        int minutes = c.get(Calendar.MINUTE);

        StringBuilder date = new StringBuilder();
        date.append(getTimeUnitsString(year, YEAR_FORMS)).append(" ");
        date.append(getTimeUnitsString(month, MONTH_FORMS)).append(" ");
        date.append(getTimeUnitsString(days, DAY_FORMS)).append(" ");
        date.append(getTimeUnitsString(hours, HOUR_FORMS)).append(" ");
        date.append(getTimeUnitsString(minutes, MINUTE_FORMS));
        return date.toString();
    }

    /**
     *  function to find correct form of time unit word depending on it's count
     *  e. g. 1 день, 5 дней и т. д.
     * @param count - count of time units
     * @param timeUnitsForms - array of 3 forms of word:
     *                       [0] - if count = 1 (1 день)
     *                       [1] - if count=[2;4] (2 дня)
     *                       [2] - others (25 дней)
     * @return String from count and time unit in correct form ["5 дней"]
     */
    private static String getTimeUnitsString(int count, String[] timeUnitsForms) {
        int suffix = count%100; // last two numbers

        if (suffix >= 5 && suffix <= 20) {
            return count + " " + timeUnitsForms[2];
        }
        suffix = suffix%10;
        if (suffix == 1) {
            return count + " " + timeUnitsForms[0];
        } else if (suffix >= 2 && suffix <= 4) {
            return count + " " + timeUnitsForms[1];
        } else {
            return count + " " + timeUnitsForms[2];
        }
    }

}
