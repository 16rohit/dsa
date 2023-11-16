package dsa.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        int k = 2;
        System.out.println(kthSmall(arr, k));
    }

    public static int kthSmall(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; ++i) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }
}
