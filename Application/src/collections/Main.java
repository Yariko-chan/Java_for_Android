package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by user on 14.06.2017.
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Andrew", 21));
        list.add(new Student("Evgenia", 23));
        list.add(new Student("Boris", 26));

        Collections.sort(list);
        System.out.println(list.toString());

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list.toString());
    }
}
