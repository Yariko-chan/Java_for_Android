package collections;

import java.util.HashMap;

/**
 * Created by user on 14.06.2017.
 */
public class Country {

    private String name;

    public Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Country)) return false;

        Country country = (Country) o;

        return getName().equals(country.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public static void main(String[] args) {
        HashMap<Country, Student> map = new HashMap<>();

        map.put(new Country("en"), new Student("Andrew", 20));
        map.put(new Country("ru"), new Student("Sergei", 19));
        map.put(new Country("by"), new Student("Ruslana", 21));

        for (Country s: map.keySet() /* array of keys */) {
            System.out.println(s.getName() + " " + map.get(s).getName() + " " + map.get(s).getAge());
        }

        String s = (map.get(new Country("en"))).getName();
        System.out.println(s);
    }
}
