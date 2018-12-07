package week11_PriorityQueue_Heap;

/**
 *
 * @author Jeremy Santorelli
 */
public class HeapNHeapSort {

    public static void main(String[] args) {
        Heap<Integer> heap1 = new Heap<>(new Integer[]{5, 2, 6, 8, 4, 9});
        heap1.makeItHeap();
        System.out.println(heap1);
        heap1.print();

        Integer[] sorted = (Integer[]) heap1.heapSort(new Integer[]{5, 2, 6, 8, 4, 9});
        for (Integer sorted1 : sorted) {
            System.out.print(sorted1 + " ");
        }

        System.out.println("\n" + heap1.dequeue());
        heap1.enqueue(7);
        heap1.print();

        System.out.println(heap1.contains(13));
    }
}

