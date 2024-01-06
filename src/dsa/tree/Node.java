package dsa.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int info;
    Node left;
    Node right;

    public Node(int info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" + info + "}";
    }

    public static void drawTree(Node root) {
        List<List<String>> lines = new ArrayList<>();
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();

        level.add(root);
        int nn = 1;
        int widest = 0;

        while (nn != 0) {
            nn = 0;
            List<String> line = new ArrayList<>();
            for (Node n : level) {
                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa = Integer.toString(n.info);
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.left);
                    next.add(n.right);

                    if (n.left != null) nn++;
                    if (n.right != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print((j % 2 == 0) ? " " : "─");
                        }
                        System.out.print((j % 2 == 0) ? "┌" : "┐");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print((j % 2 == 0) ? "─" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print the line of nodes
            for (String f : line) {
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }
}
