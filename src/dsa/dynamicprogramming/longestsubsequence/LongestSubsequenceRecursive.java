package dsa.dynamicprogramming.longestsubsequence;

import java.util.Arrays;

public class LongestSubsequenceRecursive {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int n1 = s1.length();
        int n2 = s2.length();

        String[][] dp = new String[n1 + 1][n2 + 1];
        for (int i=0;i<dp.length;++i) {
            for (int j=0;j<dp[0].length;++j) {
                if (i ==0 || j==0)
                    dp[i][j] = "";
                else dp[i][j] = null;
            }
        }

        String ans = getLCH(s1, s2, n1, n2, dp);
        System.out.println(ans);
        int[][] dp1 = new int[n1+1][n2+1];
        for (int i=0;i<n1;++i) {
            for (int j=0;j<n2;++j) {
                dp1[i][j] =-1;
            }
        }
        int ans1 = lcs(s1,s2,n1,n2,dp1);
        System.out.println(ans1);
    }

    private static String getLCH(String s1, String s2, int n1, int n2, String[][] dp) {
        if (s1.length() == 0 || s2.length() == 0)
            return "";
        if (dp[n1][n2] != null)
            return  dp[n1][n2];
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            dp[n1][n2] = getLCH(s1.substring(0, n1 - 1), s2.substring(0, n2 - 1), n1 - 1, n2 - 1, dp) + s1.charAt(n1 - 1);
        else {
            String a = getLCH(s1.substring(0, n1 - 1), s2, n1 - 1, n2, dp);
            String b = getLCH(s1, s2.substring(0, n2 - 1), n1, n2 - 1, dp);
            dp[n1][n2] = a.length() > b.length() ? a : b;
        }
        return dp[n1][n2];
    }

    public static int lcs(String s1, String s2, int n1, int n2, int[][] dp) {
        if (n1 ==0 || n2 == 0)
            dp[n1][n2] = 0;
        if (dp[n1][n2] != -1)
            return dp[n1][n2];
        if (s1.charAt(n1-1) == s2.charAt(n2-1))
            dp[n1][n2] = lcs(s1,s2,n1-1,n2-1,dp) + 1;
        else
            dp[n1][n2] = Math.max(lcs(s1,s2,n1-1,n2,dp),lcs(s1,s2,n1,n2-1,dp));
        return dp[n1][n2];
    }
}
