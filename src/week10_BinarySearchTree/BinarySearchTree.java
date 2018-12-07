package week10_BinarySearchTree;

public class BinarySearchTree<T> {

    /* Class containing left and right child of current node and key value*/
    // Root of BST 
    private Node<T> root;
    private int size;

    // Constructor 
    public BinarySearchTree() {
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    /**
     * ******************INSERT
     *
     **************************
     * @param key
     */
    public void insert(T key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, T key) {
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node<>(key);
            return root;
        }
        /* Otherwise, recur down the tree */
        if (((Comparable<T>) root.key).compareTo(key) > 0) {
            root.left = insertRec(root.left, key);
            root.left.parent = root;
        } else if (((Comparable<T>) root.key).compareTo(key) < 0) {
            root.right = insertRec(root.right, key);
            root.right.parent = root;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    /**
     * ***********************PRINT ASCENDING**************
     */
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST 
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    /**
     * ***************REMOVE*****************************
     */
    public T remove() {

        return null;
    }

    /**
     * ****************BALANCE***************************
     */
    public void balance() {

    }

    @Override
    public String toString() {
        return root.drawTree(root);
    }

}
