package dsa.tree;

public class L45_KthSmallestInBST {
    public static Node ans = null;
    public static int count = 0;

    public static void main(String[] args) {
        Node n = new Node(5);
        n.left = new Node(3);
        n.left.left = new Node(1);
        n.left.left.right = new Node(2);
        n.left.right = new Node(4);
        n.right = new Node(7);
        n.right.left = new Node(6);
        n.right.right = new Node(8);

        int k = 3;

        getKthSmallest(n, k);
        System.out.println(ans);
    }

    private static void getKthSmallest(Node n, int k) {
        if (n == null)
            return;
        if (ans != null)
            return;
        getKthSmallest(n.left, k);
        count++;
        if (k == count) {
            ans = n;
            return;
        }
        getKthSmallest(n.right, k);
    }
}
