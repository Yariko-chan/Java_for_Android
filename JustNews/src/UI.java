/**
 * Created by Diana on 27.06.2017.
 */
public class UI implements Controller.OnModelChangesListener {

    public UI() {
    }

    public void start() {
        Controller controller = Controller.getInstance();
        controller.setModelListener(this);
    }



    @Override
    public void OnModelChanged() {

    }
}
