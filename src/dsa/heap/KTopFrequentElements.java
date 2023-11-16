package dsa.heap;

import dsa.stack.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KTopFrequentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 3, 2, 2, 4, 3, 3};
        int k = 2;
        System.out.println(Arrays.toString(kFrequent(arr, k)));
    }

    private static int[] kFrequent(int[] arr, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (freq.containsKey(arr[i]))
                freq.put(arr[i], freq.get(arr[i]) + 1);
            else
                freq.put(arr[i], 1);
        }

        int ans[] = new int[k];
        for (Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            minHeap.offer(new Pair(entry.getValue(), entry.getKey()));
            if (minHeap.size() > k)
                minHeap.poll();
        }
        for (int i =0;i < k;++i) {
            ans[i] = minHeap.poll().getSecond();
        }
        return ans;
    }
}
