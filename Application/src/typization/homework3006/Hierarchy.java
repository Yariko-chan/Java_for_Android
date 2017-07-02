package typization.homework3006;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 30.06.2017.
 */
public class Hierarchy<T extends Man> {
    //director
    private T director;

    // several departments
    // each man belongs to one department
    private HashMap<String, ArrayList<T>> departments = new HashMap<>();

    public Hierarchy(T director) {
        this.director = director;
    }

    // add/remove department
    public void addDepartment(String name) {
        departments.put(name, new ArrayList<T>());
    }

    // add/remove employee
    // add/remove director
    // move emp to other dep
    // get employees from departments
    // getter/setter/to string
}
