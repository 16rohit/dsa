package dsa.tree;

public class L25_SymmetricTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(2);
        n.left.left = new Node(3);
        n.left.right = new Node(4);
        n.right.left = new Node(4);
        n.right.right = new Node(3);

        boolean a = isSymmetric(n.left, n.right);
        System.out.println(a);
    }

    private static boolean isSymmetric(Node left, Node right) {
        if(left == null || right == null)
            return left == right;

        return left.info == right.info
                && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);
    }
}
