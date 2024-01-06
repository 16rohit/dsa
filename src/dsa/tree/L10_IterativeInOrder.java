package dsa.tree;

import java.util.Stack;

public class L10_IterativeInOrder {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(7);
        n.left.left = new Node(3);
        n.left.right = new Node(4);
        n.left.right.left = new Node(5);
        n.left.right.right = new Node(6);

        inorder(n);
    }

    private static void inorder(Node root) {
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (true) {
//            if (root != null) {
//                stack.push(root);
//                root = root.left;
//            } else {
//                if (stack.isEmpty())
//            }
//        }
    }
}
