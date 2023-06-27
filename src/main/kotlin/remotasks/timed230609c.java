package remotasks;

import java.util.List;

public class timed230609c {
    public static long getMinimumCost(List<Integer> arr) {
        int i = 1;
        int minDiff = Math.abs(arr.get(1) - arr.get(0));
        for (int j = 2; j < arr.size(); j++) {
            int diff = Math.abs(arr.get(j) - arr.get(j-1));
            if (diff > minDiff) {
                minDiff = diff;
                i = j;
            }
        }
        if (minDiff == 0)
            return 0L;

        int half = minDiff / 2;
        long sum = getSum(arr, i, half);
        if (minDiff % 2 == 0) {
            return sum;
        } else {
            return Math.min(sum, getSum(arr, i, half+1));
        }
    }

    private static long getSum(List<Integer> arr, int i, int half) {
        int value = Math.min(arr.get(i), arr.get(i-1)) + half;
        arr.add(i, value);
        long sum = 0;
        for (int j = 1; j < arr.size(); j++) {
            int diff = arr.get(j) - arr.get(j-1);
            sum += diff * diff;
        }
        arr.remove(i);
        return sum;
    }
}
