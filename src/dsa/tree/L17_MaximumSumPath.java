package dsa.tree;

public class L17_MaximumSumPath {
    public static int max = 0;

    public static void main(String[] args) {
        Node n = new Node(10);
        n.left = new Node(9);
        n.right = new Node(20);
        n.right.left = new Node(-15);
        n.right.right = new Node(-7);

        int ans = maxSumPath(n);
        System.out.println(max);
    }

    private static int maxSumPath(Node n) {
        if (n == null)
            return 0;
        int leftSum = maxSumPath(n.left);
        int rightSum = maxSumPath(n.right);
        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
        max = Math.max(max, leftSum + rightSum + n.info);
        return Math.max(leftSum, rightSum) + n.info;
    }
}
