package dsa.tree;

import java.util.Stack;

public class L9_IterativePreOrder {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.left = new Node(6);
        n.right.right = new Node(7);

        preorder(n);
    }

    private static void preorder(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            System.out.print(n.info);
            if (n.right != null) stack.push(n.right);
            if (n.left != null) stack.push(n.left);
        }


    }
}
