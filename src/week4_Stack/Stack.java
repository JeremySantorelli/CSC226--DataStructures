package week4_Stack;

/**
 *
 * @author Jeremy Santorelli
 * @param <E>
 */
public interface Stack<E> {

    public void push(E item);

    public boolean isEmpty();

    public E top();

    public E pop();

    public void addSecond(E Item);
    
    public void removeLast();

}
