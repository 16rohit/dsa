package dsa.tree;

import java.util.*;

public class L19_SpiralOrderTraversal {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.right = new Node(6);
        System.out.println(spiralOrder(n));
    }

    private static List<List<Node>> spiralOrder(Node root) {
        List<List<Node>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            LinkedList<Node> inner = new LinkedList<>();
            while (!queue.isEmpty()) {
                Node n = queue.poll();
                inner.add(n);
            }
            LinkedList<Node> inner1 = new LinkedList<>(inner);
            if (!leftToRight) {
                Collections.reverse(inner1);
                ans.add(inner1);
            } else {
                ans.add(inner);
            }
            leftToRight = !leftToRight;
            for (Node ni : inner) {
                if (ni.left != null) queue.offer(ni.left);
                if (ni.right != null) queue.offer(ni.right);
            }
        }
        return ans;

    }
}
