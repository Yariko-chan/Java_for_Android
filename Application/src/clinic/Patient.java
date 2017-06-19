package clinic;

/**
 * Created by user on 31.05.2017.
 */
public class Patient extends Man{

    private String diagnosys;

    public Patient() {
    }

    @Override
    public void myAbstractMethod() {
        System.out.println("myAbstr Patient");
    }

    @Override
    public String toString() {
        return "Patient{" +
                "diagnosys='" + diagnosys + '\'' +
                '}';
    }
}
