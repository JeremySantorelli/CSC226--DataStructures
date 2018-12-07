package week7_SortedList;

/**
 *
 * @author Jeremy Santorelli
 * @param <T>
 */
public class LinkedSortedList<T extends Comparable<T>> {

    private Node<T> head;
    private int size;

    public LinkedSortedList() {
        head = null;
        size = 0;
    }

    private LinkedSortedList(Node<T> head) {
        this.head = head;
    }

    public void add(Comparable item) {
        Node<T> newNode = new Node(item);
        if (head == null) {
            head = newNode;
            size++;
            return;
        } else if (item.compareTo(head.getInfo()) < 0) {
            newNode.setLink(head);
            head = newNode;
            size++;
        } else {
            Node<T> after = head.getLink();
            Node<T> before = head;
            while (after != null) {
                if (item.compareTo(after.getInfo()) < 0) {
                    break;
                }
                before = after;
                after = after.getLink();
            }
            // insert between before & after
            newNode.setLink(before.getLink());
            before.setLink(newNode);
            size++;
        }

    }

    public void remove(T item) {

        Node<T> next = head;
        Node<T> last = null;
        if (head.getInfo().equals(item)) {
            head = head.getLink();
            size--;
            return;
        }
        while (next != null) {
            if (next.getInfo().equals(item)) {
                last.setLink(next.getLink());
                break;
            }
            last = next;
            next = next.getLink();
        }

    }

    public boolean contains(Object item) {
        Node<T> next = head;

        while (next != null) {
            if (next.getInfo().equals(item)) {
                return true;
            }
            next = next.getLink();
        }
        return false;
    }

    //Question 1
    public void removeAll(T i) {

        if (head == null) {
        } else if (head.getInfo().equals(i)) {
            head = head.getLink();
            size--;
        } else {
            Node<T> next = head;
            Node<T> last = head;
            int count = 0;
            while (next != null) {
                if (next.getInfo().compareTo(i) < 0) {
                    last = next;
                } else if (next.getInfo().compareTo(i) == 0) {
                    if (count + 1 == size) {
                        last.setLink(null);
                        size--;
                        return;
                    }
                } else if (next.getInfo().compareTo(i) > 0) {
                    break;
                }
                next = next.getLink();
                count++;
            }
            if (next != null) {
                last.setLink(next);

            }
        }
    }

    //Question 2
    public void removeAllButOne(T i) {

        if (head == null) {
        } else {
            Node<T> next = head;
            Node<T> last = head;
            int count = 0;
            int leftCount = 0;

            if (next.getInfo().compareTo(i) == 0) {
                next = next.getLink();
            }
            while (next != null) {

                if (next.getInfo().compareTo(i) == 0) {
                    if (leftCount == 0) {
                        last = next;
                        leftCount++;
                    } else if (count + 1 == size) {
                        last.setLink(null);
                        size--;
                        return;
                    }
                } else if (next.getInfo().compareTo(i) > 0) {
                    break;
                }
                next = next.getLink();
                count++;
            }
            last.setLink(next);

        }

    }

    @Override
    public String toString() {
        Node<T> next = head;
        String str = "[ ";

        while (next != null) {
            str += next.getInfo() + " ";
            next = next.getLink();
        }
        return str + " ]";
    }

}
