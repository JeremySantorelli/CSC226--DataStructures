package exam2;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {
        Exam2_SortedArrayList<Integer> sort = new Exam2_SortedArrayList<>(10);

        sort.add(1);
        sort.add(2);
        sort.add(3);
        sort.add(4);
        sort.add(5);
        sort.add(6);
        sort.add(7);
        sort.add(8);

       
        System.out.println(sort);
         sort.removeRange(2, 5);
        //sort.removeEveryOther();
        System.out.println(sort);
    }

}
