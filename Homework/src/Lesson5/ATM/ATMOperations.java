package Lesson5.ATM;

import java.util.Scanner;

/**
 * Created by Diana on 02.06.2017.
 */
public class ATMOperations {
    public static void main(String[] args) {
        ATM atm = new ATM(20, 10, 5);
        int sum;

        boolean b;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter amount: ");
            sum = sc.nextInt();
            b = atm.getCash(sum);
        } while (b);

        System.out.println("Enter amount of money to put into ATM: ");
        System.out.print("20 : ");
        int count20 = sc.nextInt();
        System.out.print("50 : ");
        int count50 = sc.nextInt();
        System.out.print("100 : ");
        int count100 = sc.nextInt();
        atm.putCash(count20, count50, count100);

        do {
            System.out.println("Enter amount: ");
            sum = sc.nextInt();
            b = atm.getCash(sum);
        } while (b);
    }
}
