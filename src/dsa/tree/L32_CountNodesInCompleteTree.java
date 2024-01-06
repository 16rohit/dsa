package dsa.tree;

public class L32_CountNodesInCompleteTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);
        n.right.right = new Node(7);
        n.left.left.left = new Node(8);
        n.left.left.right = new Node(9);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(11);

        int x = countNodes(n);
        System.out.println(x);
    }

    private static int countNodes(Node n) {
        if (n == null)
            return 0;
        int left = leftHeight(n);
        int right = rightHeight(n);
        if (left == right)
            return ((int) Math.pow(2, left)) - 1;
        else
            return 1 + (n.left != null ? countNodes(n.left) : 0) + (n.right != null ? countNodes(n.right) : 0);
    }

    private static int rightHeight(Node n) {
        int count = 0;
        while (n != null) {
            count++;
            n = n.right;
        }
        return count;
    }

    private static int leftHeight(Node n) {
        int count = 0;
        while (n != null) {
            count++;
            n = n.left;
        }
        return count;
    }
}
