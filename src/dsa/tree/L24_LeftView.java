package dsa.tree;

import java.util.Map;
import java.util.TreeMap;

public class L24_LeftView {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.right.right = new Node(7);
        n.left.right.left = new Node(6);
        Map<Integer, Integer> map = new TreeMap<>();
        leftView(n, 0, map);
        System.out.println(map);
    }

    private static void leftView(Node n, int level, Map<Integer, Integer> map) {
        if (n == null)
            return;

        if (!map.containsKey(level))
            map.put(level, n.info);

        leftView(n.left, level + 1, map);
        leftView(n.right, level + 1, map);
    }
}
