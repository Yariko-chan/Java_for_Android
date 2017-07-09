package main;

import entities.News;

import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Controller implements Data.OnDataChangesListener, UI.OnUIActionListener {
    private static Controller instance;

    private UI ui;
    private Data data;
    private FileMode currentFileMode = FileMode.JSON_MODE; // by default

    public enum FileMode {
        JSON_MODE, XML_MODE;
    }

    private Controller() {
    }

    public static synchronized Controller getInstance() {
        if (null == instance) {
            instance = new Controller();
        }
        return instance;
    }


    @Override
    public void OnDataChanged(ArrayList<News> newsList) {
        ui.displayData(newsList);
    }

    public void start() {
        ui = UI.getUI(this);

        data = new Data(this, currentFileMode);
    }

    @Override
    public void onJsonSelected() {
        currentFileMode = FileMode.JSON_MODE;
    }

    @Override
    public void onXmlSelected() {
        currentFileMode = FileMode.XML_MODE;
    }
}
