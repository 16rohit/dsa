package dsa.tree;

public class L18_IdenticalTrees {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.right.left = new Node(4);
        n.right.right = new Node(5);

        Node n1 = new Node(1);
        n1.left = new Node(2);
        n1.right = new Node(3);
        n1.right.left = new Node(4);
        n1.right.right = new Node(5);

        boolean ans = isIdentical(n, n1);
        System.out.println(ans);
    }

    private static boolean isIdentical(Node n1, Node n2) {
        if (n1 == null && n2 == null)
            return true;
        else if (n1 == null || n2 == null)
            return false;

//        if (n1.info != n2.info)
//            return false;

        return n1.info == n2.info && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
    }
}
