package multithreading;

/**
 * Created by user on 26.06.2017.
 */
public class ThreadAnonymous {

    public static void main(String[] args) {
        thread();

    }

    private static void thread() {
        // можно отнаследоваться от thread,
        // можно реализовaть интерфейс runnable
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // всё что тут будет выполняться во второстепнном потоке, а не в главном

                for (int i = 0; i < 50; i++) {
                    System.out.println("1 ");
                }
            }
        });
        thread.start();
        for (int i = 10; i < 200; i++) {
            System.out.println("0 ");
        }
        // программа не остановится пока не закрошь поток!
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                // всё что тут будет выполняться во второстепнном потоке, а не в главном

                for (int i = 0; i < 50; i++) {
                    System.out.println("2 ");
                }
            }
        });
        thread2.start();
    }

}
