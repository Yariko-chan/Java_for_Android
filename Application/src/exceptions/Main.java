package exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by user on 12.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        main.method(new Exception()); // <- какая и реализаций вызовется?
    }

    public void method(Object o) {

    }

    public void method(IOException e) {

    }

    public void method(FileNotFoundException e) {
        // вызовется этот, потому что самый частный, самый дочерний (дочерний для ио)
        // потому что, как и расположение catch, проверяет в порядке от самых узких к самым общим
    }
}
