package dsa.dynamicprogramming.basics;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;

        int[] dp = new int[n + 1];
        for (int i = 0; i < dp.length; ++i) {
            if (i == 0 || i == 1)
                dp[i] = i;
            else
                dp[i] = -1;
        }

        int ans = fib(n, dp);

        System.out.println(ans);
    }

    private static int fib(int n, int[] dp) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != -1)
            return dp[n];

        dp[n] = fib(n - 1, dp) + fib(n - 2, dp);
        return dp[n];
    }
}
