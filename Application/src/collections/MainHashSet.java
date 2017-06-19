package collections;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by user on 16.06.2017.
 */
public class MainHashSet {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());

        HashSet<Integer> set = new HashSet<>(list);
        System.out.println(set.toString());
    }
}
