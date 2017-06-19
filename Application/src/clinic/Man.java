package clinic;

/**
 * Created by user on 31.05.2017.
 */
public abstract class Man {
    // абстракт - подвид класса, не позволяющий создавать себя
    // абстрактный класс - тот, в котором есть хотя бы один абстрактный метод
    // базовый класс
    private int age;
    private String name;

    public Man() {
    }

    public abstract void myAbstractMethod();
    // абстрактный метод - метод, у которого нет реализации
    // обязательно должен быть реализован в наследниках
    //

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Man)) return false;

        Man man = (Man) o;

        if (getAge() != man.getAge()) return false;
        return getName().equals(man.getName());

    }

    @Override
    public int hashCode() {
        int result = getAge();
        result = 31 * result + getName().hashCode();
        return result;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
