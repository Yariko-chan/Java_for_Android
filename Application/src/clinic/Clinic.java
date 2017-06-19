package clinic;

import java.util.Scanner;

/**
 * Created by user on 31.05.2017.
 */
public class Clinic {

    public static void main(String[] args) {
        Patient p = new Patient();
        Doctor d = new Doctor(5, "m,jh,j");

        Man m;
        m = new Patient();
        callMyAbstract(m);
        // объект Human определён через Patient (откуда взять реализацию myAbstract)
        // но доступа к методам и полям Patient нет!
        // пришлось бы делать два метода в каждом из классов
        m = new Doctor();
        callMyAbstract(m);
    }

    public static void callMyAbstract(Man m) {
        m.myAbstractMethod();
    }
}
