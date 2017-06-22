package patterns.singletone;

/**
 * Created by user on 21.06.2017.
 */
public class Controller {
    /*private static Controller controller;

    private Controller() {
    }

    private int test;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }*/
    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }
}
