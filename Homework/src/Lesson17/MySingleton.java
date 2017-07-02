package Lesson17;

/**
 * Created by Diana on 02.07.2017.
 */
public class MySingleton {
    // задача 1 в итоговом ( Data, ParserThrad, DownloaderThread)


    // volatile Singleton для использования в многопоточном приложении
    private static volatile MySingleton instance;

    public static MySingleton getInstance() {

        if (instance == null) {
            synchronized (MySingleton.class) {
                if (instance == null)
                    instance = new MySingleton();
            }
        }
        return instance;
    }

    public void doSomething() {}

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                MySingleton instance = MySingleton.getInstance();
                instance.doSomething();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                MySingleton instance = MySingleton.getInstance();
                instance.doSomething();
            }
        });

        thread1.start();
        thread2.start();
    }
}
