package dsa.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        System.out.println(Arrays.toString(kSort(arr, k)));
    }

    private static int[] kSort(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int[] ans = new int[arr.length];
        int count =0;
        for (int i = 0; i < arr.length; ++i) {
            minHeap.offer(arr[i]);
            if (minHeap.size()>k) {
                ans[count++] = minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            ans[count++] = minHeap.poll();
        }
        return ans;
    }
}
