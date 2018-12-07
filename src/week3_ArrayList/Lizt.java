package week3_ArrayList;

/**
 *
 * @author jerem
 * @param <T>
 */
public interface Lizt<T> {

    void add(T item);

    void remove(T item);

    boolean contains(T item);

    public Lizt<T> retrieveEveryOtherItem();

    public void removeAt(int i);

    public void addToTop(T item);

    public void removeFirstTwo();

}
