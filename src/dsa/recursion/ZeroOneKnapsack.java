package dsa.recursion;

// TODO: use dp instead.
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] wt = new int[]{1, 3, 4, 5};
        int[] val = new int[]{1, 4, 5, 7};
        int w = 7;
        int maxProfit = findProfit(wt, val, w, wt.length - 1);
        System.out.println(maxProfit);
    }

    private static int findProfit(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0)
            return 0;
        if (wt[n] > w)
            return findProfit(wt, val, w, n - 1);
        else
            return Math.max(
                    findProfit(wt, val, w - wt[n], n - 1) + val[n],
                    findProfit(wt, val, w, n - 1)
            );
    }
}
