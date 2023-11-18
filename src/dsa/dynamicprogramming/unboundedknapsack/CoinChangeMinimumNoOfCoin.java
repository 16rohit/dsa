package dsa.dynamicprogramming.unboundedknapsack;

public class CoinChangeMinimumNoOfCoin {
    public static void main(String[] args) {
        int[] coin = new int[]{5};
        int sum = 6;
        int[][] dp = new int[coin.length + 1][sum + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (j == 0)
                    dp[i][j] = 0;
                else if (i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                else
                    dp[i][j] = -1;

            }
        }

        int ans = findMinimumNoOfCoin(coin, sum, coin.length, dp);
        System.out.println(ans);
    }

    private static int findMinimumNoOfCoin(int[] coin, int sum, int n, int[][] dp) {
        if (sum == 0)
            return 0;
        if (n == 0)
            return Integer.MAX_VALUE - 1;
        if (dp[n][sum] != -1)
            return dp[n][sum];

        if (coin[n - 1] > sum)
            dp[n][sum] = findMinimumNoOfCoin(coin, sum, n - 1, dp);
        else
            dp[n][sum] = Math.min(
                    findMinimumNoOfCoin(coin, sum, n - 1, dp),
                    findMinimumNoOfCoin(coin, sum - coin[n - 1], n, dp) + 1
            );

        return dp[n][sum];
    }
}
