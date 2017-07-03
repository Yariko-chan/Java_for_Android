package Lesson18;

/**
 * Created by user on 28.06.2017.
 */
public class TestClass {

    public int a = 5;
    private String text = "text";

    public void testPublic() {
        System.out.println("public method invoked");
    }

    private void testPrivate() {
        System.out.println("private method invoked");
    }

    public int getA() {
        return a;
    }

    public String getText() {
        return text;
    }
}
