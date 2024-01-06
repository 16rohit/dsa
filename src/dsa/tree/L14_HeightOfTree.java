package dsa.tree;

public class L14_HeightOfTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);
        n.right.right = new Node(7);
        n.right.right.right = new Node(8);
        n.right.right.right.left = new Node(9);

        int h = findHeight(n);
        System.out.println(h);
    }

    private static int findHeight(Node root) {
        if (root == null)
            return 0;
        int leftHeight = root.left != null ? findHeight(root.left) : 0;
        int rightHeight = root.right != null ? findHeight(root.right) : 0;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
