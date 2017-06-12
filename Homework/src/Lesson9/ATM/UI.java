package Lesson9.ATM;

import java.util.Scanner;

/**
 * Created by Diana on 11.06.2017.
 */
public class UI{

    public void start() {
        ATM atm = new ATM(10, 5, 20, new ATMOperationsListener() {
            @Override
            public void giveCash(int bn100Count, int bn50Count, int bn20Count) {
                if (bn100Count == 0 && bn50Count == 0 && bn20Count == 0) {
                    System.out.println("Error giving cash. Try later. ");
                } else {
                    System.out.println("Please, take money: ");
                    System.out.println(bn20Count + " x 20");
                    System.out.println(bn50Count + " x 50");
                    System.out.println(bn100Count + " x 100\n");
                }
            }
        });
        int sum;

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter amount: ");
            sum = sc.nextInt();
            atm.getCash(sum);
        }

        System.out.println("Enter amount of money to put into ATM: ");
        System.out.print("20 : ");
        int count20 = sc.nextInt();
        System.out.print("50 : ");
        int count50 = sc.nextInt();
        System.out.print("100 : ");
        int count100 = sc.nextInt();
        atm.putCash(count20, count50, count100);

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter amount: ");
            sum = sc.nextInt();
            atm.getCash(sum);
        }
    }
}
