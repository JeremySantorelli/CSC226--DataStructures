/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam2.question4;

/**
 *
 * @author jerem
 */
public class Test {

    public static void main(String[] args) {
        Exam2_SortedDoubllyLinkedList<Integer> sl = new Exam2_SortedDoubllyLinkedList<>();

        sl.add(8);
        sl.add(2);
        sl.add(3);
        sl.add(8);
        sl.add(5);
        sl.add(6);
        sl.add(7);
        sl.add(8);
        System.out.println(sl.iterateForward());
        System.out.println(sl.iterateBackward());
        sl.removeEveryOtherItem();
        System.out.println(sl.iterateForward());
        System.out.println(sl.iterateBackward());

    }

}
