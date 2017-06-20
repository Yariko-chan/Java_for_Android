package Lesson13;

import java.util.ArrayList;

/**
 * Created by Diana on 20.06.2017.
 */
public class Root {
    private String name;
    private ArrayList<People> people;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<People> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<People> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(name);
        builder.append("\n");
        for (People h : people) {

            builder.append(h.toString() + "\n");
        }
        return builder.toString();
    }
}
