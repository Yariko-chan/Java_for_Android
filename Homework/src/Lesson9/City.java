package Lesson9;

/**
 * Created by Diana on 12.06.2017.
 */
public class City {
    private Street st;
    private Avenue ave;
    private  Square sq;

    public City(String st, String ave, String sq) {
        this.st = new Street(st);
        this.ave = new Avenue(ave);
        this.sq = new Square(sq);
    }

    class Street {
        private String name;

        public Street(String name) {
            this.name = name;
        }
    }

    class Avenue {
        private String name;

        public Avenue(String name) {
            this.name = name;
        }
    }

    class Square {
        private String name;

        public Square(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        City minsk = new City("Byadi", "Nezavisimosti", "Peramogi");
    }
}
