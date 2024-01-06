package dsa.tree;

public class L43_InsertNodeInBST {
    public static void main(String[] args) {
        Node n = new Node(4);
        n.left = new Node(2);
        n.right = new Node(7);
        n.left.left = new Node(1);
        n.left.right = new Node(3);

        int x = 5;
        Node ans = insert(n, x);
        System.out.println(ans);
    }

    private static Node insert(Node n, int x) {
        Node prev = null;
        while (n != null) {
            prev = n;
            if (n.info == x)
                return n;
            else if (n.info > x) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        if (prev == null)
            n = new Node(x);
        if (prev.info > x)
            prev.left = new Node(x);
        else
            prev.right = new Node(x);

        return n;
    }
}
