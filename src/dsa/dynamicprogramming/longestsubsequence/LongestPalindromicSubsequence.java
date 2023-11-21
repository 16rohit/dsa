package dsa.dynamicprogramming.longestsubsequence;

// this can also be asked to solve for the number of deletion to get palindromic string
// this can also be asked to solve for the number of insertion to get palindromic string. both the ans will be same
public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "agbcba";
        String s2 = new StringBuilder(s1).reverse().toString();
        int n1 = s1.length();
        int[][] dp = new int[n1 + 1][n1 + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[n1][n1]);
    }

}
