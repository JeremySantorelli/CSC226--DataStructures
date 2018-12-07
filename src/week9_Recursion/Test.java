package week9_Recursion;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {

        //Question 1 TEST        
        System.out.println("QUESTION 1 COUNT MOVES\n");
        System.out.println(RecursionAssignment.countHanoiMoves(3));
        System.out.println(RecursionAssignment.countHanoiMoves(4));
        System.out.println(RecursionAssignment.countHanoiMoves(5));

        //Question 2 TEST
        System.out.println("\nQUESTION 2 MOVE TO BACK\n");
        System.out.println(RecursionAssignment.rotateR("hello", 3, ""));
        System.out.println(RecursionAssignment.rotateR("goodbye", 4, ""));
        System.out.println(RecursionAssignment.rotateR("racecar", 4, ""));

        //Question 3 TEST
        System.out.println("\nQUESTION 3 REMOVE 'X'\n");
        System.out.println(RecursionAssignment.noX("xaxb"));
        System.out.println(RecursionAssignment.noX("abc"));
        System.out.println(RecursionAssignment.noX("xxx"));

        //Question 4 TEST
        System.out.println("\nQUESSTION 4 SQUARE ROOT\n");
        System.out.println(RecursionAssignment.squareRoot(2));
        System.out.println(RecursionAssignment.squareRoot(3));
        System.out.println(RecursionAssignment.squareRoot(4));
        System.out.println(RecursionAssignment.squareRoot(8));

        //Question 5 TEST
        System.out.println("\nQUESTION 5 CHECK LOWER THAN ARRAY ELEMENTS\n");
        int[] elements = {10, 5, 10};
        System.out.println(
                RecursionAssignment.isUpperBound(
                        elements, elements.length, 9
                )
        );
        System.out.println(
                RecursionAssignment.isUpperBound(
                        elements, elements.length, 11
                )
        );

        //Question 6 TEST
        System.out.println("\nQUESTION 6 ADD A SPACE PER RECURSIVE CALL\n");
        RecursionAssignment.spacing(1, 2, "");
        System.out.println();
        RecursionAssignment.spacing(1, 5, "");
        System.out.println();
        RecursionAssignment.spacing(1, 10, "");
    }

}
