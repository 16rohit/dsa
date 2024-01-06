package dsa.tree;

public class L53_LargestBSTInBinaryTree {
    public static void main(String[] args) {
        Node n = new Node(20);
        n.left = new Node(15);
        n.left.left = new Node(14);
        n.left.right = new Node(18);
        n.left.left.right = new Node(17);
        n.left.right.left = new Node(10);
        n.left.right.right = new Node(19);
        n.right = new Node(40);
        n.right.left = new Node(30);
        n.right.right = new Node(60);
        n.right.right.left = new Node(50);

        NodeVal ans = findLargestBST(n);
        System.out.println(ans.size);
    }

    private static NodeVal findLargestBST(Node n) {
        if (n == null)
            return new NodeVal(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        NodeVal left = findLargestBST(n.left);
        NodeVal right = findLargestBST(n.right);

        if (n.info > left.maxNode && n.info < right.minNode) {
            return new NodeVal(1 + left.size + right.size, Math.min(left.minNode, n.info), Math.max(right.maxNode, n.info));
        } else {
            return new NodeVal(Math.max(left.size, right.size), Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
    }
}

class NodeVal {
    int size;
    int maxNode;
    int minNode;

    public NodeVal(int size, int maxNode, int minNode) {
        this.size = size;
        this.maxNode = maxNode;
        this.minNode = minNode;
    }

    @Override
    public String toString() {
        return "NodeVal{" +
                "size=" + size +
                ", maxNode=" + maxNode +
                ", minNode=" + minNode +
                '}';
    }
}
