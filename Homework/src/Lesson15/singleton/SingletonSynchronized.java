package Lesson15.singleton;

/**
 * Created by Diana on 26.06.2017.
 */
public class SingletonSynchronized {

    // + ленивая
    // - низкая производительность

    private static SingletonSynchronized instance;

    public static synchronized SingletonSynchronized getInstance() {
        if (null == instance) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}
