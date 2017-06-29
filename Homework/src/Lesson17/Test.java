package Lesson17;

/**
 * Created by Diana on 29.06.2017.
 */
public class Test {

    private int a = 5;

    public int getA() {
        return a;
    }

    public synchronized void changeA1() {
        System.out.println("1 - start");

        try {
            System.out.println("sleep...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = 1;
        System.out.println("1 - end");
    }

    public synchronized void changeA2() {
        System.out.println("2 - start");
        a = 2;
        System.out.println("2 - end");
    }

    public void changeA3() {
        System.out.println("3 - start");
        a = 10;
        System.out.println("3 - end");
    }

    public static void main(String[] args) {
        Test test = new Test();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread1 start");
                test.changeA1();
                System.out.println("Thread1 end");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("        Thread2 start");
                test.changeA2();
                System.out.println("        Thread2 end");
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("                 Thread3 start");
                test.changeA3();
                System.out.println("                 Thread3 end");
            }
        });

        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("                                Thread4 start");
                test.changeA1();
                System.out.println("                                Thread4 end");
            }
        });
        thread1.start();
//        thread2.start();
        thread3.start();
//        thread4.start();
    }
}
