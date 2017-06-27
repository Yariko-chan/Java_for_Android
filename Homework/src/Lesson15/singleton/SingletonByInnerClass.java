package Lesson15.singleton;

/**
 * Created by Diana on 26.06.2017.
 */
public class SingletonByInnerClass {

    // + ленивая
    // + высокая производительность
    // - нельзя использовать для нестатических полей

    public SingletonByInnerClass() {
    }

    private static class SingletonHolder {
        private final static SingletonByInnerClass instance
                = new SingletonByInnerClass();
    }

    public static SingletonByInnerClass getInstance() {
        return SingletonHolder.instance;
    }
}
