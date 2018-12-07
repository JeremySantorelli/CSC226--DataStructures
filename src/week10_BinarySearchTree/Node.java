package week10_BinarySearchTree;

import java.util.LinkedList;
import week10_BinarySearchTree.assigment.Movie;

/**
 *
 * @author jerem
 * @param <T>
 */
public class Node<T> {

    T key;
    Node<T> left, right;
    public Node<T> parent;

    int depth = 0;
    int level = 0;
    int drawPos = 0;

    public Node(T item) {
        key = item;
        left = right = null;
    }

    public T getKey() {
        return key;
    }

    public Node<T> getLeft() {
        return left;
    }

    public Node<T> getRight() {
        return right;
    }
    
    

    public String drawTree(Node root) {
        String ret = "";
        int depth = depth(root);
        setLevels(root, 0);

        int depthChildCount[] = new int[depth + 1];

        LinkedList<Node> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        // draw root first
        root.drawPos = (int) Math.pow(2, depth - 1) * H_SPREAD;
        currDrawLevel = root.level;
        currSpaceCount = root.drawPos;
        ret += getSpace(root.drawPos) + root.key;

        while (!q.isEmpty()) {
            Node ele = q.pollFirst();
            ret += drawElement(ele, depthChildCount, depth, q);
            if (ele == null) {
                continue;
            }
            q.add(ele.left);
            q.add(ele.right);
        }
        ret += "\n";

        return ret;
    }

    static int currDrawLevel = -1;
    static int currSpaceCount = -1;
    static final int H_SPREAD = 3;

    static String drawElement(Node ele, int depthChildCount[], int depth, LinkedList<Node> q) {
        String ret = "";
        if (ele == null) {
            return "";
        }

        if (ele.level != currDrawLevel) {
            currDrawLevel = ele.level;
            currSpaceCount = 0;
            ret += "\n";
            for (int i = 0; i < (depth - ele.level + 1); i++) {
                int drawn = 0;
                if (ele.parent.left != null) {
                    drawn = ele.parent.drawPos - 2 * i - 2;
                    ret += getSpace(drawn) + "/";
                }
                if (ele.parent.right != null) {
                    int drawn2 = ele.parent.drawPos + 2 * i + 2;
                    ret += getSpace(drawn2 - drawn) + "\\";
                    drawn = drawn2;
                }

                Node doneParent = ele.parent;
                for (Node sibling : q) {
                    if (sibling == null) {
                        continue;
                    }
                    if (sibling.parent == doneParent) {
                        continue;
                    }
                    doneParent = sibling.parent;
                    if (sibling.parent.left != null) {
                        int drawn2 = sibling.parent.drawPos - 2 * i - 2;
                        ret += getSpace(drawn2 - drawn - 1) + "/";
                        drawn = drawn2;
                    }

                    if (sibling.parent.right != null) {
                        int drawn2 = sibling.parent.drawPos + 2 * i + 2;
                        ret += getSpace(drawn2 - drawn - 1) + "\\";
                        drawn = drawn2;
                    }
                }
                ret += "\n";
            }
        }
        int offset = 0;
        int n = 0;
        if(ele.key instanceof Integer){
            n = (int) ele.key;
        }else{
            n = Integer.parseInt(((Movie) ele.key).getYear());
        }
        int numDigits = (int) Math.ceil(Math.log10(n));
        if (ele.parent.left == ele) {
            ele.drawPos = ele.parent.drawPos - H_SPREAD * (depth - currDrawLevel + 1);
            //offset = 2;
            offset += numDigits / 2;
        } else {
            ele.drawPos = ele.parent.drawPos + H_SPREAD * (depth - currDrawLevel + 1);
            //offset = -2;
            offset -= numDigits;
        }

        ret += getSpace(ele.drawPos - currSpaceCount + offset) + ele.key;
        currSpaceCount = ele.drawPos + numDigits / 2;
        return ret;
    }

    public void inOrderInteger(String sep) {
        if (left != null) {
            left.inOrderInteger(sep);
        }
        System.out.print(key + sep);
        if (right != null) {
            right.inOrderInteger(sep);
        }
    }

    public static int depth(Node n) {
        if (n == null) {
            return 0;
        }
        n.depth = 1 + Math.max(depth(n.left), depth(n.right));
        return n.depth;
    }

    public static int countNodes(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    static void setLevels(Node r, int level) {
        if (r == null) {
            return;
        }
        r.level = level;
        setLevels(r.left, level + 1);
        setLevels(r.right, level + 1);
    }

    static String getSpace(int i) {
        String s = "";
        while (i-- > 0) {
            s += " ";
        }
        return s;
    }

}
