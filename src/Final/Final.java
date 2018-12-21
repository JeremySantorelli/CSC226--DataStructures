package Final;

import week10_BinarySearchTree.Node;
import week11_PriorityQueue_Heap.Heap;



/**
 *
 * @author Jeremy Santorelli
 */
public class Final<T> {

    //QUESTION 5
    static void selectionSort(int arr[], int n, int i) {
        int min = getMinPos(arr, n, i);
        int temp = arr[n];
        // If largest is not root 
        if (n == i - 1) {
            return;
        } else {
            if (min != n) {
                arr[n] = arr[min];
                arr[min] = temp;
            }
        }
        selectionSort(arr, n += 1, i);
    }

    static void selectionSort(int[] a) {
        selectionSort(a, 0, a.length);
    }

    private static int getMinPos(int[] a, int iA, int iB) {
        int tempMin = a[iA],
                minIndex = iA;
        for (int i = iA; i < iB; i++) {
            if (a[i] <= tempMin) {
                tempMin = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //QUESTION 6
    Node<T> root = null;//Used as placholder
    public void removeMax() {
        Node<T> cursor = root;
        Node precursor = null;
        while (cursor != null) {
            if (cursor.getRight() != null) {
                precursor = cursor;
                cursor = cursor.getRight();
            } else {
                if (precursor == null) {
                    root = null;
                } else {
                    precursor.setRight(null);
                }
                return;
            }
        }
    }

    //QUESTION 7
    public int countGreater(int item, int count, Node<T> root) {
        if (root == null) {
            return count;
        }
        if (((Comparable<Integer>) root.getKey()).compareTo(item) > 0) {
            count += 1;
        }
        return countGreater(item, 0, root.getLeft()) + countGreater(item, count, root.getRight());
    }

    
    
    
    //QUESTION 8
//    Heap<> heap = null;//placeholder
//    public static int getSingleChildNodeIndex() {
//        for (int i = 0; i < heap.length; i++) {
//            int leftChild = (i * 2) + 1;
//            int rightChild = (i * 2) + 2;
//            if (leftChild > heap.length - 1) {
//                return rightChild;
//            }
//            if (rightChild > heap.length - 1) {
//                return leftChild;
//            }
//        }
//        return -1;
//    }
//}
//
//public class HashtagService<K, V> extends HashTable {
//
//    public HashtagService(int capacity) {
//        super.capacity = capacity;
//        super.buckets = (week12_hashing.Node<K, V>[]) new week12_hashing.Node[capacity];
//    }
//
//    public HashtagService() {
//        this(31);
//    }
//
//    public List<K> getAllHashtags(HashtagService<String, String> s) {
//        List<K> tags = new ArrayList<>();
//        for (int i = 0; i < s.capacity; i++) {
//            if (s.getBuckets()[i] != null) {
//
//                week12_hashing.Node<K, V> cursor = s.getBuckets()[i];
//                while (cursor != null) {
//                    tags.add(cursor.getKey());
//                    cursor = cursor.getLink();
//                }
//            }
//
//        }
//        return tags;
//    }

//    public List<V> getAllMessages(HashtagService<String, String> s) {
//        List<V> tags = new ArrayList<>();
//        for (int i = 0; i < s.capacity; i++) {
//            if (s.getBuckets()[i] != null) {
//
//                week12_hashing.Node<K, V> cursor = s.getBuckets()[i];
//                while (cursor != null) {
//                    tags.add(cursor.getVal());
//                    cursor = cursor.getLink();
//                }
//            }
//
//        }
//        return tags;
//
//    }

}
