package dsa.dynamicprogramming.basics;

import java.util.Arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        // climb stairs and find number of ways to reach n, you can take 1 or 2 steps.
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int ans = noOfWays(n, dp);
        System.out.println(ans);
        int ans1 = noOfWays(n);
        System.out.println(ans1);
    }

    private static int noOfWays(int n, int[] dp) {
        if (n == 0 || n == 1)
            dp[n] = 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = noOfWays(n - 2, dp) + noOfWays(n - 1, dp);
        return dp[n];
    }

    // we are only checking last 2 places so this can be optimized further by removing dp[].

    private static int noOfWays(int n) {
        int prev2 = 1;
        int prev1 = 1;
        if (n == 0)
            return prev2;
        if (n == 1)
            return prev1;

        for (int i = 2; i <= n; ++i) {
            int ans = prev2 + prev1;
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}
