/**
 * Created by Diana on 04.06.2017.
 */
public class Lesson6 {

    public static void main(String[] args) {
        int[] ar10 = new int[10];
        for (int i = 0; i < ar10.length; i++) {
            ar10[i] = i + 1;
        }
        System.out.print("ar10 ");
        printArray(ar10);

        int[] ar20 = new int[20];
        System.out.print("ar20 ");
        printArray(ar20);

        System.arraycopy(ar10, 0, ar20, ar20.length/4, ar10.length);
        System.out.print("ar20 ");
        printArray(ar20);
    }

    public static void printArray(int[] ar) {
        System.out.print("[ ");
        for (int i = 0; i < ar.length - 1; i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.print(ar[ar.length - 1]);
        System.out.println(" ]");
    }
}
