package main;

import entities.News;

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
    public void OnDataChanged(ArrayList<News> jsonList) {
        ui.displayData(jsonList);
    }

    public void start() {
        ui = UI.createUI();

        data = new Data(this);
    }
}
