package Lesson18;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 28.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();
        Class clas = testClass.getClass();

        // print all fields of class
        Field[] fields = clas.getDeclaredFields();
        System.out.println("Fields: ");
        for (Field f: fields) {
            System.out.println(f.getType() + " " + f.getName());
        }
        System.out.println();

        try {
            System.out.println("Changing fields: ");

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
            System.out.println();

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        Method[] methods = clas.getDeclaredMethods();
        System.out.println("Methods: ");
        for (Method m: methods) {
            System.out.print("method " + m.getName() + ": ");
            m.setAccessible(true);
            try {
                m.invoke(testClass);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
