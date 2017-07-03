package Lesson19;

import java.rmi.NoSuchObjectException;
import java.util.*;

/**
 * Created by user on 30.06.2017.
 */
public class Hierarchy<T extends Man> {
    //director
    private T director;

    // several departments
    // each man belongs to one department
    private HashMap<String, HashSet<T>> departments = new HashMap<>();

    public Hierarchy(T director) {
        this.director = director;
    }

    // get director
    public T getDirector() {
        return director;
    }

    // change director
    public void setDirector(T director) {
        this.director = director;
    }

    // add department
    public void addDepartment(String name) {
        departments.put(name, new HashSet<T>());
    }

    // remove department
    public void removeDepartment(String name) {
        departments.remove(name);
    }

    // get employees from departments
    public HashSet<T> getManFromDepartment(String name) {
        return departments.get(name);
    }

    // add/remove employee
    public void addEmployee(T man, String department) {
        // if department not exists, add
        // put man to department anyway

        if (null == departments.get(department)) {
            addDepartment(department);
        }
        departments.get(department).add(man);
    }

    // move emp to other dep
    public void moveEmployee(T man, String from, String to) throws NoSuchObjectException {
        if (null == departments.get(from)) {
            throw new NoSuchObjectException("No such department");
        }

        if (null == departments.get(to)) {
            addDepartment(to);
        }

        departments.get(from).remove(man);
        departments.get(to).add(man);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Director: ").append(director.getName()).append("\n");

        Iterator iterator = departments.entrySet().iterator();
        while (iterator.hasNext()) {
            HashMap.Entry<String, HashSet<T>> department =
                    (HashMap.Entry<String, HashSet<T>>) iterator.next();
            builder.append("\n");
            builder.append(department.getKey()).append("\n");
            for (Man man: department.getValue()) {
                builder.append(man.getName()).append("\n");
            }
        }

        return builder.toString();
    }
}
