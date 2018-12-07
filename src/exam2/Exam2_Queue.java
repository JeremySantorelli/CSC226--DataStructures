package exam2;

import java.util.Stack;

/**
 * QUESTION 2
 *
 * @author Jeremy Santorelli
 * @param <T>
 */
public class Exam2_Queue<T> {

    Stack<T> inbox, outbox;

    public Exam2_Queue() {
        this.inbox = new Stack<>();
        this.outbox = new Stack<>();
    }

    public void enqueue(T item) {
        inbox.push(item);
    }

    public T dequeue() {
        if (outbox.isEmpty() && !inbox.isEmpty()) {
            Stack<T> set = inbox;
            outbox = set;
        }
        return outbox.pop();
    }

    public boolean isEmpty() {
        return this.inbox.isEmpty() && this.outbox.isEmpty();
    }
}
