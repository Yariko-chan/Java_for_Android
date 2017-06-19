package regular_expressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        String text = "2017 AB-7";
        // 4 числовых знака 2 буквы 1 цифра 1..7

        Pattern p = Pattern.compile("[0-9]{4}\\s\\w{2}-[0-7]{1}");
        Matcher m = p.matcher(text);
        if (m.matches()) {
            System.out.println("true auto num");
        } else {
            System.out.println("false auto num");
        }
    }
}
