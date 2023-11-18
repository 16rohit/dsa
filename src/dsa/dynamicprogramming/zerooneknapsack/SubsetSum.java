package dsa.dynamicprogramming.zerooneknapsack;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 6;
        Boolean[][] dp = new Boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (j == 0)
                    dp[i][j] = true;
                else if (i == 0)
                    dp[i][j] = false;
            }
        }
        boolean ans = isSubsetPresent(arr, arr.length, sum, dp);
        System.out.println(ans);
    }

    private static boolean isSubsetPresent(int[] arr, int n, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
        if (dp[n][sum] != null)
            return dp[n][sum];
        if (arr[n - 1] > sum) {
            dp[n][sum] = isSubsetPresent(arr, n - 1, sum, dp);
            return dp[n][sum];
        } else {
            dp[n][sum] = isSubsetPresent(arr, n - 1, sum, dp) || isSubsetPresent(arr, n - 1, sum - arr[n - 1], dp);
            return dp[n][sum];
        }
    }
}
