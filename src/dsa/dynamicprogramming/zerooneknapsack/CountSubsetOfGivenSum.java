package dsa.dynamicprogramming.zerooneknapsack;

import java.util.Arrays;

public class CountSubsetOfGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 0;

        if (sum == 0) {
            long ans = Arrays.stream(arr).filter(a -> a == 0).count() + 1;
            System.out.println(ans);
            return;
        }
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 && j != 0)
                    dp[i][j] = 0;
                else if (j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }

        int ans = countSubset(arr, sum, arr.length, dp);
        System.out.println(ans);
    }

    private static int countSubset(int[] arr, int sum, int n, int[][] dp) {
        if (n == 0 && sum != 0)
            return 0;
        if (sum == 0)
            return 1;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        if (arr[n - 1] > sum) {
            dp[n][sum] = countSubset(arr, sum, n - 1, dp);
            return dp[n][sum];
        } else {
            dp[n][sum] = countSubset(arr, sum, n - 1, dp) + countSubset(arr, sum - arr[n - 1], n - 1, dp);
            return dp[n][sum];
        }
    }
}
