package main;

import entities.News;
import main.ui.UI;

import java.util.ArrayList;

/**
 * Created by Diana on 27.06.2017.
 */
public class Controller implements Data.OnDataChangesListener, Data.OnDataErrorsListener, UI.OnUIActionListener {
    private static Controller instance;

    private UI ui;
    private Data data;
    private FileMode currentFileMode = FileMode.JSON_MODE; // by default
    private SortMode currentSortMode = SortMode.DATE_MODE; // by default

    public enum FileMode {
        JSON_MODE, XML_MODE;
    }

    public enum SortMode {
        DATE_MODE, KEYS_MODE;
    }

    private Controller() {
    }

    public static synchronized Controller getInstance() {
        if (null == instance) {
            instance = new Controller();
        }
        return instance;
    }

    public void start() {
        ui = UI.getUI(this);

        data = new Data(this, this);
        data.downloadData(currentFileMode, currentSortMode);
    }

    //reactions for Data

    @Override
    public void onDataChanged(ArrayList<News> newsList) {
        ui.displayData(newsList);
    }

    @Override
    public void onDataError(String message) {
        ui.displayError(message);
    }

    // reactions for UI

    @Override
    public void onRefreshBtnPressed() {
        data.downloadData(currentFileMode, currentSortMode);
    }

    @Override
    public void onJsonSelected() {
        currentFileMode = FileMode.JSON_MODE;
    }

    @Override
    public void onXmlSelected() {
        currentFileMode = FileMode.XML_MODE;
    }

    @Override
    public void onSortByDateSelected() {
        currentSortMode = SortMode.DATE_MODE;
    }

    @Override
    public void onSortByKeysSelected() {
        currentSortMode = SortMode.KEYS_MODE;
    }

    @Override
    public void onSearchBtnPressed(String query) {

    }
}
