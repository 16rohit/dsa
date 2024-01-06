package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class L26_RootToNodePath {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.left.right.left = new Node(6);
        n.left.right.right = new Node(7);

        int x = 6;
        List<Integer> path = new ArrayList<>();

        boolean ans = findPath(n, x, path);
        if (ans)
            System.out.println(path);
        else
            System.out.println("Not Found");
    }

    private static boolean findPath(Node n, int x, List<Integer> path) {
        if (n == null)
            return false;

        path.add(n.info);

        if (n.info == x)
            return true;

        boolean left = findPath(n.left, x, path);
        if (left)
            return true;
        boolean right = findPath(n.right, x, path);
        if (right)
            return true;

        path.remove(path.size()-1);
        return false;
    }
}
