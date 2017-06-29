package multithreading.interrupt;

/**
 * Created by user on 28.06.2017.
 */
public class Main {
    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("thread started");


                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("thread ended");
                        return;
                    }

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.out.println("thread ended - try-catch");
                        return;
                    }
                }

                //System.out.println("thread ended");
            }
        });

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupt thread");
        thread.interrupt();
    }

}
