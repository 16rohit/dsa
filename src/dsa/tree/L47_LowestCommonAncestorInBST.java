package dsa.tree;

public class L47_LowestCommonAncestorInBST {
    public static void main(String[] args) {
        Node n = new Node(10);
        n.left = new Node(4);
        n.right = new Node(13);
        n.left.left = new Node(3);
        n.left.right = new Node(8);
        n.left.left.left = new Node(1);
        n.left.left.left.right = new Node(2);
        n.left.right.left = new Node(6);
        n.left.right.right = new Node(9);
        n.left.right.left.left = new Node(5);
        n.left.right.left.right = new Node(7);
        n.right.left = new Node(11);
        n.right.right = new Node(15);

        n.drawTree(n);

        int x = 5;
        int y = 9;

        int min = Math.min(x, y);
        int max = Math.max(x, y);
        Node lca = getLCA(n, min, max);
        System.out.println(lca);
    }

    private static Node getLCA(Node n, int x, int y) {
        if (n == null)
            return null;
        if ((n.info > x && n.info < y) || n.info == x || n.info == y)
            return n;
        if (n.info > x && n.info > y)
            return getLCA(n.left, x, y);
        else
            return getLCA(n.right, x, y);
    }


}
