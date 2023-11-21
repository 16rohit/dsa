package dsa.dynamicprogramming.longestsubsequence;

public class MinOperationConvertAtoB {
    //min no of operations to convert a to b. operations are insert and delete (NO replace)
    public static void main(String[] args) {
        String s1 = "heap";
        String s2 = "pea";
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < dp.length; ++i) {
            for (int j = 0; j < dp[0].length; ++j) {
                dp[i][j] = -1;
            }
        }

        int lcs = getLongestCommonSubsequence(s1, s2, n1, n2, dp);

        int noOfInsertion = n1 - lcs;
        System.out.println("insertion >> " + noOfInsertion);
        int noOfDeletion = n2 - lcs;
        System.out.println("deletion >> " + noOfDeletion);

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

}
