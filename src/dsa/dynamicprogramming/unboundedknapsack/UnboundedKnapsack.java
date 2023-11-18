package dsa.dynamicprogramming.unboundedknapsack;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] val = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int n = wt.length;
        int w = 8;
        int[][] dp = new int[wt.length + 1][w + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j ==0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = -1;
            }
        }

        int profit = unboundedKnapsack(wt, val, w, n, dp);
        System.out.println(profit);
    }

    private static int unboundedKnapsack(int[] wt, int[] val, int w, int n, int[][] dp) {
        if (w == 0 || n == 0)
            return 0;
        if (dp[n][w] !=-1)
            return dp[n][w];
        if (wt[n - 1] > w) {
            dp[n][w] = unboundedKnapsack(wt, val, w, n - 1, dp);
            return dp[n][w];
        } else {
            dp[n][w] = Math.max(unboundedKnapsack(wt, val, w, n - 1, dp), unboundedKnapsack(wt, val, w - wt[n - 1], n, dp) + val[n - 1]);
            return dp[n][w];
        }
    }
}
