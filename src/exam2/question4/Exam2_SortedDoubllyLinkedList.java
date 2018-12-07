package exam2.question4;

import exam2.question4.Node;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author Jeremy Santorelli
 * @param <T>
 */
public class Exam2_SortedDoubllyLinkedList<T> implements Iterable<T> {

    private Comparator<T> comparator;
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Exam2_SortedDoubllyLinkedList() {
        size = 0;
    }

    public Exam2_SortedDoubllyLinkedList(Comparator<T> comparator) {
        this.comparator = comparator;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T item) {
        if (item == null) {
            return;
        }
        Node newNode = new Node(item);
        makeComparable(item);

        if (head == null) {
            head = newNode;
            size++;
            return;
        } else if (head.getFrontLink() == null) {
            if (comparator.compare(head.getInfo(), item) >= 0) {
                newNode.setFrontLink(head);
                head.setRearLink(newNode);
                tail = head;
                head = newNode;

            } else {
                newNode.setRearLink(head);
                head.setFrontLink(newNode);
                tail = newNode;
            }
            size++;
            return;

        }
        Node<T> cursor = head.getFrontLink();
        while (cursor != null) {
            if (comparator.compare(cursor.getInfo(), item) >= 0) {
                break;
            }
            cursor = cursor.getFrontLink();

        }

        newNode.setFrontLink(cursor);

        newNode.setFrontLink(cursor);
        newNode.setRearLink(cursor.getRearLink());
        if (cursor.getRearLink() == null) {

            head.setFrontLink(newNode);
        } else {
            cursor.getRearLink().setFrontLink(newNode);
        }
        if (cursor == null) {
            tail.setRearLink(newNode);
        } else {
            cursor.setRearLink(newNode);
        }

        size++;

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

    public void remove(T item) {
        if (head == null) {
        } else if (head.getFrontLink() == null) {
            if (head.getInfo().equals(item)) {
                head = null;
                tail = null;
                size--;
            }
        } else if (head.getInfo().equals(item)) {

            head = head.getFrontLink();
            head.setRearLink(null);
            size--;
        } else {

            Node<T> cursor = head;

            while (cursor != null) {
                if (cursor.getInfo().equals(item)) {
                    if (cursor.getFrontLink() == null) {
                        cursor.getRearLink().setFrontLink(null);
                        tail = tail.getRearLink();
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

    public String iterateForward() {

        Node tmp = head;
        String str = "[ ";
        while (tmp != null) {
            str += tmp.getInfo() + " ";
            tmp = tmp.getFrontLink();
        }
        return str + "]";
    }

    public String iterateBackward() {

        Node tmp = tail;
        String str = "[ ";
        while (tmp != null) {
            str += tmp.getInfo() + " ";
            tmp = tmp.getRearLink();
        }
        return str + "]";
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> tmp = head;
        head = head.getFrontLink();
        head.setRearLink(null);
        size--;
        System.out.println("deleted: " + tmp.getInfo());
        return tmp.getInfo();
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node<T> cursor = tail;
        T remove = cursor.getInfo();
        while (cursor != null) {
            if (((Comparable<T>) cursor.getInfo()).compareTo(remove) == 0) {
                if (cursor.getFrontLink() == null) {
                    cursor.getRearLink().setFrontLink(null);
                    tail = tail.getRearLink();
                } else {
                    cursor.getRearLink().setFrontLink(cursor.getFrontLink());
                    cursor.getFrontLink().setRearLink(cursor.getRearLink());
                }
                size--;
            } else if (((Comparable<T>) cursor.getInfo()).compareTo(remove) < 0) {
                break;
            }
            cursor = cursor.getRearLink();
        }
        return remove;
    }

    public void removeEveryOtherItem() {
        Node<T> cursor = head.getFrontLink();
        int count = 0;
        while (cursor.getFrontLink() != null) {
            if (count % 2 == 0) {
                cursor.getRearLink().setFrontLink(cursor.getFrontLink());
                cursor.getFrontLink().setRearLink(cursor.getRearLink());
            }
            count++;
            cursor = cursor.getFrontLink();
        }
        size = count;

    }

    @Override
    public Iterator<T> iterator() {

        class DLLIterator<T> implements Iterator<T> {

            Node<T> cursor = (Node<T>) head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                if (cursor == null) {
                    return null;
                }
                T itemToReturn = cursor.getInfo();
                cursor = cursor.getFrontLink();
                return itemToReturn;
            }
        }
        return new DLLIterator<>();
    }
}
