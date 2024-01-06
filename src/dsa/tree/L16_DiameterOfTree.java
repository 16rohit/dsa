package dsa.tree;

public class L16_DiameterOfTree {
    public static int diameter = 0;

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);
        n.right.left.left = new Node(10);
        n.right.left.left.left = new Node(11);
        n.right.left.left.left.left = new Node(12);
        n.right.right = new Node(7);
        n.right.right.right = new Node(8);
        n.right.right.right.left = new Node(9);

        int h = findHeight(n);
        System.out.println(diameter);
    }

    private static int findHeight(Node n) {
        if (n == null)
            return 0;
        int leftHeight = n.left != null ? findHeight(n.left) : 0;
        int rightHeight = n.right != null ? findHeight(n.right) : 0;
        diameter = Math.max(leftHeight + rightHeight + 1, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
