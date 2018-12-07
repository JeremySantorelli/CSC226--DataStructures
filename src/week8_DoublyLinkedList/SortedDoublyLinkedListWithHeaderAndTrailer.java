package week8_DoublyLinkedList;

import java.util.Comparator;

/**
 * Question 1: implementation of a sorted doubly linked list with a dummy head
 * and tail
 *
 * @author jerem
 * @param <T>
 */
public class SortedDoublyLinkedListWithHeaderAndTrailer<T> {
    private Comparator<T> comparator;
    private Node<T> head, tail;
    private int size;

    public SortedDoublyLinkedListWithHeaderAndTrailer(T header, T trailer) {
        this.head = new Node(header);
        this.tail = new Node(trailer);
        this.head.setFrontLink(this.tail);
        this.tail.setRearLink(this.head);
        this.size = 0;
    }

    public void add(T item) {
        makeComparable(item);
        if (item == null || comparator.compare(head.getInfo(), item) > 0
                || comparator.compare(tail.getInfo(), item) < 0) {
            return;
        }
        Node newNode = new Node(item);
        Node<T> after = head.getFrontLink(), before = null;
        while (after != null) {
            if (comparator.compare(after.getInfo(), item) >= 0) {
                break;
            }
            before = after;
            after = after.getFrontLink();
        }
        newNode.setFrontLink(after);
        newNode.setRearLink(before);
        if (before == null) {
            head.setFrontLink(newNode);
        } else {
            before.setFrontLink(newNode);
        }
        if (after == null) {
            tail.setRearLink(newNode);
        } else {
            after.setRearLink(newNode);
        }
        size++;
    }

    public void remove(T item) {
        if (head.getFrontLink() == null) {
            if (head.getFrontLink().getInfo().equals(item)) {
                head.setFrontLink(null);
                tail.setRearLink(null);
                size--;
            }
        } else if (head.getFrontLink().getInfo().equals(item)) {
            head.setFrontLink(head.getFrontLink().getFrontLink());
            head.getFrontLink().setRearLink(null);
            size--;
        } else {
            Node<T> cursor = head.getFrontLink();
            while (cursor != null) {
                if (cursor.getInfo().equals(item)) {
                    if (cursor.getFrontLink() == null) {
                        cursor.getRearLink().setFrontLink(null);
                        tail.setRearLink(tail.getRearLink());
                    } else {
                        cursor.getRearLink().setFrontLink(cursor.getFrontLink());
                        cursor.getFrontLink().setRearLink(cursor.getRearLink());
                    }
                    size--;
                    break;
                }
                cursor = cursor.getFrontLink();
            }
        }
    }

    private void makeComparable(T item) {
        if (comparator != null) {
            return;
        } else {
            comparator = new Comparator<T>() {

                @Override
                public int compare(T o1, T o2) {
                    if ((item instanceof Comparable<?>)) {
                        return ((Comparable<T>) o1).compareTo(o2);
                    } else {
                        if (o1.equals(o2)) {
                            return 0;
                        } else {
                            return o1.hashCode() - o2.hashCode();
                        }
                    }
                }
            };

        }
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        Node<T> next = head.getFrontLink();
        String str = "";
        while (next != null) {
            str += next.getInfo() + " ";
            next = next.getFrontLink();
            if (next.getFrontLink() == null) {
                break;
            }
        }
        return str;
    }
}
