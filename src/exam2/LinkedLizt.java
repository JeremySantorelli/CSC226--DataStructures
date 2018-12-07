//package exam2;
//
//import exam2.question4.Node;
//import week3_ArrayList.*;
//
///**
// *
// * @author jerem
// */
//public class LinkedLizt<T> implements Lizt<T> {
//
//    Node1<T> head;
//    int size;
//
//    public LinkedLizt() {
//        head = null;
//        size = 0;
//    }
//
//    private LinkedLizt(Node1<T> head) {
//        this.head = head;
//    }
//
//    @Override
//    public void add(T item) {
//
//        Node1<T> next = new Node1<>(item, head);
//        this.head = next;
//        size++;
//
//    }
//    
//
//
//    @Override
//    public void remove(Object item) {
//
//        Node1<T> next = head;
//        Node1<T> last = null;
//        if (head.getInfo().equals(item)) {
//            head = head.getLink();
//            return;
//        }
//        while (next != null) {
//
//            if (next.getInfo().equals(item)) {
//
//                last.setLink(next.getLink());
//            }
//            last = next;
//            next = next.getLink();
//
//        }
//
//    }
//
//    @Override
//    public boolean contains(Object item) {
//        Node1<T> next = head;
//
//        while (next != null) {
//            if (next.getInfo().equals(item)) {
//                return true;
//            }
//            next = next.getLink();
//
//        }
//        return false;
//    }
//
//    //(2C) The method behaves the same as in 1(a).
//    @Override
//    public Lizt<T> retrieveEveryOtherItem() {
//
//        Node1 link = head;
//        if (link == null) {
//            return null;
//        }
//        Node1 evOtList;
//        Node skip, keep;
//        evOtList = link;
//        skip = keep = link;
//        while (skip.getLink() != null) {
//            keep.setLink(skip.getLink());
//            keep = skip.getLink();
//            skip.setLink(keep.getLink());
//            if (keep.getLink() != null) {
//                skip = keep.getLink();
//                keep.setLink(null);
//            } else {
//                keep.setLink(null);
//                break;
//            }
//        }
//
//        return new LinkedLizt<>(evOtList);
//    }
//
//    // (EC) added this to Linked List
//    @Override
//    public void removeAt(int i) {
//        Node<T> next = head;
//        Node<T> last = null;
//        int count = 0;
//        if (i == 0) {
//            head = head.getLink();
//            return;
//        }
//        while (next != null) {
//            if (i == count) {
//                last.setLink(next.getLink());
//            }
//            last = next;
//            next = next.getLink();
//            count++;
//        }
//    }
//
//    //(2A) The method adds item at the end of the current list. 
//    @Override
//    public void addToTop(T item) {
//        Node<T> last = new Node<>(item, null);
//        Node<T> next = head;
//        while (next.getLink() != null) {
//            next = next.getLink();
//        }
//        next.setLink(last);
//        size++;
//    }
//
//    // (2B) The method specifically removes the first two items of the 
//    // current list (precondition: the list has at least two items).
//    @Override
//    public void removeFirstTwo() {
//        Node<T> next = head;
//        Node<T> last = head;
//        Node<T> last2 = head;
//
//        while (next.getLink() != null) {
//            last2 = last;
//            last = next;
//            next = next.getLink();
//        }
//
//        last2.setLink(null);
//
//        size++;
//
//    }
//
////    @Override
////    public String toString() {
////        Node<T> next = head;
////        String str = "";
////
////        while (next != null) {
////
////            str += next.getInfo() + "\n";
////            next = next.getLink();
////
////        }
////
////        return str;
////    }
//    
//    
//    @Override
//    public String toString() {
//        return toString(head, "");
//    }
//
//    private String toString(Node<T> cursor, String to) {
//        if (cursor != null) {
//            String info = cursor.getInfo() + " ";
//            return toString(cursor.getLink(), to += info);
//        } else {
//            return to;
//        }
//
//    }
//
//}
