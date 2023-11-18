package dsa.dynamicprogramming;

import java.util.Arrays;

public class MinSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 7};
        int sum = Arrays.stream(arr).sum();
        int reqSum = sum / 2;
        Boolean[][] dp = new Boolean[arr.length + 1][reqSum + 1];
        boolean ans = false;
        while (true) {
            initializeDP(dp);
            ans = existSum(arr, reqSum, arr.length, dp);
            if (ans)
                break;
            else
                reqSum--;
        }
        System.out.println(sum - reqSum * 2);
    }

    private static void initializeDP(Boolean[][] dp) {
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
                else dp[i][j] = null;
            }
        }
    }

    private static boolean existSum(int[] arr, int sum, int n, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (dp[n][sum] != null)
            return dp[n][sum];
        if (arr[n - 1] > sum) {
            dp[n][sum] = existSum(arr, sum, n - 1, dp);
            return dp[n][sum];
        } else {
            dp[n][sum] = existSum(arr, sum, n - 1, dp) || existSum(arr, sum - arr[n - 1], n - 1, dp);
            return dp[n][sum];
        }
    }
}
