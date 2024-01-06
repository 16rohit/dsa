package dsa.tree;

public class L40_SearchInBST {
    public static void main(String[] args) {
        Node n = new Node(10);
        n.left = new Node(5);
        n.right = new Node(13);
        n.left.left = new Node(3);
        n.left.right = new Node(6);
        n.left.left.left = new Node(2);
        n.left.left.right = new Node(4);
        n.left.right.right = new Node(9);
        n.right.left = new Node(11);
        n.right.right = new Node(13);

        Node x = search(n, 6);
        System.out.println(x);
    }

    private static Node search(Node n, int x) {
        while (n != null) {
            if (n.info == x)
                return n;
            else if (n.info > x)
                n = n.left;
            else
                n = n.right;
        }
        return null;
    }

}
