package dsa.tree;

public class L52_RecoverBSTIf2NodesSwapped {
    public static void main(String[] args) {
        Node n = new Node(3);
        n.left = new Node(1);
        n.right = new Node(4);
        n.right.left = new Node(2);
        n.drawTree(n);
        recoverBST(n);
        n.drawTree(n);
    }

    private static Node prev, first, mid, last;

    private static void recoverBST(Node n) {
        prev = new Node(Integer.MIN_VALUE);
        first = null;
        mid = null;
        last = null;
        inorder(n);
        if (first != null && last != null) {
            int temp = first.info;
            first.info = last.info;
            last.info = temp;
        } else if (first != null && mid != null) {
            int temp = first.info;
            first.info = mid.info;
            mid.info = temp;
        }
    }

    private static void inorder(Node n) {
        if (n == null)
            return;
        inorder(n.left);
        if (prev != null && n.info < prev.info) {
            if (first == null) {
                first = prev;
                mid = n;
            } else {
                last = n;
            }
        }
        prev = n;
        inorder(n.right);
    }
}
