package dsa.dynamicprogramming.longestsubsequence;

public class LongestSubstring {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";
        int n1 = s1.length();
        int n2 = s2.length();
        // NOTE: here dp[i][j] represent longest substring including s1[i-1] and s2[j-1] in the substring.
        int[][] dp = new int[n1 + 1][n2 + 1];
        int ans = solveDP(dp, s1, s2);
        System.out.println(ans);
    }

    private static int solveDP(int[][] dp, String s1, String s2) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        max = Math.max(max, dp[i][j]);
                    } else
                        dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
