package Lesson15.observer;

import java.util.ArrayList;

/**
 * Created by user on 26.06.2017.
 */
public class WeatherSensor {
    ArrayList<OnWeatherChangesListener> listeners;

    public WeatherSensor() {
        listeners = new ArrayList<>();
    }

    public void onWeatherChanged() {
        for (OnWeatherChangesListener l: listeners) {
            l.onWeatherChanged();
        }
    }

    public void setWeatherChangesListener(OnWeatherChangesListener l) {
        listeners.add(l);
    }
}
