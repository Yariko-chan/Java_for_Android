package Lesson10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by user on 12.06.2017.
 */
public class FileWorks {
    public static void main(String[] args) {
        String fileName = "D:\\Users\\Diana\\Projects\\Java_for_Android\\Java_for_Android\\Homework\\src\\Lesson10\\some.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            String s;
            int i = 0;
            while((s = in.readLine()) != null) {
                String[] parts = s.split("[|]");
                if (parts.length != 3) throw new ParseException("Error splitting file", 0);
                String name =  parts[0];
                int age = Integer.valueOf(parts[1]);
                boolean gender = Boolean.valueOf(parts[2]);

                Human human = new Human(name, age, gender);
                System.out.println(human.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException");
        } catch (NumberFormatException e) {
            System.out.println("Error parsing file");
        } catch (ParseException e) {
            System.out.println("Error splitting file");
        }
    }

    private static class Human {
        private String name;
        private int age;
        private boolean gender; // male = true

        public Human(String name, int age, boolean gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Human{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}
