package dsa.dynamicprogramming.longestsubsequence;

import java.util.Arrays;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String s1 = "AABEBCDD";
        String s2 = new String(s1);
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = lcsRepeating(s1, s2, n1, n2, dp);
        System.out.println(ans);

        String[][] dpString = new String[n1 + 1][n2 + 1];
        String ansString = printLCSRepeating(s1, s2, n1, n2, dpString);
        System.out.println(ansString);
    }

    private static int lcsRepeating(String s1, String s2, int n1, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0)
            dp[n1][n2] = 0;
        if (dp[n1][n2] != -1)
            return dp[n1][n2];
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) && n1 != n2)
            dp[n1][n2] = 1 + lcsRepeating(s1, s2, n1 - 1, n2 - 1, dp);
        else
            dp[n1][n2] = Math.max(
                    lcsRepeating(s1, s2, n1 - 1, n2, dp),
                    lcsRepeating(s1, s2, n1, n2 - 1, dp)
            );
        return dp[n1][n2];
    }

    private static String printLCSRepeating(String s1, String s2, int n1, int n2, String[][] dp) {
        if (n1 == 0 || n2 == 0)
            dp[n1][n2] = "";
        if (dp[n1][n2] != null)
            return dp[n1][n2];
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1) && n1 != n2)
            dp[n1][n2] = printLCSRepeating(s1, s2, n1 - 1, n2 - 1, dp) + s1.charAt(n1 - 1);
        else {
            String l = printLCSRepeating(s1, s2, n1, n2 - 1, dp);
            String r = printLCSRepeating(s1, s2, n1 - 1, n2, dp);
            dp[n1][n2] = l.length() > r.length() ? l : r;
        }
        return dp[n1][n2];
    }
}
