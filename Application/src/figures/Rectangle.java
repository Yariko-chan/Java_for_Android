package figures;

/**
 * Created by user on 02.06.2017.
 */
public class Rectangle extends Figure {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getSquare() {
        return width*height;
    }
}
