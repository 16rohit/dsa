package dsa.tree;

public class L48_ConstructBSTFromPreorder {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 4, 6, 8, 9};

        int i = 0;
        Node n = constructBST(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
        n.drawTree(n);
    }

    public static int i = 0;

    private static Node constructBST(int[] arr, int minValue, int maxValue) {
        Node n = null;
        if (i >= arr.length)
            return null;
        if (arr[i] > minValue && arr[i] < maxValue) {
            n = new Node(arr[i]);
            i++;
            n.left = constructBST(arr, minValue, n.info);
            n.right = constructBST(arr, n.info, maxValue);
        }
        return n;
    }
}
