package multithreading.thread2;

/**
 * Created by user on 26.06.2017.
 */
public class MyThread extends Thread{

    private boolean isFinish = false;

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            // просто проверяет
            if (isInterrupted()) {
                System.out.println("stop1");
                return;
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("stop2");
                return;
            }
        }
    }
}
