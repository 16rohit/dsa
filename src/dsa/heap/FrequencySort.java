package dsa.heap;

import dsa.stack.Pair;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 2, 2, 4, 3, 3};
        System.out.println(Arrays.toString(fSort(arr)));
    }

    private static int[] fSort(int[] arr) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (freq.containsKey(arr[i]))
                freq.put(arr[i], freq.get(arr[i]) + 1);
            else
                freq.put(arr[i], 1);
        }
        int ans[] = new int[arr.length];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            minHeap.offer(new Pair(e.getValue(), e.getKey()));
        }
        int count = 0;
        while (!minHeap.isEmpty()) {
            Pair p = minHeap.poll();
            for (int i = 0; i < p.getFirst(); ++i)
                ans[count++] = p.getSecond();
        }
        return ans;
    }
}
