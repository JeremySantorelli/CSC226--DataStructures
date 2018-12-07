package week8_DoublyLinkedList;

/**
 *
 * @author Jeremy Santorelli
 */
public class Node<T> {

    private T info;
    private Node<T> front;
    private Node<T> rear;

    public Node(T info) {
        this.info = info;
        this.front = null;
        this.rear = null;
    }

    public Node(T info, Node<T> front, Node<T> rear) {
        this.info = info;
        this.front = front;
        this.rear = rear;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getFrontLink() {
        return front;
    }

    public Node<T> getRearLink() {
        return rear;
    }

    public void setFrontLink(Node<T> link) {
        this.front = link;
    }

    public void setRearLink(Node<T> link) {
        this.rear = link;
    }

    @Override
    public String toString() {
        return "Node{" + "info=" + info + ", front=" + front + ", rear=" + rear + '}';
    }

}
