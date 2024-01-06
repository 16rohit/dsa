package dsa.tree;

import dsa.util.Pair;

import java.util.Map;
import java.util.TreeMap;

public class L23_BottomView {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.left.right.left = new Node(8);
        n.left.right.right = new Node(9);
        n.right.left = new Node(6);
        n.right.right = new Node(7);
        Map<Integer, Pair<Integer, Integer>> map = new TreeMap<>();
        bottomView(n, 0, 0, map);
        System.out.println(map);
    }

    private static void bottomView(Node n, int level, int vertical, Map<Integer, Pair<Integer, Integer>> map) {
        if (n == null) return;

        Pair<Integer, Integer> pnew;
        if (map.containsKey(vertical)){
            Pair<Integer, Integer> p = map.get(vertical);
            int currLevel = p.getFirst();
            if(currLevel<level)
                pnew = new Pair<>(level, n.info);
            else
                pnew = p;
        } else {
            pnew = new Pair<>(level, n.info);
        }

        map.put(vertical, pnew);
        bottomView(n.left, level + 1, vertical - 1, map);
        bottomView(n.right, level + 1, vertical + 1, map);
    }
}
