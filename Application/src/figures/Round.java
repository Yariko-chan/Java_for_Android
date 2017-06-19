package figures;

/**
 * Created by user on 02.06.2017.
 */
public class Round extends Figure {
    int radius;

    public Round(int radius) {
        this.radius = radius;
    }

    @Override
    public double getSquare() {
        return radius * Math.pow(Math.PI, 2);
    }
}
