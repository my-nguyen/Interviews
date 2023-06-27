package remotasks;

import java.util.*;

public class timed230609a {
    public static int getMaximumDistinctCount(List<Integer> a, List<Integer> b, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : a) {
            if (map.containsKey(n))
                map.put(n, map.get(n) + 1);
            else
                map.put(n, 1);
            // map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size(); // 1,1,4,5,5 => size = 3

        Set<Integer> set = new HashSet<>();
        for (int n : b) {
            if (!map.containsKey(n))
                set.add(n);
        }
        if (set.size() == 0) // a=1,1,4,5,5; b=4,4,3,1,5 => set.size = 1
            return size;

        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (entry.getValue() == 1)
                it.remove();
        }
        if (map.size() == 0) // 1,2,3 => map.size = 0, a.size = 3; 1,1,4,5,5 => map.size = 2
            return a.size();

        return size + Math.min(k, set.size());
    }
}
