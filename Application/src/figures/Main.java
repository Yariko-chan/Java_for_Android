package figures;

/**
 * Created by user on 02.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Figure f;

        f = new Quadrate(5);
        System.out.print("Quadrate ");
        printSquare(f);

        f = new Round(5);
        System.out.print("Round ");
        printSquare(f);

        f = new Rectangle(5, 10);
        System.out.print("Rectangle ");
        printSquare(f);

    }

    public static void printSquare(Figure f) {
        System.out.println("square = " + f.getSquare());
    }
}
