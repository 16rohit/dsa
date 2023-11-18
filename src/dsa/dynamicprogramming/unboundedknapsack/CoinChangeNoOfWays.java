package dsa.dynamicprogramming.unboundedknapsack;

public class CoinChangeNoOfWays {
    public static void main(String[] args) {
        int[] coin = new int[]{1, 2, 3};
        int sum = 5;
        int[][] dp = new int[coin.length + 1][sum + 1];
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
        int ans = noOfWays(coin, sum, coin.length, dp);
        System.out.println(ans);
    }

    private static int noOfWays(int[] coin, int sum, int n, int[][] dp) {
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        if (coin[n - 1] > sum)
            dp[n][sum] = noOfWays(coin, sum, n - 1, dp);
        else
            dp[n][sum] = noOfWays(coin, sum, n - 1, dp) + noOfWays(coin, sum - coin[n - 1], n, dp);
        return dp[n][sum];
    }
}
