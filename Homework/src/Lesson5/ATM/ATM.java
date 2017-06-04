package Lesson5.ATM;

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

    private void giveCash(int bn20Count, int bn50Count, int bn100Count) {
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
        int count100 = 0;
        int count50 = 0;
        int count20 = 0;
        int rest = sum;

        // determine count100 and rest = sum - (100*count100)
        if (rest != 0 && getBn100Count() != 0) {
            count100 = rest/100;
            if (count100 <= getBn100Count()) {
                rest = rest%100;
            } else { /* if not enough 100-bank note, give as much as possible */
                count100 = getBn100Count();
                rest -= 100*count100;
            }
        }

        // determine count50 and rest = sum - (50*count50)
        if (rest != 0 && getBn50Count() != 0) {
            count50 = rest/50;
            if (count50 <= getBn50Count()) {
                rest = rest%50;
            } else {
                count50 = getBn50Count();
                rest -= 50*count50;
            }
        }

        // determine count20 and rest = sum - (20*count20)
        if (rest != 0 && getBn20Count() != 0) {
            count20 = rest/20;
            if (count20 <= getBn20Count()) {
                rest = rest%20;
            } else {
                count20 = getBn20Count();
                rest -= 20*count20;
            }
        }

        if (rest == 0) {
            giveCash(count20, count50, count100);
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
}
