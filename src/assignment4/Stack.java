package assignment4;

/**
 *
 * @author Jeremy Santorelli
 * @param <E>
 */
public interface Stack<E> {

    public void push(E item);

    public boolean isEmpty();

    public E top();

    public void pop();

    public int getCount();

}
