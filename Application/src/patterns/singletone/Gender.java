package patterns.singletone;

/**
 * Created by user on 23.06.2017.
 */
public enum  Gender {
    W(1),
    M(2);

    private int value;

    Gender (int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
