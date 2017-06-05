package Lesson5.ATM;

import java.util.Arrays;

/**
 * Created by Diana on 02.06.2017.
 */
public class ATM {
    private int bn20Count;
    private int bn50Count;
    private int bn100Count;

    public ATM() {
        this.bn20Count = 0;
        this.bn50Count = 0;
        this.bn100Count = 0;
    }

    public ATM(int bn20Count, int bn50Count, int bn100Count) {
        this.bn20Count = bn20Count;
        this.bn50Count = bn50Count;
        this.bn100Count = bn100Count;
    }

    private void giveCash(int bn100Count, int bn50Count, int bn20Count) {
        if (this.bn20Count < bn20Count ||
                this.bn50Count < bn50Count ||
                this.bn100Count < bn100Count) {
            throw new IllegalArgumentException("Not enough money in ATM");
        } else {
            this.bn20Count -= bn20Count;
            this.bn50Count -= bn50Count;
            this.bn100Count -= bn100Count;
            System.out.println("Please, take money: ");
            System.out.println(bn20Count + " x 20");
            System.out.println(bn50Count + " x 50");
            System.out.println(bn100Count + " x 100\n");
        }
    }

    public void putCash(int bn20Count, int bn50Count, int bn100Count) {
        this.bn20Count += bn20Count;
        this.bn50Count += bn50Count;
        this.bn100Count += bn100Count;
    }

    public boolean getCash(int sum) {
        int[][] result = findMoneySetToGive(sum, new int[][]{{100, bn100Count}, {50, bn50Count}, {20, bn20Count}}, 0);
        if (sum == sum(result)) {
            giveCash(result[0][1], result[1][1], result[2][1]);
            return true;
        } else {
            System.out.println("Operation failed");
            return false;
        }
    }

    public int getBn20Count() {
        return bn20Count;
    }

    public int getBn50Count() {
        return bn50Count;
    }

    public int getBn100Count() {
        return bn100Count;
    }

    /**
     * recursive function to find count of 20-, 50-, 100-notes to give sum
     * @param sum = sum to give
     * @param sourseMoneySet = {{100, 100Count}, {50, 50Count}, {20, 20Count}}
     * @param layer = 0..2 - index in @sourseMoneySet
     * @return int[][] result, structure like @sourseMoneySet, sum(result) = @sum or sum(result) < @sum if no solution
     */
    private int[][] findMoneySetToGive(int sum, int[][] sourseMoneySet, int layer) {
        if (sum < 0) throw new IllegalArgumentException("Sum must be greater than 0.");

        int notesCount = sum/sourseMoneySet[layer][0];
        // notesCount is max count of notes for this sum or max available in sourseMoneySet
        notesCount = (notesCount <= sourseMoneySet[layer][1]) ? notesCount : sourseMoneySet[layer][1];

        int[][] resultMoneySet = {{100, 0}, {50, 0}, {20, 0}};
        do {
            if (layer == 2) {
                resultMoneySet[layer][1] = notesCount;
                return resultMoneySet;
            } else {
                resultMoneySet = findMoneySetToGive(sum - (sourseMoneySet[layer][0] * notesCount), sourseMoneySet, layer + 1);
                resultMoneySet[layer][1] = notesCount;
            }
            notesCount--;
        } while (notesCount >= 0  && sum(resultMoneySet) != sum );

        return resultMoneySet;
    }

    private int sum(int[][] moneySet) {
        return moneySet[0][1]*100 + moneySet[1][1]*50 + moneySet[2][1]*20;
    }
}
