package dsa.tree;

public class L34_ConstructTreeFromPreAndInOrder {
    public static void main(String[] args) {
        int[] inorder = new int[]{40, 20, 50, 10, 60, 30};
        int[] preorder = new int[]{10, 20, 40, 50, 30, 60};
        Node n = constructTree(inorder, preorder, inorder.length);
        System.out.println(n);
    }

    private static Node constructTree(int[] inorder, int[] preorder, int len) {
        if (len == 0)
            return null;
        int rootVal = preorder[0];
        Node n = new Node(rootVal);

        //construct left
        int[] leftInorder = new int[len];
        int[] leftPreorder = new int[len];
        int[] rightInorder = new int[len];
        int[] rightPreorder = new int[len];
        int i = 0;
        int j = 0;
        int leftLen = 0;
        for (; i < len; ++i) {
            if (inorder[i] == rootVal)
                break;
            leftInorder[i] = inorder[i];
            leftPreorder[i] = preorder[i + 1];
            leftLen++;
        }

        //construct right
        i++;
        int rightLen = 0;
        for (; i < len; ++i) {
            rightInorder[j++] = inorder[i];
            rightPreorder[j - 1] = preorder[i];
            rightLen++;
        }

        n.left = constructTree(leftInorder, leftPreorder, leftLen);
        n.right = constructTree(rightInorder, rightPreorder, rightLen);
        return n;
    }
}
