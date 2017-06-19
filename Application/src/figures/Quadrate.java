package figures;

/**
 * Created by user on 02.06.2017.
 */
public class Quadrate extends Figure {
    private int side;

    public Quadrate(int side) {
        this.side = side;
    }

    @Override
    public double getSquare() {
        return side*side;
    }
}
