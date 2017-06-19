package cars;

/**
 * Created by user on 02.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        Car blue = new BlueCar();
        Car red = new RedCar();
        printColor(red);
        printColor(blue);
    }

    public static void printColor(Car car) {

        if ( car instanceof RedCar) { // <---слишком жрёт ресурсы и вообще неправильно
            ((RedCar) car).redSpecialMethod();
        } else if (car.getClass() == RedCar.class) { // <---слишком жрёт ресурсы и вообще неправильно

        }

        System.out.println(car.getColor());
    }
}
