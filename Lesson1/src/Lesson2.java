/**
 * Created by Diana on 26.05.2017.
 */
public class Lesson2 {

    public static void main(String[] args) {
        task1();
        System.out.println();
        task2();
        System.out.println();
        task3();
        System.out.println();
        task4();
    }

    private static void task4() {
        int[] ar = {47, -20, 57, 21, 56, -37, 10, 42, 61, -13, 1};

        for (int i = 0; i < ar.length; i++) {
            int minIndex = i;
            // find min in [i; length)
            for (int j = i; j < ar.length; j++) {
                if (ar[j] < ar[minIndex]) minIndex = j;
            }
            // exchange i and minIndex
            int temp = ar[i];
            ar[i] = ar[minIndex];
            ar[minIndex] = temp;
        }

        // print array
        System.out.print("[");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println(ar[ar.length - 1] + "]");
    }

    private static void task3() {
        int[] ar = {47, -20, 57, 21, 56, -37, 10, 42, 61, -13};

        // print array
        System.out.print("[");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println(ar[ar.length - 1] + "]");

        // inverse
        int mid = ar.length/2 - 1;
        for (int i = 0, j = ar.length - 1; i <= mid ; i++, j--) {
            int temp = ar[i];
            ar[i] = ar[j];
            ar[j] = temp;
        }

        // print array
        System.out.print("[");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println(ar[ar.length - 1] + "]");
    }

    private static void task2() {
        float[] fArray = {1.28f, 5.11f, 5.11f, 52.64f, 9675.97f, 91.36f, 5.11f, 91.36f, 0.497f, 1.28f};

        // structure like:
        // [1.28, 5.11, ...] <- unique numbers from fArray
        // [2,     3,   ...] <- count of such numbers in fArray
        float[][] frequencyArray = new float[2][fArray.length];


        for (int i = 0; i < fArray.length; i++) {
            // check if it's already in result array
            int j;
            for (j = 0; j < i ; j++) {
                // if already in result array, ++
                if (Float.compare(fArray[i], frequencyArray[0][j]) == 0) {
                    frequencyArray[1][j]++;
                    break;
                }

            }
            // else add to array
            if (j == i) {
                frequencyArray[0][i] = fArray[i];
                frequencyArray[1][j] = 1;
            }
        }

        // print results
        for (int i = 0; i < frequencyArray[0].length; i++) {
            if (frequencyArray[1][i] > 1) {
                System.out.printf("[%.2f] - повторений %.0f \n", frequencyArray[0][i], frequencyArray[1][i]);
            }
        }
    }

    private static void task1() {
        int[] ar = {0, -392, 54, 5, 7, 3397, -1, 137, -138, 2};

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < ar.length; i++) {
            if (ar[i] > ar[maxIndex]) maxIndex = i;
            if (ar[i] < ar[minIndex]) minIndex = i;
        }

        System.out.println("min value =  " + ar[minIndex]);
        System.out.println("max value =  " + ar[maxIndex]);

        ar[minIndex] = 0;
        ar[maxIndex] = 99;

        System.out.print("[");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println(ar[ar.length - 1] + "]");
    }
}
