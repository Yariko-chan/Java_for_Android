import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Controller implements Data.OnDataChangesListener{
    private static Controller instance;

    private UI ui;
    private Data data;


    private Controller() {
    }

    public static synchronized Controller getInstance() {
        if (null == instance) {
            instance = new Controller();
        }
        return instance;
    }


    @Override
    public void OnDataChanged() {
        ui.displayData();
    }

    public void start() {
        ui = new UI();

        data = new Data(this);
    }
}
