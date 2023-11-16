package dsa.heap;

import java.util.PriorityQueue;

public class ConnectRopeMinCost {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(minCost(arr));
    }

    private static int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i) {
            minHeap.offer(arr[i]);
        }
        while (minHeap.size() > 1) {
            int a = minHeap.poll();
            int b = minHeap.poll();
            minHeap.offer(a + b);
        }
        return minHeap.peek();
    }
}
