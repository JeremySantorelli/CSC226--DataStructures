package week11_PriorityQueue_Heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import week7_SortedList.Pair;

/**
 *
 * @author Jeremy Santorelli
 */
public class Sorting {

    public static void main(String[] args) {
        //Sorting in ints
        Integer[] arr = {13, 3, 4, 6, 8, 6, 21, 102, 45, 200};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //%d = int val %s = string val %f = float,double, etc.
        System.out.printf("Array: %s \nLength: %d\nDecimal: %.3f\n",
                Arrays.toString(arr), arr.length, Math.PI);

        //Sorting Objects
        Pair[] p = {new Pair(6, 6), new Pair(4, 9), new Pair(8, 7)};
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
        Collections.sort(Arrays.asList(p), Collections.reverseOrder());
        System.out.printf("Pairs: %s\nLength: %d\n", Arrays.toString(p), p.length);

        //Sorting without a Comparable Object
        Comparator<Pair> comp = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.getFirstNum() - o2.getFirstNum();
            }
        };

        Arrays.sort(p, comp);
        System.out.println(Arrays.toString(p));

        int[] arrS = {13, 3, 4, 6, 8, 6, 21, 102, 4, 2};

        selectionSort(arrS);

        System.out.println(Arrays.toString(arrS));

    }

    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged 
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays 
        int i = 0, j = 0;

        // Initial index of merged subarry array 
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void jaySort() {

    }

    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array) 
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap 
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end 
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap 
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is 
    // an index in arr[]. n is size of heap 
    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root 
        int l = 2 * i + 1; // left = 2*i + 1 
        int r = 2 * i + 2; // right = 2*i + 2 

        // If left child is larger than root 
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far 
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree 
            heapify(arr, n, largest);
        }
    }

    // Main function that sorts arr[l..r] using 
    // merge() 
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point 
            int m = (l + r) / 2;

            // Sort first and second halves 
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves 
            merge(arr, l, m, r);
        }
    }

    static void insertionSortRecursive(int arr[], int n) {
        // Base case 
        if (n <= 1) {
            return;
        }

        // Sort first n-1 elements 
        insertionSortRecursive(arr, n - 1);

        // Insert last element at its correct position 
        // in sorted array. 
        int last = arr[n - 1];
        int j = n - 2;

        /* Move elements of arr[0..i-1], that are 
          greater than key, to one position ahead 
          of their current position */
        while (j >= 0 && arr[j] > last) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = last;
    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    static void recursiveBubbleSort(int arr[], int n) {
        // Base case 
        if (n == 1) {
            return;
        }

        // One pass of bubble sort. After 
        // this pass, the largest element 
        // is moved (or bubbled) to end. 
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // swap arr[i], arr[i+1] 
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // Largest element is fixed, 
        // recur for remaining array 
        recursiveBubbleSort(arr, n - 1);
    }

    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i] 
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //O(N^2)
    public static void selectionSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int minIndex = getMinPos(a, i, a.length - 1);
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }

    }

    private static int getMinPos(int[] a, int iA, int iB) {
        int tempMin = a[iA], minIndex = iA;
        for (int i = iA; i <= iB; i++) {
            if (a[i] < tempMin) {
                tempMin = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

}
