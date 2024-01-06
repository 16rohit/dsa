package dsa.tree;

import dsa.util.Pair;

import java.util.*;

public class L31_MinTimeToBurnTree {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.right.left = new Node(5);
        n.right.right = new Node(6);
        n.left.left.right = new Node(7);

        int target = 2;

        Map<Node, Node> parent = new HashMap<>();
        findParent(n, parent);
        Node targetNode = findNode(n, target);

        int ans = minTime(targetNode, parent);
        System.out.println(ans);
    }

    private static int minTime(Node targetNode, Map<Node, Node> parent) {

        if (targetNode == null)
            return 0;

        int ans = 0;
        Set<Node> visited = new HashSet<>();

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(targetNode, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> polledPair = q.poll();
            Node polledNode = polledPair.getFirst();
            int dist = polledPair.getSecond();

            ans = Math.max(ans, dist);

            if (polledNode.left != null && !visited.contains(polledNode.left)) {
                q.offer(new Pair<>(polledNode.left, dist + 1));
                visited.add(polledNode.left);
            }
            if (polledNode.right != null && !visited.contains(polledNode.right)) {
                q.offer(new Pair<>(polledNode.right, dist + 1));
                visited.add(polledNode.right);
            }
            if (parent.get(polledNode) != null && !visited.contains(parent.get(polledNode))) {
                q.offer(new Pair<>(parent.get(polledNode), dist + 1));
                visited.add(parent.get(polledNode));
            }
        }
        return ans;
    }

    private static Node findNode(Node n, int target) {
        if (n == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(n);
        while (!q.isEmpty()) {
            Node polledNode = q.poll();
            if (polledNode.info == target)
                return polledNode;

            if (polledNode.left != null)
                q.offer(polledNode.left);
            if (polledNode.right != null)
                q.offer(polledNode.right);
        }
        return null;
    }

    private static void findParent(Node n, Map<Node, Node> parent) {
        if (n == null)
            return;
        Queue<Pair<Node, Node>> q = new LinkedList<>();
        q.offer(new Pair<>(n, null));

        while (!q.isEmpty()) {
            Pair<Node, Node> polledPair = q.poll();
            Node polledNode = polledPair.getFirst();
            Node polledParent = polledPair.getSecond();

            parent.put(polledNode, polledParent);

            if (polledNode.left != null)
                q.offer(new Pair<>(polledNode.left, polledNode));
            if (polledNode.right != null)
                q.offer(new Pair<>(polledNode.right, polledNode));
        }
    }
}
