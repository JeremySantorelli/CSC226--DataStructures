package exam2;

/**
 *
 * @author Jeremy Santorelli
 */
public class Exam2_Recursion<T> {

    //QUESTION 1(a)
    public static boolean contains(int[] a, int size, int item) {
        if (size == 0) {
            return a[0] == item;
        } else {
            if (a[size - 1] == item) {
                return true;
            }
            return contains(a, size - 1, item);
        }
    }

    //QUESTION 1(b)
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
    //QUESTION 1(c)
    public static String reverseString(String s) {
        if (s.length() == 0) {
            return s;
        } else {

            return reverseString(s.substring(1)) + s.charAt(0);
        }
    }

    public static void main(String[] args) {

        //QUESTION 1(a) TEST
        int[] a = {1, 2, 3, 4};
        System.out.println(contains(a, a.length, 5));

        //QUESTION 1(b) TEST
        LinkedLizt<Integer> list = new LinkedLizt<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.toString());

        //
        String sample = "abcdefg";
        System.out.println(reverseString(sample));
        
        

    }

}
