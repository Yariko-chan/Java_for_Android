package Lesson9.File;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Diana on 12.06.2017.
 */
public class FileUtils {

    public static final int SUCCESS = 0;
    public static final int ERROR_FILE = -1;

    public static int writeToFile(String fileName, String s) {
        File f = new File(fileName);

        try {
            // create file
            if (!f.exists()) {
                f.createNewFile();
            }

            FileWriter writer = new FileWriter(f, true);
            writer.write(s);
            writer.append("\n");
            writer.flush();

            System.out.println("Text successfully added to file " + fileName);
            return SUCCESS;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return ERROR_FILE;
        }

    }

    public static String readFromFile(String fileName) {
        File f = new File(fileName);

        try {
            // create file
            if (!f.exists()) {
                System.out.println("File not exists");
                return "";
            }

            FileReader reader = new FileReader(fileName);
            StringBuilder sb = new StringBuilder();
            int c;
            while ((c  = reader.read()) != -1) {
                sb.append((char) c);
            }

            System.out.println("Text from file successfully read");
            return sb.toString();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return "";
        }

    }

    public static void main(String[] args) {
        String fileName = "D:\\Users\\Diana\\Projects\\Java_for_Android\\Java_for_Android\\Homework\\src\\Lesson9\\File\\some.txt";

        System.out.println("Enter text: ");
        Scanner sc = new Scanner(System.in);
        String text =  sc.nextLine();

        int res = FileUtils.writeToFile(fileName, text);

        String fileContents = FileUtils.readFromFile(fileName);
        System.out.println(fileContents);

    }
}
