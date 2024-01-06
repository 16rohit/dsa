package dsa.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L21_VerticalOrderTraversal {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.left.right = new Node(10);
        n.right = new Node(3);
        n.right.left = new Node(9);
        n.right.right = new Node(10);
        n.left.left = new Node(4);
        n.left.left.right = new Node(5);
        n.left.left.right.right = new Node(6);
        Map<Integer, List<Integer>> map = new HashMap<>();
        getVerticalOrder(n, 0, 0, map);
        System.out.println(map);
    }

    public static void getVerticalOrder(Node n, int level, int verticle, Map<Integer, List<Integer>> map) {

        if (n == null)
            return;

        List<Integer> li = map.get(verticle);
        if (li == null)
            li = new ArrayList<>();

        li.add(n.info);
        map.put(verticle, li);
        getVerticalOrder(n.left, level + 1, verticle - 1, map);
        getVerticalOrder(n.right, level + 1, verticle + 1, map);
    }
}
