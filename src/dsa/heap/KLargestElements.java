package dsa.heap;

import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        int k = 2;
        System.out.println(kLarge(arr, k));
    }

    private static PriorityQueue<Integer> kLarge(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i) {
            minHeap.offer(arr[i]);
            if (minHeap.size() > k)
                minHeap.poll();
        }
        return minHeap;
    }
}
