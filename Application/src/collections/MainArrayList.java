package collections;

import java.util.ArrayList;

/**
 * Created by user on 14.06.2017.
 */
public class MainArrayList {

    public static void main(String[] args) {
        /*ArrayList<String> aList = new ArrayList<>();
        aList.add("First");
        aList.add("Second");
        aList.add("Third");

        System.out.println(aList.size());
        System.out.println(aList.toString());

        aList.add("Fourth");

        System.out.println(aList.get(2));
        System.out.println(aList.toString());

        for (String s:aList) {
            System.out.println(s);
        }*/

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

        int index;
        while((index = list.lastIndexOf(5)) > 0) {
            list.remove(index);
        }
        System.out.println(list.toString());

        boolean b = list.removeAll(new ArrayList<Object>(){{add(4);}});
        System.out.println(list.toString());

    }
}
