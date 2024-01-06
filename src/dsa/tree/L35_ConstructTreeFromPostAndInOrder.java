package dsa.tree;

public class L35_ConstructTreeFromPostAndInOrder {
    public static void main(String[] args) {
        int[] inorder = new int[]{40, 20, 50, 10, 60, 30};
        int[] postorder = new int[]{40, 50, 20, 60, 30, 10};
        Node n = constructTree(inorder, postorder, inorder.length);
        System.out.println(n);
    }

    private static Node constructTree(int[] inorder, int[] postorder, int len) {
        if (len == 0)
            return null;

        int nodeVal = postorder[len - 1];
        Node n = new Node(nodeVal);

        int[] leftInorder = new int[len];
        int[] rightInorder = new int[len];
        int[] leftPostorder = new int[len];
        int[] rightPostorder = new int[len];
        int leftLen = 0;
        int rightLen = 0;

        int i = 0;

        for (; i < len; ++i) {
            if (inorder[i] == nodeVal)
                break;
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
            leftLen++;
        }

        i++;
        int j = 0;
        for (; i < len; ++i) {
            rightInorder[j] = inorder[i];
            rightPostorder[j] = postorder[i - 1];
            j++;
            rightLen++;
        }

        n.left = constructTree(leftInorder, leftPostorder, leftLen);
        n.right = constructTree(rightInorder, rightPostorder, rightLen);
        return n;
    }
}

