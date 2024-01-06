package dsa.tree;

public class L15_IsBalancedTree {
    public static boolean ans = true;

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.left.left = new Node(3);
        n.left.left.left = new Node(9);
        n.right = new Node(4);
        n.right.left = new Node(5);
        n.right.right = new Node(6);
        n.right.right.right = new Node(7);
        n.right.right.right.right = new Node(8);

        findHeight(n);
        System.out.println(ans);
    }

    private static int findHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = root.left != null ? findHeight(root.left) : 0;
        int rightHeight = root.right != null ? findHeight(root.right) : 0;
        ans = ans && (Math.abs(leftHeight - rightHeight) <= 1);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
