package dsa.dynamicprogramming.longestsubsequence;

public class ShortestSuperSequence {
    public static void main(String[] args) {
        String s1 = "geek";
        String s2 = "eke";
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = -1;
            }
        }

        int lcs = getLongestCommonSubsequence(s1, s2, n1, n2, dp);
        System.out.println(lcs);
        int ans = n1 + n2 - lcs;
        System.out.println(ans);

        //print
        String[][] dp1 = new String[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp1[i][j] = null;
            }
        }
        String lcsString = printLongestCommonSubsequence(s1, s2, n1, n2, dp1);
        String ansString = "";
        int a = 0;
        int b = 0;
        int c = 0;
        while (c < lcsString.length()) {
            if (s1.charAt(a) == s2.charAt(b) && s1.charAt(a) == lcsString.charAt(c)) {
                ansString += lcsString.charAt(c);
                ++a;
                ++b;
                ++c;
            } else if (s1.charAt(a) != lcsString.charAt(c)) {
                ansString += s1.charAt(a);
                ++a;
            } else if (s2.charAt(b) != lcsString.charAt(c)) {
                ansString += s2.charAt(b);
                ++b;
            }
        }
        while (a < s1.length()) {
            ansString += s1.charAt(a++);
        }
        while (b < s2.length()) {
            ansString += s2.charAt(b++);
        }
        System.out.println(ansString);
    }

    private static int getLongestCommonSubsequence(String s1, String s2, int n1, int n2, int[][] dp) {
        if (n1 == 0 || n2 == 0)
            dp[n1][n2] = 0;
        if (dp[n1][n2] != -1)
            return dp[n1][n2];
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            dp[n1][n2] = 1 + getLongestCommonSubsequence(s1, s2, n1 - 1, n2 - 1, dp);
        else {
            int a = getLongestCommonSubsequence(s1, s2, n1 - 1, n2, dp);
            int b = getLongestCommonSubsequence(s1, s2, n1, n2 - 1, dp);
            dp[n1][n2] = Math.max(a, b);
        }
        return dp[n1][n2];
    }

    private static String printLongestCommonSubsequence(String s1, String s2, int n1, int n2, String[][] dp) {
        if (n1 == 0 || n2 == 0)
            dp[n1][n2] = "";
        if (dp[n1][n2] != null)
            return dp[n1][n2];
        if (s1.charAt(n1 - 1) == s2.charAt(n2 - 1))
            dp[n1][n2] = printLongestCommonSubsequence(s1, s2, n1 - 1, n2 - 1, dp) + s1.charAt(n1 - 1);
        else {
            String a = printLongestCommonSubsequence(s1, s2, n1 - 1, n2, dp);
            String b = printLongestCommonSubsequence(s1, s2, n1, n2 - 1, dp);
            dp[n1][n2] = a.length() > b.length() ? a : b;
        }
        return dp[n1][n2];
    }
}
