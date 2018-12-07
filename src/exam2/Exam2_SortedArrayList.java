package exam2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * QUESTION 3
 *
 * @author Jeremy Santorelli
 * @param <T>
 */
public class Exam2_SortedArrayList<T> {

    private Comparator<T> comparator;
    private T[] list;
    private int size;

    public Exam2_SortedArrayList(int cap) {
        list = (T[]) new Object[cap];
        size = 0;
    }

    public void add(T element) {
        if (element == null || size >= list.length) {
        } else {
            int indexWhere = -1;
            for (int i = 0; i < size; i++) {
                if (((Comparable<T>) list[i]).compareTo(element) >= 0) {
                    indexWhere = i;
                    break;
                }
            }
            if (indexWhere == -1) {
                list[size] = element;
                size++;
            } else {
                for (int i = size; i >= indexWhere; i--) {
                    if (i == indexWhere) {
                        list[i] = element;
                    } else {
                        list[i] = list[i - 1];
                    }
                }
                size++;
            }
        }
    }

    public void remove(T element) {
        int indexWhere = -1;
        for (int i = 0; i < size; i++) {
            if (((Comparable<T>) list[i]).compareTo(element) == 0) {
                indexWhere = i;
                break;
            }
        }
        if (indexWhere != -1) {

            for (int i = indexWhere; i < size - 1; i++) {

                list[i] = list[i + 1];
            }
            size--;
        }

    }

    public Exam2_SortedArrayList(int cap, final Comparator<T> comparator) {
        this.comparator = comparator;
        list = (T[]) new Object[cap];
        size = 0;
    }

    //Question 1
    public int removeAll(T find) {

        if (list != null) {
            int count = 0;
            int removed = 0;
            for (int i = 0; i <= size + 1; i++) {
                if (list[i] != null) {
                    if (((Comparable<T>) list[i]).compareTo(find) != 0) {
                        list[count] = list[i];
                        count++;
                    } else {
                        removed++;
                    }
                }
            }
            size -= Math.abs(count - size);
            return removed;
        } else {
            return 0;
        }

    }

    //Question 2
    public int removeAllbutOne(T find) {
        if (list != null) {
            int count = 0;
            int removed = 0;
            boolean first = true;
            for (int i = 0; i < size + 1; i++) {
                if (list[i] != null) {
                    if (((Comparable<T>) list[i]).compareTo(find) != 0) {
                        list[count] = list[i];
                        count++;
                    } else {
                        if (first) {
                            first = false;
                            list[count] = list[i];
                            count++;
                        } else {
                            removed++;
                        }
                    }
                }
            }
            if (count <= size) {
                size -= Math.abs(count - size);
            }
            return removed;
        } else {
            return 0;
        }
    }

    public T get(int index) {
        return list[index];
    }

    @Override
    public String toString() {
        if (comparator != null) {
            Arrays.sort(list, comparator.reversed());
        }
        String str = "[ ";
        for (int i = 0; i < size; i++) {
            str += list[i] + " ";
        }
        return str + "]";
    }

    void removeRange(int start, int end) {
        if(size == 0)return;
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (i < start || i >= end) {
                    list[count] = list[i];
                    count++;
                } else {
                    list[i] = null;
                }
            }
        }

        size = count;

    }

    void removeEveryOther() {
        if(size == 0)return;
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (i % 2 == 0) {
                    list[count] = list[i];
                    count++;
                } else {
                    list[i] = null;
                }
            }
        }
        size = count;
    }

}
