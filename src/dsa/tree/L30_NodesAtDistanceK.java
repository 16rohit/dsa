package dsa.tree;

import dsa.util.Pair;

import java.util.*;

public class L30_NodesAtDistanceK {
    public static void main(String[] args) {
        Node n = new Node(3);
        n.left = new Node(5);
        n.right = new Node(1);
        n.left.left = new Node(6);
        n.left.right = new Node(2);
        n.right.left = new Node(0);
        n.right.right = new Node(8);
        n.left.right.left = new Node(7);
        n.left.right.right = new Node(4);

        int k = 2;
        int target = 5;

        Map<Node, Node> parent = new HashMap<>();
        pointParentNodes(n, parent);
        Node targetNode = findNode(n, target);
        List<Node> ans = getNodesAtDistance(targetNode, k, parent);
        System.out.println(ans);
    }

    private static List<Node> getNodesAtDistance(Node targetNode, int k, Map<Node, Node> parent) {

        if (targetNode == null)
            return new ArrayList<>();

        Set<Node> visited = new HashSet<>();

        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(targetNode, 0));
        visited.add(targetNode);
        while (!q.isEmpty()) {
            Pair<Node, Integer> polledPair = q.poll();
            Node polledNode = polledPair.getFirst();
            int dist = polledPair.getSecond();

            if (dist == k) {
                q.offer(polledPair);
                break;
            }

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

        List<Node> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().getFirst());
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

    private static void pointParentNodes(Node n, Map<Node, Node> parent) {
        Queue<Pair<Node, Node>> q = new LinkedList<>();
        q.offer(new Pair<>(n, null));
        while (!q.isEmpty()) {
            Pair<Node, Node> polled = q.poll();
            Node polledNode = polled.getFirst();
            Node polledParent = polled.getSecond();
            parent.put(polledNode, polledParent);
            if (polledNode.left != null)
                q.offer(new Pair<>(polledNode.left, polledNode));
            if (polledNode.right != null)
                q.offer(new Pair<>(polledNode.right, polledNode));
        }
    }
}
