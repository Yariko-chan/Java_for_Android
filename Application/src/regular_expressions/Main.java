package regular_expressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 19.06.2017.
 */
public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        String autoNumRegex = "[0-9]{4}\\s\\w{2}-[0-7]{1}";
        System.out.println("Enter auto number: ");
        String autoNum = sc.nextLine();
        stringValidation(autoNumRegex, autoNum);

        String phoneNumRegex = "(\\+375|80)(17|25|29|33|44)\\d{7}.*";
        System.out.println("Enter phone: ");
        String phoneNum = sc.nextLine();
        stringValidation(phoneNumRegex, phoneNum);

        String emailRegex = "(\\w|\\d){1,64}@[a-zA-Z_]+?\\.[a-zA-Z]{2,6}";
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        stringValidation(emailRegex, email);
     }

    private static void stringValidation(String pattern, String s) {

        Pattern p = Pattern.compile(pattern);
        if (p.matcher(s).matches()) {
            System.out.println("string matches");
        } else {
            System.out.println("string not matches");
        }
    }

    private static void phoneNumValidation() {

        // +375 (25|33|44|29|17) 7777555

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone: ");
        String phone = sc.nextLine();

        Pattern p = Pattern.compile("(\\+375|80)(17|25|29|33|44)\\d{7}.*");
        if (p.matcher(phone).matches()) {
            System.out.println("true phone number");
        } else {
            System.out.println("false phone number");
        }
    }

    private static void emailValidation() {
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
