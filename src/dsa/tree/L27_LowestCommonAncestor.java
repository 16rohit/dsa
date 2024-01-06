package dsa.tree;

public class L27_LowestCommonAncestor {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(8);
        n.right.right = new Node(9);
        n.left.right.left = new Node(6);
        n.left.right.right = new Node(7);

        Integer ans = lca(n, 4, 7);
        if (ans == null)
            System.out.println("Not Found");
        else
            System.out.println(ans);
    }

    private static Integer lca(Node root, Integer n1, Integer n2) {
        if (root == null)
            return null;
        if (root.info == n1)
            return n1;
        if (root.info == n2)
            return n2;
        Integer left = lca(root.left, n1, n2);
        Integer right = lca(root.right, n1,n2);
        if (left != null && right != null)
            return root.info;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
