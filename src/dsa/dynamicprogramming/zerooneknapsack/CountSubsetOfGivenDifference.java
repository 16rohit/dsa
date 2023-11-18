package dsa.dynamicprogramming.zerooneknapsack;

import java.util.Arrays;

public class CountSubsetOfGivenDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3, 4};
        int diff = 1;
        int sum = Arrays.stream(arr).sum();
        if ((sum + diff) % 2 != 0) {
            System.out.println(0);
            return;
        }
        int reqSum = (sum + diff) / 2;
        int[][] dp = new int[arr.length + 1][reqSum + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (j == 0)
                    dp[i][j] = 1;
                else if (i == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }

        int count = countSubset(arr, reqSum, arr.length, dp);
        System.out.println(count);
    }

    private static int countSubset(int[] arr, int sum, int n, int[][] dp) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
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
