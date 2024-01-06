package dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L20_BoundryTraversal {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.left.left = new Node(3);
        n.left.left.right = new Node(4);
        n.left.left.right.left = new Node(5);
        n.left.left.right.right = new Node(6);
        n.right = new Node(7);
        n.right.right = new Node(8);
        n.right.right.left = new Node(9);
        n.right.right.left.left = new Node(10);
        n.right.right.left.right = new Node(11);
        List<Integer> ans = boundaryTraversal(n);
        System.out.println(ans);
    }

    private static List<Integer> boundaryTraversal(Node n) {
        List<Integer> res = new ArrayList<>();
        if (n == null)
            return res;
        if (!isLeaf(n))
            res.add(n.info);
        addLeftBoundary(n.left, res);
        addLeafNodes(n, res);
        addRightBoundary(n.right, res);
        return res;
    }

    private static void addRightBoundary(Node n, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (!isLeaf(n)) {
            stack.push(n.info);
            if (n.right != null)
                n = n.right;
            else if (n.left != null)
                n = n.left;
        }
        while (!stack.isEmpty()) {
            int x = stack.pop();
            res.add(x);
        }
    }

    public static void addLeftBoundary(Node n, List<Integer> res) {
        while (!isLeaf(n)) {
            res.add(n.info);
            if (n.left != null)
                n = n.left;
            else if (n.right != null)
                n = n.right;
        }
    }

    public static void addLeafNodes(Node n, List<Integer> res) {
        if (isLeaf(n)) {
            res.add(n.info);
            return;
        }
        if (n.left != null)
            addLeafNodes(n.left, res);
        if (n.right != null)
            addLeafNodes(n.right, res);
    }

    public static boolean isLeaf(Node n) {
        if (n.left == null && n.right == null)
            return true;
        return false;
    }
}
