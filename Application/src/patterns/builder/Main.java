package patterns.builder;

/**
 * Created by user on 21.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Student st = new Student.Builder()
                    .setName("")
                    .setAge(0)
                    .buildStudent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
