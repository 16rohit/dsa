package dsa.dynamicprogramming.zerooneknapsack;

public class ZeroOneKnapsackTopDown {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int w = 7;

        int[][] dp = new int[wt.length + 1][w + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (wt[i - 1] > j)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        System.out.println(dp[wt.length][w]);
    }
}
