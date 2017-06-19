package cars;

/**
 * Created by user on 02.06.2017.
 */
public class RedCar extends Car {
    public static final int COLOR = 1;

    @Override
    public int getColor() {
        return COLOR;
    }

    public void redSpecialMethod() {}
}
