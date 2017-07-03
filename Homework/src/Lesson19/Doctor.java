package Lesson19;

/**
 * Created by Diana on 03.07.2017.
 */
public class Doctor extends Man {
    private String specialization;

    public Doctor(String name) {
        super(name);
    }

    public Doctor(String name, String specialization) {
        super(name);
        this.specialization = specialization;
    }

    public Doctor(String name, int age, boolean gender) {
        super(name, age, gender);
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String getName() {
        return "Dr. " + super.getName();
    }
}
