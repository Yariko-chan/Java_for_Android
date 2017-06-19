package collections;

import java.util.HashMap;

/**
 * Created by user on 14.06.2017.
 */
public class MainMap {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        System.out.println(map.toString());
        System.out.println(map.get(1));

        for (Integer i: map.keySet() /* array of keys */) {
            System.out.println(i + " " + map.get(i));
        }

    }
}
