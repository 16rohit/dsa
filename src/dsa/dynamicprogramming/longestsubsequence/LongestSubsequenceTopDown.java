package dsa.dynamicprogramming.longestsubsequence;

public class LongestSubsequenceTopDown {
    public static void main(String[] args) {
        String s1 = "abcdgh";
        String s2 = "abedfhr";
        int n1 = s1.length();
        int n2 = s2.length();

        String[][] dp = new String[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                if (i == 0 || j == 0)
                    dp[i][j] = "";
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                    else {
                        dp[i][j] = dp[i][j - 1].length() > dp[i - 1][j].length() ? dp[i][j - 1] : dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[n1][n2]);
    }
}
