package dsa.tree;

import java.util.Map;
import java.util.TreeMap;

public class L22_TopView {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.left.right.left = new Node(6);
        n.right.right = new Node(7);
        Map<Integer, Integer> map = new TreeMap<>();
        topView(n, 0, map);
        System.out.println(map);
    }

    private static void topView(Node n, int vertical, Map<Integer, Integer> map) {
        if (n == null) return;

        if (map.containsKey(vertical)) return;

        map.put(vertical, n.info);
        topView(n.left, vertical - 1, map);
        topView(n.right, vertical + 1, map);
    }
}
