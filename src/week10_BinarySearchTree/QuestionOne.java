package week10_BinarySearchTree;

/**
 *
 * @author Jeremy Santorelli
 */
public class QuestionOne extends BinarySearchTree {

    /**
     * ****************LEAF COUNT***********************
     *
     * QUESTION 22
     *
     * @return
     */
    public int leafCount() {
        return leafCount(getRoot());
    }

    private int leafCount(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else {
            return leafCount(node.left) + leafCount(node.right);
        }
    }

    /**
     * ********************SINGLE PARENT COUNT ****************
     *
     * QUESTION 23
     *
     * @return
     */
    public int singleParent() {
        return getSingleParents(getRoot());
    }

    private int getSingleParents(Node node) {
        int count = 0;
        if (node != null) {
            if (node.left == null && node.right != null) {
                count++;
            } else if (node.left != null & node.right == null) {
                count++;
            }
            count += getSingleParents(node.left);
            count += getSingleParents(node.right);
        }
        return count;
    }

    /**
     * ***************CHECK IF TWO TREES HAVE THE SAME SHAPE
     *
     * QUESTION 24
     *
     *********
     * @param comp
     * @return
     */
    public boolean similarTrees(BinarySearchTree comp) {

        return similarTrees(comp.getRoot(), getRoot());
    }

    private boolean similarTrees(Node compare, Node compareTo) {
        if (compare == null && compareTo == null) {
            return true;
        }

        if ((compare == null && compareTo != null)
                || (compare != null && compareTo == null)) {
            return false;
        }

        return similarTrees(compare.left, compareTo.left)
                && similarTrees(compare.right, compareTo.right);
    }

}
