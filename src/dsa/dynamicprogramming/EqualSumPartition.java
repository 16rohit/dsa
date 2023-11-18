package dsa.dynamicprogramming;

import java.util.Arrays;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 11, 5};
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 != 0) {
            System.out.println(false);
            return;
        }
        int reqSum = sum / 2;
        Boolean[][] dp = new Boolean[arr.length + 1][reqSum + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 && j == 0)
                    dp[i][j] = true;
                else if (j == 0)
                    dp[i][j] = false;
                else if (i == 0)
                    dp[i][j] = false;
            }
        }
        boolean ans = isEqualSumPartitionPresent(arr, reqSum, arr.length, dp);
        System.out.println(ans);
    }

    private static boolean isEqualSumPartitionPresent(int[] arr, int reqSum, int n, Boolean[][] dp) {
        if (reqSum == 0 && n == 0)
            return true;
        else if (reqSum == 0)
            return false;
        else if (n == 0)
            return false;
        if (dp[n][reqSum] != null)
            return dp[n][reqSum];
        else {
            if (arr[n - 1] > reqSum) {
                dp[n][reqSum] = isEqualSumPartitionPresent(arr, reqSum, n - 1, dp);
                return dp[n][reqSum];
            } else {
                dp[n][reqSum] = isEqualSumPartitionPresent(arr, reqSum - arr[n - 1], n - 1, dp)
                        || isEqualSumPartitionPresent(arr, reqSum, n - 1, dp);
                return dp[n][reqSum];
            }
        }
    }
}
