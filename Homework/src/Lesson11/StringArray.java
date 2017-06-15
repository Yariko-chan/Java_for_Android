package Lesson11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Diana on 15.06.2017.
 */
public class StringArray {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter strings for array(enter 'q' for exit):");

        // input list
        Scanner sc = new Scanner(System.in);
        String s;
        while(!(s = sc.nextLine()).equals("q")) {
            list.add(s);
        }
        System.out.println(list.toString());

        // delete all 'a' from string
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).replaceAll("a", ""));
        }
        System.out.println(list.toString());

        // delete duplicates
        for (int i = list.size() - 1; i >=0; i--) {
            String currentString = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).equals(currentString)) {
                    list.remove(j);
                }
            }
        }
        System.out.println(list.toString());
    }
}
