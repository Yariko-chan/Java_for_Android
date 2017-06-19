package interfaces;

/**
 * Created by user on 05.06.2017.
 */
public class Main implements OnClickListener, OnToggleListener {

    public static void main(String[] args) {

        Button b = new Button();
        Button b2 = new Button();
        Toggle t  = new Toggle();

        Main m = new Main();
        b.setListener(m);
        b2.setListener(m);
        t.setListener(m);

        b.onTouch();
        b2.onTouch();
        t.onTouch();
    }

    @Override
    public void onClick() {
        System.out.println("Button clicked, main reacted");
    }
}
