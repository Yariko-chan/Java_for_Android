package Lesson15.singleton;

/**
 * Created by Diana on 26.06.2017.
 */
public class SingletonVolatileDoubleChacked {

    private static volatile SingletonVolatileDoubleChacked instance;

    public static SingletonVolatileDoubleChacked getInstance() {
        SingletonVolatileDoubleChacked localInstance = instance;

        if(null == localInstance) {
            synchronized (SingletonVolatileDoubleChacked.class) {
                localInstance = instance;
                if (null == localInstance) {
                    instance = localInstance = new SingletonVolatileDoubleChacked();
                }
            }
        }

        return localInstance;
    }
}
