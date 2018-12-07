package week11_PriorityQueue_Heap;

import java.util.Arrays;

/**
 *
 * @author Jeremy Santorelli
 */
public class Assignment {

    public static void main(String[] args) {

        //QUESTION 2
        System.out.println("Question 2");
        Assignment a = new Assignment();
        Heap<Integer> h = new Heap<>(new Integer[]{5, 2, 6, 8, 4, 3});
        h.makeItHeap();
        System.out.println(h.toString());
        a.inOrder(h);
        System.out.println(h.toString());

        //QUESTION 3
        System.out.println("\nQuestion 3");
        h = new Heap<>(new Integer[]{5, 2, 6, 8, 4, 3});
        h.makeItHeap();
        System.out.println(h.toString());
        a.insertionSort(h, false);
        System.out.println(h.toString());

        //QUESTION 4b
        System.out.println("\nQuestion 4b");
        h = new Heap<>(new Integer[]{5, 2, 6, 8, 4, 3});
        h.makeItHeap();
        System.out.println(h.toString());
        a.insertionSort(h, true);
        System.out.println(h.toString());

        //QUESTION 4c
        System.out.println("\nQuestion 4c");
        h = new Heap<>(new Integer[]{37, 23, 0, 17, 12, 72, 31,
            46, 100, 88, 54});
        h.makeItHeap();
        System.out.println("\nORIGNAL: " + h.toString() + "\n");
        long startTime = System.nanoTime();
        {
            a.insertionSort(h, false);
        }
        System.out.println("\nPerformance by the algorithm: "
                + (System.nanoTime() - startTime) + " ns\n");
        System.out.println(h.toString() + "\n");

        h = new Heap<>(new Integer[]{37, 23, 0, 17, 12, 72, 31,
            46, 100, 88, 54});
        h.makeItHeap();
        long startTimeBin = System.nanoTime();
        {
            a.insertionSort(h, true);
        }
        System.out.println("\nPerformance by the algorithm: "
                + (System.nanoTime() - startTimeBin) + " ns\n");
        System.out.println(h.toString() + "\n");

    }

    /**
     * QUESTION 2 Recursive In Order Sort
     *
     */
    public void inOrder(Heap<Integer> heap) {
        inOrder(heap.heap, 0, heap.heap.length - 1);
    }

    public static void inOrder(Integer[] a, int start, int end) {
        if (start < end) {
            inOrder(a, start + 1, end);
            if (a[start] <= a[end]) {
                inOrder(a, start, end - 1);
            } else if (a[start] > a[end]) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
                inOrder(a, start, end - 1);
            }
        } else if (start == end) {
            return;
        }
    }

    /**
     * QUESTION 3 InsertionSort from end of Array
     *
     */
    public void insertionSort(Heap<Integer> heap, boolean binary) {
        insertionSort(heap.heap, 0, binary);
    }

    private void insertionSort(Integer[] a, int n, boolean binary) {
        if (n == a.length - 1) {
            return;
        }
        insertionSort(a, n + 1, binary);
        insertionSortHelper(a, n, binary);

        //This loop is here strictly to show that the insertionsort is being 
        //completed from the end of the array.
        for (int i = n; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private void insertionSortHelper(Integer[] a, int n, boolean binary) {
        int last = a[n];
        int j = n + 1;
        if (binary) {//QUESTION 4b
            j = binarySearch(a, n, 1, last) + 1;
        }
        while (j < a.length && a[j] < last) {
            a[j - 1] = a[j];
            j++;
        }
        a[j - 1] = last;
    }

    /**
     * QUESTION 4b Method
     */
    public int binarySearch(Integer[] a, int begin, int end, int key) {
        if (begin < end) {
            int middle = begin + (end - begin) / 2;
            if (key < a[middle]) {
                return binarySearch(a, begin, middle, key);
            } else if (key > a[middle]) {
                return binarySearch(a, middle + 1, end, key);
            } else {
                return middle;
            }
        }
        return begin;
    }
}
