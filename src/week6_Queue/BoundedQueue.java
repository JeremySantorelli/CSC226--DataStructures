package week6_Queue;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 *
 * @author jerem
 * @param <T>
 */
public class BoundedQueue<T> {

    private final T[] array;
    private int size = 0;
    private int head = 0; // index of the current front item, if one exists
    private int tail = 0; // index of next item to be added

    public BoundedQueue(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void enqueue(T item) throws IllegalStateException {
        if (this.isFull()) {
            throw new IllegalStateException("Cannot add to full queue");
        }
        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }

    public T dequeue() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        T item = array[head];
        array[head] = null;
        head = (head + 1) % array.length;
        size--;
        return item;
    }

    public T peek() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException("Cannot peek into empty queue");
        }
        return array[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return (size) >= array.length;
    }

    @Override
    public String toString() {
        String st = "";
        boolean first = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (first) {
                    st += array[i].toString();
                    first = false;
                } else {
                    st += ", " + array[i].toString();
                }

            }
        }
        return st;
    }

}
