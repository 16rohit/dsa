package dsa.tree;

public class L38_FlattenBinaryTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right=  new Node(5);
        n.left.left = new Node(3);
        n.left.right = new Node(4);
        n.right.right = new Node(6);
        n.right.right.left = new Node(7);

        flattenTree(n);
        while(n != null) {
            System.out.print(n.info + " ");
            n = n.right;
        }
    }
    public static Node prev = null;
    private static void flattenTree(Node n) {
        if (n == null)
            return;
        flattenTree(n.right);
        flattenTree(n.left);
        n.right = prev;
        n.left = null;
        prev = n;
    }
}
