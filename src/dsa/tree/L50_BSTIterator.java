package dsa.tree;

import java.util.Stack;

public class L50_BSTIterator {
    public static void main(String[] args) {
        Node n = new Node(7);
        n.left = new Node(3);
        n.left.left = new Node(2);
        n.left.left.left = new Node(1);
        n.left.right = new Node(6);
        n.left.right.left = new Node(5);
        n.left.right.left.left = new Node(4);
        n.right = new Node(10);
        n.right.left = new Node(9);
        n.right.left.left = new Node(8);

        BSTIterator iterator = new BSTIterator(n);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}

class BSTIterator {
    private Stack<Node> stack = new Stack<>();

    public BSTIterator(Node n) {
        pushAllLeft(n);
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node temp = stack.pop();
        pushAllLeft(temp.right);
        return temp.info;
    }

    private void pushAllLeft(Node n) {
        Node temp = n;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }
}
