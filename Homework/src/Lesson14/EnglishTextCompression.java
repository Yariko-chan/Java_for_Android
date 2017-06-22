package Lesson14;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Diana on 22.06.2017.
 */
public class EnglishTextCompression {
    /**
     * С помощью регулярных выражений осуществить сжатие английского текста,
     * заменив каждую группу из двух или более рядом стоящих символов на один символ,
     * за которым следует количество его вхождений в группу.
     * К примеру, строка hellowoooorld должна сжиматься в hel2owo4rld.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("This program compresses your string \n" +
                "in a way to replace group of similar letter with one and count of that letter, \n" +
                "e.g hellowoooorld will be compressed to hel2owo4rld\n");
        System.out.println("Enter string in roman alphabet: ");
        String text = sc.nextLine();
        String result = compress(text);
        System.out.println(result);
    }

    private static String compress(String text) {
        String result = text;

        Pattern p = Pattern.compile("([a-z])(\\1)+");
        Matcher m = p.matcher(result);
        while(m.find()){
            char letter = result.charAt(m.start());
            int letterCount = m.end()-m.start();
            result = result.replace(m.group(), String.valueOf(letter) + letterCount);
        }

        return result;
    }
}
