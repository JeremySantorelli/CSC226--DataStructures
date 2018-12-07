package week3_ArrayList;

import java.util.Arrays;

/**
 *
 * @author jerem
 * @param <T>
 */
public class ArrayLizt<T> implements Lizt<T> {

    private T[] t;
    private T[] temp;
    private int size;
    private int count = 0;

    public ArrayLizt() {
        this.size = 20;
        t = (T[]) new Object[size];
    }

    private ArrayLizt(T[] z) {
        this.size = z.length;
        t = (T[]) z;
    }

    @Override
    public void add(T item) {
        if (size - 1 < count + 1) {
            increaseArray();
        }
        this.t[count] = item;
        this.count++;

    }

    @Override
    public void remove(T item) {
        temp = (T[]) new Object[t.length];
        for (int i = 0; i < t.length; i++) {
            if (t[i] == null) {
                break;
            } else if (item != null) {
                if (!t[i].equals(item)) {
                    temp[i] = t[i];
                }
            }
        }
        t = temp;
        temp = null;
    }

    @Override
    public boolean contains(T item) {

        for (int i = 0; i < 100; i++) {
            if (t[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    private void increaseArray() {
        size += 20;
        temp = (T[]) new Object[size];
        for (int i = 0; i < t.length; i++) {

            temp[i] = t[i];

        }
        t = temp;
        temp = null;

    }

    // (1A) The method retrieves every other item starting from the first, and saves them in a returned list.  
    @Override
    public Lizt<T> retrieveEveryOtherItem() {

        int tLen = t.length - 1;
        int newLen = 0;

        if (tLen == -1) {
            return new ArrayLizt<>(t);
        } else if ((tLen % 2) == 0) {
            newLen = tLen / 2;
        } else {
            newLen = (tLen / 2) + 1;
        }

        temp = (T[]) new Object[newLen];
        int iterate = 0;
        for (int skip = 0; skip <= tLen; skip += 2) {
            if (t[skip] == null) {
                break;
            } else {
                temp[iterate] = t[skip];
                iterate++;
            }
        }
        return new ArrayLizt<>(temp);
    }

    // (1B) The method removes the item at the given index i if the index is valid, otherwise the method does nothing.
    @Override
    public void removeAt(int index) {
        if (index > -1 && index < t.length) {
            temp = (T[]) new Object[t.length];
            int tIndex = 0;
            for (int i = 0; i < t.length; i++) {
                if (i == index) {
                    i++;
                }
                temp[tIndex++] = t[i];
            }
            t = temp;
            temp = null;
        }
    }

    //(EC) Instead of add last, it adds first
    @Override
    public void addToTop(T item) {
        temp = (T[]) new Object[t.length + 1];
        temp[0] = item;
        for (int i = 0; i < t.length; i++) {
            temp[i + 1] = t[i];
        }
        t = temp;
        temp = null;

    }

    //(EC) remove First Two
    @Override
    public void removeFirstTwo() {
        temp = (T[]) new Object[t.length - 2];
        for (int i = 0; i < t.length - 2; i++) {
            temp[i] = t[i + 2];
        }
        t = temp;
        temp = null;
    }

    @Override
    public String toString() {
        String str = "{";
        for (int i = 0; i < t.length; i++) {

            if (t[i] != null) {
                str += t[i] + " ";
            }

        }
        String finalString = str.substring(0, str.length() - 2) + "}";

        return finalString;
    }

}
