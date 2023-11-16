package dsa.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumBetweenK1K2SmallestElement {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 12, 5, 15, 11};
        int k1 = 3;
        int k2 = 6;
        System.out.println(sumSmall(arr, k1, k2));
    }

    private static int sumSmall(int[] arr, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < arr.length; ++i) {
            maxHeap.offer(arr[i]);
            if (maxHeap.size() > k2)
                maxHeap.poll();
        }
        int element = k2 - k1 + 1;
        int sum = 0;
        for (int i = 0; i < element; ++i) {
            sum += maxHeap.poll();
        }
        return sum;
    }
}
