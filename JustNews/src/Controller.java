import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Controller {
    private static Controller instance;

    ArrayList<OnModelChangesListener> modelListeners;


    private Controller() {
        modelListeners = new ArrayList<>();
    }

    public static synchronized Controller getInstance() {
        if (null == instance) {
            instance = new Controller();
        }
        return instance;
    }

    public void setModelListener(OnModelChangesListener listener) {
        modelListeners.add(listener);
    }


    public interface OnModelChangesListener {

        public void OnModelChanged();
    }
}
