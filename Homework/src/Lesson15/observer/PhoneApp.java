package Lesson15.observer;

/**
 * Created by user on 26.06.2017.
 */
public class PhoneApp implements OnWeatherChangesListener {
    @Override
    public void onWeatherChanged() {
        System.out.println("phone");
    }
}
