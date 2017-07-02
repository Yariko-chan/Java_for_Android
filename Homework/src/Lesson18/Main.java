package Lesson18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 28.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Class clas = testClass.getClass();

        Field[] fields = clas.getDeclaredFields();
        System.out.println("Fields: ");
        for (Field f: fields) {
            System.out.println(f.getType() + " " + f.getName());
        }
        System.out.println();

        try {
            // get value of public field
            int a = fields[0].getInt(testClass);
            System.out.println("BEFORE: int a =  " + a);

            // set value of public field
            fields[0].setInt(testClass, 10);
            System.out.println("AFTER: int a =  " + testClass.getA());



            // get value of private field
            fields[1].setAccessible(true);
            String s = (String) fields[1].get(testClass);
            System.out.println("BEFORE: String s =  " + s);

            // set value of private field
            fields[1].set(testClass, "other string");
            System.out.println("AFTER: String s =  " + testClass.getText());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
