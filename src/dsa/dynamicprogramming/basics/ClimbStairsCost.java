package dsa.dynamicprogramming.basics;


import java.util.Arrays;

public class ClimbStairsCost {
    public static void main(String[] args) {
        int[] arr = new int[]{30, 10, 60, 10, 60, 50};
//        int[] arr = new int[]{30, 10, 60};
        // 1 step or 2 steps at time, minimize the cost = |arr[pre] - arr[curr]|
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = Math.abs(arr[1] - arr[0]);
        int cost = minCost(arr, arr.length, dp);
        System.out.println(cost);
        System.out.println(minCost(arr));
    }

    private static int minCost(int[] arr, int n, int[] dp) {
        if (dp[n] != -1)
            return dp[n];
        dp[n] = Math.min(
                (minCost(arr, n - 1, dp) + Math.abs(arr[n - 1] - arr[n - 2])),
                (minCost(arr, n - 2, dp) + Math.abs(arr[n - 1] - arr[n - 3]))
        );
        return dp[n];
    }

    private static int minCost(int[] arr) {
        int prev1 = 0;
        int prev2 = 0;
        for (int i = 1; i < arr.length; ++i) {
            int ans = Math.min(
                    prev1 + Math.abs(arr[i] - arr[i - 1]),
                    i - 2 >= 0 ? prev2 + Math.abs(arr[i] - arr[i - 2]) : 0
            );
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}
