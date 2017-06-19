package interfaces;

/**
 * Created by user on 05.06.2017.
 */
public class Button {
    private OnClickListener listener;

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void onTouch() {
        listener.onClick();
    }
}
