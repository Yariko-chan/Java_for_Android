package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by user on 28.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        /**
         * reflection API - enables us to analyze class
         * overloads system, so better avoid
         */

        TestClass testClass = new TestClass();

        Class clas = testClass.getClass(); // enables to analyse object
        System.out.println(clas.getName());
        System.out.println(clas.getSimpleName());

        int mode = clas.getModifiers();
        if (Modifier.isPublic(mode)) {
            System.out.println("public class");
        }
        if (Modifier.isAbstract(mode)) {
            System.out.println("abstract class");
        }

        Method[] methods = clas.getDeclaredMethods();
        for (Method m: methods) {
            System.out.println(m.getReturnType() + " " + m.getName());
        }



        Field[] fields = clas.getDeclaredFields();
        for (Field f: fields) {
            System.out.println(f.getType() + " " + f.getName());
        }

        // get and set value of private field

        try {
            int a = fields[0].getInt(testClass);
            fields[1].setAccessible(true);
            String s = (String) fields[1].get(testClass);
            System.out.println(a);
            System.out.println(s);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            fields[0].setInt(testClass, 10);
            fields[1].set(testClass, "other string");
            System.out.println(testClass.getA());
            System.out.println(testClass.getText());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
