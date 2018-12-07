package week3_ArrayList;

import java.util.*;

/**
 *
 * @author jerem
 */
public class Test {

    public static void main(String[] args) {
//        Lizt<String> l = new ArrayLizt<>();
//        for (int i = 0; i < 100; i++) {
//            l.add("" + i);
//        }
//        l.remove("5");
//        System.out.println(l.toString());

        Node<Integer> head = new Node<>(2);
        Node<Integer> second = new Node<>(7);
        Node<Integer> third = new Node<>(4);
        Node<Integer> fourth = new Node<>(0);

        head.setLink(second);
        second.setLink(third);
        third.setLink(fourth);

        System.out.println(head.getInfo());

        System.out.println(getSum(head));

        Lizt<Pair> l = new LinkedLizt<>();

        for (int i = 0; i < 5; i++) {
            l.add(new Pair(i, i + 1));
        }

        l.remove(new Pair(1, 2));

        System.out.println(l.toString());

    }

    static int getSum(Node<Integer> head) {

        Node next = head;
        int sum = 0;

        while (next != null) {

            sum += (int) next.getInfo();
            next = next.getLink();

        }

        return sum;
    }

}
