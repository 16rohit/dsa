package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

public class L36_SerializeDeserialize {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(13);
        n.right.left = new Node(4);
        n.right.right = new Node(5);
        String serializedString = serialize(n);
        System.out.println(serializedString);
        Node deserializeTree = deserialize(serializedString);
        System.out.println(deserializeTree);
    }

    public static String serialize(Node n) {
        String s = "";
        if (n == null)
            return s;
        Queue<Node> q = new LinkedList<>();
        q.offer(n);

        while (!q.isEmpty()) {
            Node polledNode = q.poll();
            if (polledNode == null)
                s = s + "#,";
            else
                s = s + polledNode.info + ",";

            if (polledNode != null) {
                q.offer(polledNode.left);
                q.offer(polledNode.right);
            }
        }
        return s.substring(0, s.length() - 1);
    }

    public static Node deserialize(String s) {
        String[] strArr = s.split(",");
        Queue<Node> q = new LinkedList<>();

        int i = 0;
        Node n = new Node(Integer.parseInt(strArr[0]));
        q.offer(n);
        i++;
        while (!q.isEmpty()) {
            Node polledNode = q.poll();
            if(strArr[i].equals("#")) {
                polledNode.left = null;
            } else {
                polledNode.left = new Node(Integer.parseInt(strArr[i]));
                q.offer(polledNode.left);
            }
            i++;
            if(strArr[i].equals("#")) {
                polledNode.right = null;
            } else {
                polledNode.right = new Node(Integer.parseInt(strArr[i]));
                q.offer(polledNode.right);
            }
            i++;
        }
        return n;
    }
}
