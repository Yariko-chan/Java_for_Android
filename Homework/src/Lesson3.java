import java.util.Scanner;

/**
 * Created by Diana on 27.05.2017.
 */
public class Lesson3 {

    public static void main(String[] args) {
        System.out.println("Insertion sort");
        int[] intArray = inputArray();
        printArray(intArray);
        insertionSort(intArray);
        printArray(intArray);

        System.out.println("\nSelection sort");
        intArray = inputArray();
        printArray(intArray);
        selectionSort(intArray);
        printArray(intArray);

        System.out.println("\nBubble sort");
        intArray = inputArray();
        printArray(intArray);
        bubbleSort(intArray);
        printArray(intArray);

        System.out.println("\nShaker sort");
        intArray = inputArray();
        printArray(intArray);
        shakerSort(intArray);
        printArray(intArray);

        printEvensFromArray(intArray);
    }

    private static void printEvensFromArray(int[] a) {
        int[] evens = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i]%2 == 0) {
                System.out.print(a[i] + " | ");
            }
        }
        System.out.print("\b\b");
    }

    private static void shakerSort(int[] a) {
        for (int i = 0; i < a.length/2; i++) {
            for (int j = i; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) exch(a, j, j + 1);
            }
            for (int j = a.length - i - 2; j > i; j--) {
                if (a[j] < a[j - 1]) exch(a, j, j - 1);
            }
        }
    }

    private static void bubbleSort(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) exch(a, j, j + 1);
            }
        }
    }

    private static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            // find min in [i; length)
            for (int j = i; j < a.length; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            exch(a, i, minIndex);
        }
    }

    private static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    exch(a, j, j-1);
                } else break;
            }
        }
    }

    // exchanges a[i] and a[j]
    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int[] inputArray() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter count of elements in array: ");
        int count = sc.nextInt();

        int[] resultArray = new int[count];
        System.out.println("Enter values for array: ");
        for (int i = 0; i < count; i++) {
            System.out.print(i + ": ");
            resultArray[i] = sc.nextInt();
        }

        return resultArray;
    }

    private static void printArray(int[] intArray) {
        for (int i = 0; i < intArray.length - 1; i++) {
            System.out.print(intArray[i] + " | ");
        }
        System.out.println(intArray[intArray.length - 1]);
    }
}
