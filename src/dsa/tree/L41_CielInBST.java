package dsa.tree;

public class L41_CielInBST {
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

        Node x = findCiel(n, 1);
        System.out.println(x);
    }

    private static Node findCiel(Node n, int x) {
        Node ans = null;
        while (n != null) {
            if (n.info == x)
                return n;
            if (n.info > x) {
                ans = n;
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return ans;
    }
}
