package clinic;

/**
 * Created by user on 31.05.2017.
 */
public class Doctor extends Man {
    private String spec;
    private int roomNumber;

    public Doctor() {
    }

    @Override
    public void myAbstractMethod() {
        System.out.println("myAbstr Doctor");
    }

    public Doctor(int age, String name) {
        super(age, name);
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Doctor)) return false;
        if (!super.equals(o)) return false;

        Doctor doctor = (Doctor) o;

        if (getRoomNumber() != doctor.getRoomNumber()) return false;
        return getSpec() != null ? getSpec().equals(doctor.getSpec()) : doctor.getSpec() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getSpec() != null ? getSpec().hashCode() : 0);
        result = 31 * result + getRoomNumber();
        return result;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "spec='" + spec + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
