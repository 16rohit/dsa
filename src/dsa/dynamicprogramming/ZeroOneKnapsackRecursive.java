package dsa.dynamicprogramming;

public class ZeroOneKnapsackRecursive {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int w = 7;
        int[][] dp = new int[wt.length + 1][w + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }
        int maxProfit = findProfit(wt, val, w, wt.length, dp);
        System.out.println(maxProfit);
    }

    private static int findProfit(int[] wt, int[] val, int w, int n, int[][] dp) {
        if (n == 0 || w == 0)
            return 0;
        if (dp[n][w] != -1)
            return dp[n][w];
        if (wt[n - 1] > w) {
            dp[n][w] = findProfit(wt, val, w, n - 1, dp);
            return dp[n][w];
        } else {
            dp[n][w] = Math.max(
                    findProfit(wt, val, w - wt[n - 1], n - 1, dp) + val[n - 1],
                    findProfit(wt, val, w, n - 1, dp)
            );
            return dp[n][w];
        }
    }
}
