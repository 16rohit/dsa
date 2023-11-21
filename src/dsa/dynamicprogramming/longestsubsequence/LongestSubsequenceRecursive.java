package dsa.dynamicprogramming.longestsubsequence;

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
}
