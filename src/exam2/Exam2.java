//package exam2;
//
//import exam2.question4.Node;
//import java.util.Stack;
//
///**
// *
// * @author Jeremy Santorelli
// */
//public class Exam2 {
//
//    //QUESTION 1(a)
//    public static boolean contains(int[] a, int size, int item) {
//        if (size == 0) {
//            return a[0] == item;
//        } else {
//            if (a[size - 1] == item) {
//                return true;
//            }
//            return contains(a, size - 1, item);
//        }
//    }
//
//    //QUESTION 1(b)
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
//    //QUESTION 1(c)
//    public static String reverseString(String s) {
//        if (s.length() == 0) {
//            return s;
//        } else {
//
//            return reverseString(s.substring(1)) + s.charAt(0);
//        }
//    }
//
//    //QUESTION 2
//    public class Queue<T> {
//
//        Stack<T> inbox, outbox;
//
//        public Queue() {
//            this.inbox = new Stack<>();
//            this.outbox = new Stack<>();
//        }
//
//        public void enqueue(T item) {
//            inbox.push(item);
//        }
//
//        public T dequeue() {
//            if (outbox.isEmpty() && !inbox.isEmpty()) {
//                Stack<T> set = inbox;
//                outbox = set;
//            }
//            return outbox.pop();
//        }
//
//        public boolean isEmpty() {
//            return this.inbox.isEmpty() && this.outbox.isEmpty();
//        }
//    }
//    
//    
//    
//    
//    
//    
//    
//
//    //QUESTION 3(a)
//    void removeRange(int start, int end) {
//        if (size == 0) {
//            return;
//        }
//        int count = 0;
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] != null) {
//                if (i < start || i >= end) {
//                    list[count] = list[i];
//                    count++;
//                } else {
//                    list[i] = null;
//                }
//            }
//        }
//
//        size = count;
//
//    }
//
//    //QUESTION 3(b)
//    void removeEveryOther() {
//        if (size == 0) {
//            return;
//        }
//        int count = 0;
//        for (int i = 0; i < list.length; i++) {
//            if (list[i] != null) {
//                if (i % 2 == 0) {
//                    list[count] = list[i];
//                    count++;
//                } else {
//                    list[i] = null;
//                }
//            }
//        }
//        size = count;
//    }
//
//    //QUESTION 4(a)
//    public T removeLast() {
//        if (size == 0) {
//            return null;
//        }
//        Node<T> cursor = tail;
//        T remove = cursor.getInfo();
//        while (cursor != null) {
//            if (((Comparable<T>) cursor.getInfo()).compareTo(remove) == 0) {
//                if (cursor.getFrontLink() == null) {
//                    cursor.getRearLink().setFrontLink(null);
//                    tail = tail.getRearLink();
//                } else {
//                    cursor.getRearLink().setFrontLink(cursor.getFrontLink());
//                    cursor.getFrontLink().setRearLink(cursor.getRearLink());
//                }
//                size--;
//            } else if (((Comparable<T>) cursor.getInfo()).compareTo(remove) < 0) {
//                break;
//            }
//            cursor = cursor.getRearLink();
//        }
//        return remove;
//    }
//
//    //QUESTION 4(b)
//    public void removeEveryOtherItem() {
//        Node<T> cursor = head.getFrontLink();
//        int count = 0;
//        while (cursor.getFrontLink() != null) {
//            if (count % 2 == 0) {
//                cursor.getRearLink().setFrontLink(cursor.getFrontLink());
//                cursor.getFrontLink().setRearLink(cursor.getRearLink());
//            }
//            count++;
//            cursor = cursor.getFrontLink();
//        }
//        size = count;
//
//    }
//
//}
