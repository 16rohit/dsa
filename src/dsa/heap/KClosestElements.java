package dsa.heap;

import dsa.stack.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestElements {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 7, 8, 9};
        int k = 3;
        int x = 7;
        System.out.println(Arrays.toString(kClose(arr, k, x)));
    }

    private static int[] kClose(int[] arr, int k, int x) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int ans[] = new int[k];
        for (int i = 0; i < arr.length; ++i) {
            maxHeap.offer(new Pair(Math.abs(arr[i] - x), i));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        for (int i = 0; i < k; ++i) {
            ans[i] = arr[maxHeap.poll().getSecond()];
        }
        return ans;
    }
}
