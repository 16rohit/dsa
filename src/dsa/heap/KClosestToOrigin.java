package dsa.heap;

import dsa.stack.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestToOrigin {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 3},
                {-2, 2},
                {5, 8},
                {0, 1}
        };
        int k = 2;
        System.out.println(Arrays.deepToString(kClose(arr, k)));
    }

    private static int[][] kClose(int[][] arr, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int ans[][] = new int[k][arr[0].length];
        double[] dist = new double[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            double distance = Math.sqrt(Math.pow(arr[i][0], 2) + Math.pow(arr[i][1], 2));
            dist[i] = distance;
        }
        for (int i = 0; i < arr.length; ++i) {
            maxHeap.offer(new Pair((int) dist[i], i));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        for (int i = 0; i < k; ++i) {
            Pair p = maxHeap.poll();
            ans[i][0] = arr[p.getSecond()][0];
            ans[i][1] = arr[p.getSecond()][1];
        }
        return ans;
    }
}
