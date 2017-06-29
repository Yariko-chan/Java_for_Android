package multithreading.synch2;

/**
 * Created by user on 26.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();

        try {
            thread.join(); // ждёт пока поток не умрёт, и только тогда продолжает работу+
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void print10() {
        // synchronized (Main.class) // захватывает весь класс
        synchronized (this) {// захватывает только один объект
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }
    }
}