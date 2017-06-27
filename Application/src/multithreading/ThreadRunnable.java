package multithreading;

/**
 * Created by user on 26.06.2017.
 */
public class ThreadRunnable implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadRunnable());
        thread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("1 ");
        }
        // в отдельном потоке нельзя работать с интерфейсом. ВЕСЬ ИНТЕРФЕЙС В ГЛАВНОМ ПОТОКЕ
    }
}
