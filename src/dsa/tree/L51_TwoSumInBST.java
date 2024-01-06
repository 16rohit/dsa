package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class L51_TwoSumInBST {
    public static void main(String[] args) {
        Node n = new Node(5);
        n.left = new Node(3);
        n.right = new Node(6);
        n.left.left = new Node(2);
        n.left.right = new Node(4);
        n.right.right = new Node(7);

        int k = 9;

        boolean ans = twoSum(n, k);
        System.out.println(ans);
    }

    public static List<Integer> inorder = new ArrayList<>();

    private static boolean twoSum(Node n, int k) {
        findInorder(n);
        int i = 0;
        int j = inorder.size() - 1;
        while (i < j) {
            int val = inorder.get(i) + inorder.get(j);
            if (val == k)
                return true;
            if (val < k)
                i++;
            else
                j--;
        }
        return false;
    }

    private static void findInorder(Node n) {
        if (n == null)
            return;
        findInorder(n.left);
        inorder.add(n.info);
        findInorder(n.right);
    }

}
