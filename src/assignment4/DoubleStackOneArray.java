package assignment4;

/**
 *
 * @author Jeremy Santorelli
 * @param <E>
 */
public class DoubleStackOneArray<E> {

    int size, topEven, topOdd;
    E arr[];

    // Constructor 
    DoubleStackOneArray(int n) {
        arr = (E[]) new Object[n];
        size = n;
        topEven = -1;
        topOdd = size;
    }

    void push(E x) {

        Integer push = Integer.parseInt(x.toString());

        if (push % 2 == 0) {
            if (topEven < topOdd - 1) {
                topEven++;
                arr[topEven] = x;
            } 

        } else if (push % 2 != 0) {

            if (topEven < topOdd - 1) {
                topOdd--;
                arr[topOdd] = x;
            }
        }
    }

    public boolean isEmpty() {

        return topEven == 0 && topOdd == size;
    }

    void popEven() {
        if (topEven >= 0) {
            arr[topEven] = null;
            topEven--;

        } 

    }

    void popOdd() {
        if (topOdd < size) {
            arr[topOdd] = null;
            topOdd++;

        } 

    }

    public Object topEven() {
        return arr[topEven];
    }

    public Object topOdd() {
        return arr[topOdd];
    }

    public int getEvenCount() {
        return topEven;
    }

    public int getOddCount() {
        return size - topOdd;
    }

    public E getBottomItemEven() {
        return arr[0];
    }

    public E getBottomItemOdd() {
        return arr[size - 1];
    }

    @Override
    public String toString() {

        int i = 0;
        int j = arr.length - 1;

        String oddStr = "Odds: ";
        String evenStr = "Evens: ";

        while (i < j) {
            if (j >= topOdd) {
                oddStr += arr[j] + " ";
            }
            if (i <= topEven) {
                evenStr += arr[i] + " ";
            }
            i++;
            j--;

        }

        return evenStr + "\n" + oddStr;
    }

}