package dsa.tree;

public class L29_ChildrenSumProperty {
    public static void main(String[] args) {
        Node n = new Node(40);
        n.left = new Node(10);
        n.right = new Node(20);
        n.left.left = new Node(2);
        n.left.right = new Node(5);
        n.right.left = new Node(30);
        n.right.right = new Node(40);

        //TODO: wrong answer.
        solveCSP(n);
        System.out.println(n);
    }

    private static void solveCSP(Node n) {
        if (n == null)
            return;

        int childSum = 0;
        if (n.left != null)
            childSum += n.left.info;
        if (n.right != null)
            childSum += n.right.info;

        if (childSum >= n.info) {
            n.info = childSum;
        } else {
            if (n.left != null)
                n.left.info = n.info;
            if (n.right != null)
                n.right.info = n.info;
        }

        solveCSP(n.left);
        solveCSP(n.right);

        int total = 0;
        if (n.left != null)
            total += n.left.info;
        if (n.right != null)
            total += n.right.info;
        if (n.left != null || n.right != null)
            n.info = total;
    }
}
