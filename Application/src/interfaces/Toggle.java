package interfaces;

/**
 * Created by user on 05.06.2017.
 */
public class Toggle {
    private OnToggleListener listener;

    public void setListener(OnToggleListener listener) {
        this.listener = listener;
    }

    public void onTouch() {
        listener.onClick();
    }
}
