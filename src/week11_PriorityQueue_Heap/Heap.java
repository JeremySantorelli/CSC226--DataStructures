package week11_PriorityQueue_Heap;

/**
 *
 * @author Dr. Chenglie Hu
 */
public class Heap<T extends Comparable<T>> {

    T[] heap;
    int lastIndex, arrayCap;
    //ArrayList<T> items;

    @SuppressWarnings("unchecked")
    public Heap(int cap) {
        heap = (T[]) new Object[cap];
        arrayCap = cap;
        lastIndex = -1;
        //items = new ArrayList<T>();
    }

    public Heap(T[] array) {
        heap = array;
        arrayCap = array.length;
        lastIndex = -1;
        for (T array1 : array) {
            if (array1 != null) {
                lastIndex++;
            }
        }
        //items = new ArrayList<T>();
    }

    public void makeItHeap() {
        for (int i = (lastIndex + 1) / 2 - 1; i >= 0; i--) {
            reheapDown(heap[i], i);  //reheap  down from i to lastIndex to place heap[i]
        }
    }

    public Object[] heapSort(T[] array) {
        Heap<T> temp = new Heap<>(array);
        temp.makeItHeap();

        for (int i = temp.lastIndex; i >= 1; i--) {
            T t = temp.heap[0];
            temp.heap[0] = temp.heap[i];
            temp.heap[i] = t;
            temp.lastIndex = i - 1;
            temp.reheapDown(temp.heap[0], 0);   //reheap down from 0 to lastIndex to place heap[0]
        }
        return temp.heap;
    }

    public boolean contains(T item) {
        return recContains(item, 0);
    }

    private boolean recContains(T item, int cursor) {
        if (cursor > lastIndex || cursor < 0) {
            return false;
        }
        if (heap[cursor].equals(item)) {
            return true;
        } else {
            return recContains(item, cursor * 2 + 1)
                    || recContains(item, cursor * 2 + 2);
        }
    }

    private void reheapUp(T item) {
        int hole = lastIndex;

        // hole is not the root and take advantage of short circuit the logic statement
        while ((hole > 0) && (item.compareTo(heap[(hole - 1) / 2]) > 0)) {
            heap[hole] = heap[(hole - 1) / 2]; // move hole's parent down
            hole = (hole - 1) / 2;          // move hole up
        }
        heap[hole] = item;                        // place item into final hole
    }

    private void reheapDown(T item, int hole) {
        int newhole;      		 // index where hole should move to

        newhole = newHole(hole, item);   	// find next hole
        while (newhole != hole) {
            heap[hole] = heap[newhole];  	// move item up
            hole = newhole;                 // move hole down
            newhole = newHole(hole, item);  // find next hole
        }
        heap[hole] = item;          		// fill in the final hole
    }

    private int newHole(int hole, T item) {
        int left = (hole * 2) + 1;
        int right = (hole * 2) + 2;

        if (left > lastIndex) {
            return hole; 			// hole has no children      
        }
        if (left == lastIndex) {					// hole has left child only

            if (heap[left].compareTo(item) > 0) {
                return left;
            } else {
                return hole;		 	// item >= left child        
            }
        }
        if (heap[left].compareTo(heap[right]) < 0) { // two children 							
            if (heap[right].compareTo(item) <= 0) {
                return hole;
            } else {
                return right; 	// item < right child
            }
        }
        if (heap[left].compareTo(item) <= 0) {
            return hole; // left child >= right child & left child <= item      	
        } else {
            return left;   			// item < left child     
        }
    }

    public boolean isEmpty() {
        return lastIndex == -1;
    }

    @Override
    public String toString() {
        String toReturn = "";
        for (int i = 0; i <= lastIndex; i++) {
            toReturn += heap[i] + " ";
        }
        return toReturn;
    }

    private void recPrint(int cursor, int depth) {
        if (cursor <= lastIndex) {
            recPrint(2 * cursor + 2, depth + 1);
            for (int i = 1; i <= 4 * depth; i++) {
                System.out.print(" ");
            }
            System.out.println(heap[cursor]);
            recPrint(2 * cursor + 1, depth + 1);
        }
    }

    public void print() {
        recPrint(0, 0);
    }

    //Support for priority queue
    public boolean isFull() {
        return lastIndex == heap.length - 1;
    }

    public void enqueue(T item) {
        if (isFull()) {
            return;
        }
        lastIndex++;
        reheapUp(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T toReturn = heap[0];
        T toMove = heap[lastIndex];
        lastIndex--;
        reheapDown(toMove, 0);
        return toReturn;
    }
}
