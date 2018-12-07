package week6_Queue;

import java.util.NoSuchElementException;

/**
 *
 * @author jerem
 */
public class LinkedQueue<T> {



    private Node<T> head = null;
    private Node<T> tail = null;

    public void enqueue(T item) {
        Node<T> newNode = new Node(item, null);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setLink(newNode);
        }
        tail = newNode;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is Empty");
        }
        T item = head.getInfo();
        if (tail == head) {
            tail = null;
        }
        head = head.getLink();
        return item;
    }

    public T peek() {
        if (head == null) {
            throw new NoSuchElementException("Queue is Empty");
        }
        return head.getInfo();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        for (Node node = head; node != null; node = node.getLink()) {
            count++;
        }
        return count;
    }

    @Override
    public String toString() {
        Node<T> next = head;
        String str = "[";
        boolean first = true;
        while (next != null) {
            if (first) {
                str += next.getInfo();
                first = false;
            } else {
                str += ", " + next.getInfo();
            }
            next = next.getLink();

        }

        return str + "]";
    }

}
