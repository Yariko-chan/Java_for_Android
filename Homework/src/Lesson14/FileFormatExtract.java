package Lesson14;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Diana on 22.06.2017.
 */
public class FileFormatExtract {
    /**
     * С помощью регулярных выражений написать функцию которая будет выводить формат файла,
     * например ввел kjhkj.xml  - в итоге нам выведет формат xml.
     * Т. e. нужно обрезать все символы после последней точки.
     * Также отдельно сделать проверку файла на формат.
     * Например ввели sfdsgs.txt и нужно проверить это формат xml или json, если что-то другое, то вывести ошибку.
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter file name: ");
        String fileName = sc.nextLine();

        String xml = "(.*).(xml|XML)";
        String json = "(.*).(json|JSON)";
        if (Pattern.compile(xml).matcher(fileName).matches()) {
            System.out.println("XML file");
        } else if (Pattern.compile(json).matcher(fileName).matches()) {
            System.out.println("JSON file");
        } else {
            System.out.println("unknown file");
        }
    }
}
