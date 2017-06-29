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
         *
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

        Field[] fields = clas.getDeclaredFields();
        for (Field f: fields) {
            System.out.println(f.getType() + " " + f.getName());
        }

        Method[] methods = clas.getDeclaredMethods();
        for (Method m: methods) {
            System.out.println(m.getReturnType() + " " + m.getName());
        }
    }
}
