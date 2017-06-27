package multithreading.thread1;

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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
