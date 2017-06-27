package patterns.singletone;

/**
 * Created by user on 21.06.2017.
 */
/*public class Controller {

//
// + ленивая инициализация
// - низкая производительность
// - непотокобезопасный вариант
//    private static Controller controller;
//
//    private Controller() {
//    }
//
//    public static Controller getInstance() {
//        if (controller == null) {
//            controller = new Controller();
//        }
//        return controller;
//    }


     + потокобезопасно
     - неленивая инициализация,
     - нельзя инициализировать объект какими-то перменными
    private static Controller controller = new Controller();

    private Controller() {
    }

    public static Controller getInstance() {
        return controller;
    }
}*/

public enum Controller {

    // - неленивая
    INSTANCE();

    private Controller() {

    }

    public void test() {

    }
}
