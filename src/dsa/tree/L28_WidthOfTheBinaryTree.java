package dsa.tree;

import dsa.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L28_WidthOfTheBinaryTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.right.right = new Node(5);
        n.left.left.left = new Node(6);
        n.right.right.right = new Node(7);

        int max = findWidth(n);
        System.out.println(max);
    }

    private static int findWidth(Node n) {
        if (n == null)
            return 0;
        int ans = 0;

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(n, 0));

        while (!q.isEmpty()) {
            List<Pair<Node, Integer>> polledNodes = new ArrayList<>();
            while (!q.isEmpty()) {
                polledNodes.add(q.poll());
            }

            int start = 0;
            int end = 0;
            for (int i = 0; i < polledNodes.size(); ++i) {
                Pair<Node, Integer> polledNode = polledNodes.get(i);
                Node node = polledNode.getFirst();
                int index = polledNode.getSecond();
                if (i == 0)
                    start = index;
                if (i == polledNodes.size() - 1)
                    end = index;

                if (node.left != null)
                    q.offer(new Pair<>(node.left, 2 * index + 1));
                if (node.right != null)
                    q.offer(new Pair<>(node.right, 2 * index + 2));
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}
