package Lesson16;

/**
 * Created by Diana on 29.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        thread1.start();
        MyThread thread2 = new MyThread();
        thread2.start();
    }

    public synchronized static void print10(int[] ar) {
        for (int num: ar) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                int[] ar = new int[10];
                for (int j = 0; j < ar.length; j++) {
                    ar[j] = i*10 + j;
                }
                print10(ar);
            }
        }
    }
}
