package week6_Queue;

/**
 *
 * @author Jeremy Santorelli
 * @param <T>
 */
public class CircularLinkedQ<T> {

    private Node<T> rear;

    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element, null);

        if (isEmpty()) {
            rear = newNode;
        } else if (element == null) {
            // do nothing
        } else {

            Node<T> front = front();
            newNode.setLink(front);
            this.rear.setLink(newNode);
        }
    }

    private Node<T> front() {
        return rear.getLink();
    }

    public T dequeue() {

        if (isEmpty()) {
            //do nothing
            return null;
        }
        T element;
        if (rear.getLink() == null) {
            element = this.rear.getInfo();
            rear = null;
        } else if (rear.getLink().getLink() == null) {
            element = this.rear.getInfo();
            rear = rear.getLink();
        } else {
            Node<T> last = null;
            Node<T> next = front();
            Node<T> front = front();
            while (next.getLink() != null) {
                last = next;
                next = next.getLink();
            }
            element = this.rear.getInfo();
            this.rear = next;
            last.setLink(null);
            this.rear.setLink(front);
        }
        return element;
    }

    public boolean isEmpty() {
        return rear == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "-> [ ] ->";
        } else {
            Node<T> next = front();
            String str = "-> [";
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
            return str + ", " + rear.getInfo() + "] ->";
        }
    }
}
