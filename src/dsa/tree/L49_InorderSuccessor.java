package dsa.tree;

public class L49_InorderSuccessor {
    public static Node successor = null;

    public static void main(String[] args) {
        Node n = new Node(5);
        n.left = new Node(3);
        n.left.left = new Node(2);
        n.left.right = new Node(4);
        n.left.left.left = new Node(1);
        n.right = new Node(7);
        n.right.left = new Node(6);
        n.right.right = new Node(9);
        n.right.right.left = new Node(8);
        n.right.right.right = new Node(10);

        n.drawTree(n);
        for (int i = 1; i <= 10; ++i) {
            findInorderSuccessor(n, i);
            System.out.println(successor);
        }
        System.out.println("uding iterative");
        for (int i = 1; i <= 10; ++i) {
            Node ans = findInorderSuccessor2(n, i);
            System.out.println(ans);
        }
    }

    private static void findInorderSuccessor(Node n, int x) {
        if (n == null)
            return;
        else if (n.info == x) {
            if (n.right == null) {
            } else {
                n = n.right;
                while (n.left != null)
                    n = n.left;
                successor = n;
            }

        } else if (n.info < x)
            findInorderSuccessor(n.right, x);
        else {
            successor = n;
            findInorderSuccessor(n.left, x);
        }
    }

    private static Node findInorderSuccessor2(Node n, int x) {
        Node suc = null;
        while (n != null) {
            if (n.info <= x) {
                n = n.right;
            } else {
                suc = n;
                n = n.left;
            }
        }
        return suc;
    }
}


