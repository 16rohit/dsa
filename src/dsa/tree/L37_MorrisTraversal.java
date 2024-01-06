package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class L37_MorrisTraversal {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(2);
        n.right = new Node(3);
        n.left.left = new Node(4);
        n.left.right = new Node(5);
        n.left.right.right = new Node(6);

        List<Integer> inorder = inorderTraversal(n);
        System.out.println(inorder);
    }

    private static List<Integer> inorderTraversal(Node n) {
        List<Integer> ans = new ArrayList<>();
        if (n == null)
            return ans;

        while (n != null) {
            if (n.left == null) {
                ans.add(n.info);
                n = n.right;
            } else {
                Node prev = n.left;
                while (prev.right != null && prev.right.info != n.info) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = n;
                    n = n.left;
                } else {
                    prev.right = null;
                    ans.add(n.info);
                    n = n.right;
                }
            }
        }
        return ans;
    }
}
