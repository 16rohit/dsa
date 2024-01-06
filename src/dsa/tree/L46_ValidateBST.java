package dsa.tree;

public class L46_ValidateBST {
    public static void main(String[] args) {
        Node n = new Node(5);
        n.left = new Node(1);
        n.right = new Node(6);
        n.right.left = new Node(4);
        n.right.right = new Node(8);

        boolean ans = validateBST(n, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    private static boolean validateBST(Node n, int minValue, int maxValue) {
        if (n == null)
            return true;
        if (n.info < minValue || n.info > maxValue)
            return false;
        return validateBST(n.left, minValue, n.info) && validateBST(n.right, n.info, maxValue);
    }
}
