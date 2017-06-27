import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by user on 23.06.2017.
 */
public class DeleteDoubleNumbersTask {

    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 3, 2, 1};
        int single = findSingleHashSet(ar);
        System.out.println(single);
    }

    // O(1,5N)
    private static int findSingleHashMap(int[] ar) {
        if (ar.length == 1) return ar[0];
        HashMap<Integer, Integer> arNumCount = new HashMap<>();
        for (int n:ar) {
            if (arNumCount.containsKey(n)) {
                arNumCount.put(n, 2);
            } else {
                arNumCount.put(n, 1);
            }
        }

        for (Integer i: arNumCount.keySet()) {
            if (arNumCount.get(i).equals(1)) {
                return i;
            }
        }
        return 0;
    }

    // O(N)
    private static int findSingleHashSet(int[] ar) {
        // можно хэшсет, добавлять в него и првоерять с каждым элементом, содержится ли
        if (ar.length == 1) return ar[0];
        HashSet<Integer> set = new HashSet<>();
        for (int i: ar) {
            if (!set.contains(i)) set.add(i);
            else set.remove(i);
        }
        return set.iterator().next();
    }

    private static int findSingleEffective(int[] ar) {
        // можно хэшсет, добавлять в него и првоерять с каждым элементом, содержится ли
        if (ar.length == 1) return ar[0];
        int res = 0;
        for (int i: ar) {
            res = res ^ ar[i]; // побитовый оператор XOR
        }
        return 0;
    }
}
