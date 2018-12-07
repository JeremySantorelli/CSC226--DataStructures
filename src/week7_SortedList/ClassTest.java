package week7_SortedList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy Santorelli
 */
public class ClassTest {

    public static void main(String[] args) {
//        try {
//            try {
//                SortedArrayList<String> str = new SortedArrayList<>(10);
//
//                str.add("Hello");
//                str.add("Cello");
//                str.add("Mellow");
//
//                System.out.println(str.toString());
//
//                str.remove("Hello");
//                System.out.println(str.toString());
//            } catch (Exception ex) {
//                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            SortedArrayList<Pair> p = new SortedArrayList<>(5);
//
//            p.add(new Pair(1, 2));
//            p.add(new Pair(1, 1));
//            p.add(new Pair(3, 3));
//            p.add(new Pair(2, 2));
//            p.add(new Pair(2, 1));
//
//            System.out.println(p);
//            p.remove(new Pair(2, 1));
//            System.out.println(p);
//        } catch (Exception ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//        }

//        LinkedSortedList<Integer> i = new LinkedSortedList<>();
//        
//        i.add(9);
//        i.add(7);
//        i.add(3);
//        i.add(10);
//        i.add(4);
//        
//        i.remove(7);
//        
//        System.out.println(i);
        List<Pair> p1 = new ArrayList<>();

        p1.add(new Pair(1, 2));
        p1.add(new Pair(1, 1));
        p1.add(new Pair(3, 3));
        p1.add(new Pair(2, 2));
        p1.add(new Pair(2, 1));

//        Comparator<? super Pair> c2 = new Comparator<>() {
//            @Override
//            public int compare(T o1, T o2) {
//                Pair oOne = (Pair) o1;
//                Pair oTwo = (Pair) o2;
//                int ret;
//                if (oOne.equals(oTwo)) {
//                    ret = 0;
//                } else {
//                    if (oOne.firstNum - oTwo.firstNum == 0) {
//                        ret = oOne.secondNum - oTwo.secondNum;
//                    } else {
//                        ret = oOne.firstNum - oTwo.firstNum;
//                    }
//                }
//                return ret;
//
//            }
//        };

//        p1.sort(c2);

    }

}
