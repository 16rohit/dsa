package dsa.tree;

public class L44_DeleteNodeInBST {
    public static void main(String[] args) {
        Node n = new Node(8);
        n.left = new Node(5);
        n.right = new Node(12);
        n.left.left = new Node(2);
        n.left.right = new Node(7);
        n.left.left.left = new Node(1);
        n.left.left.right = new Node(3);
        n.left.right.left = new Node(6);
        n.left.right.right = new Node(8);
        n.left.left.right.right = new Node(4);
        n.right.left = new Node(10);
        n.right.right = new Node(13);

        int x = 8;
        Node ans = deleteNode(n, x);
        System.out.println(ans);
    }

    private static Node deleteNode(Node root, int x) {
        if (root == null)
            return null;
        Node n = root;
        Node prev = null;
        while (n != null) {
            if (n.info == x) {
                break;
            } else if (n.info > x) {
                prev = n;
                n = n.left;
            } else {
                prev = n;
                n = n.right;
            }
        }
        if (n == null) {
            System.out.println("Not found");
            return null;
        }

        if (prev != null) {
            prev.left = n.left;
            Node detached = n.right;
            n = n.left;
            while (n.right != null) {
                n = n.right;
            }
            n.right = detached;
        } else {
            Node detached = root.right;
            root = root.left;
            Node r = root;
            while (r.right != null) {
                r = r.right;
            }
            r.right = detached;
        }
        return root;
    }
}
