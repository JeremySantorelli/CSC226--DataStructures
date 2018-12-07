package assignment2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Utility class used to find and manipulate Integer Arrays
 *
 * @author Jeremy Santorelli
 *
 */
public class IntegerArrayUtility {

    /**
     * (TASK 1) Returns a Pair object which contains the first and second lowest
     * number of an array
     *
     * Big-O value: O(N)
     *
     *
     * @param a the incoming integer array to evaluate
     * @return Pair Object
     */
    public static Pair findTwoSmallest(int[] a) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;

        for (int j = 0; j < a.length; j++) {

            if (a[j] < first) {
                second = first;
                first = a[j];
            } else if (a[j] < second) {

                second = a[j];
            }

        }
        return new Pair(first, second);

    }

    /**
     * (TASK 2) Finds all matching integers between two arrays
     *
     * Big-O: O(N^2)
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer>
            getListOfMatchingInts(int[] a, int[] b) {

        List<Integer> matchList = new ArrayList<>();
        int largeLength, smallLength;
        int[] large, small;

        if (a.length > b.length) {
            largeLength = a.length;
            smallLength = b.length;
            large = a;
            small = b;
        } else {
            largeLength = b.length;
            smallLength = a.length;
            small = a;
            large = b;
        }

        for (int num = 0; num < largeLength; num++) {

            int temp = large[num];

            for (int checkNum = 0; checkNum < smallLength; checkNum++) {

                if (!matchList.contains(small[checkNum])) {
                    if (small[checkNum] == temp) {
                        matchList.add(small[checkNum]);
                    }
                }

            }

        }
        return matchList;
    }

    /**
     * (Extra Credit) A different way to get matches between two arrays (See
     * Task 2)
     *
     * Pro: Extremly easy Con: Likely more expensive in terms of resources.
     *
     * Big-O: ?
     *
     * @param a
     * @param b
     * @return
     */
    public static List<Integer>
            getListOfMatchingIntsEC(int[] a, int[] b) {

        List<Integer> aList
                = Arrays.stream(a).boxed()
                        .collect(Collectors.toList());
        List<Integer> bList
                = Arrays.stream(b).boxed()
                        .collect(Collectors.toList());

        aList.retainAll(bList);

        return aList;
    }

    /**
     * (TASK 3) Check if two arrays are identical
     *
     * Big-O: O(N)
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean checkIdentical(int[] a, int[] b) {

        boolean match = true;

        if (a.length != b.length) {
            match = false;
        } else {

            for (int num = 0; num < a.length; num++) {

                if (a[num] != b[num]) {
                    match = false;
                    break;
                }

            }

        }

        return match;
    }

    /**
     * (TASK 4) find first pair that adds up to given "sum"
     *
     * @param a
     * @param sum
     * @return
     */
    public static Pair findFirstAddendPair(int[] a, int sum) {

        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            if (a[i] + a[j] == sum) {
                int[] ordered = orderPair(a[i], a[j]);

                return new Pair(ordered[0], ordered[1]);

            } else {
                i++;
            }
            if (i == j - 1) {
                i = 0;
                j--;
            }

        }
        return null;

    }

    /**
     * (EXTRA CREDIT) Finds all addends of a given input "sum" (TASK 4)
     *
     * Big-O: O(N^2)
     *
     *
     * @param a
     * @param sum
     * @return
     */
    public static List<Pair> findAllAddendPairsEC(int[] a, int sum) {

        List<Pair> addends = new ArrayList<>();
        Pair p;

        for (int leftAddend = 0;
                leftAddend < a.length; leftAddend++) {

            for (int rightAddend = 0;
                    rightAddend < a.length; rightAddend++) {

                if (a[leftAddend] + a[rightAddend] == sum) {

                    int[] ordered
                            = orderPair(a[leftAddend], a[rightAddend]);

                    p = new Pair(ordered[0], ordered[1]);

                    if (!addends.contains(p)) {

                        addends.add(p);
                    }
                }
            }

        }
        return addends;
    }

    
    
    /**
     * (Extra Credit) Tried to find a more efficient way to solve this problem.
     * Used one while loop (TASK 4)
     *
     * Pro: Uses one less loop Con: Less Obvious than the original solution
     *
     * Big-O: O(N)
     *
     * @param a
     * @param sum
     * @return
     */
    public static List<Pair>
            findAllAddendPairsAnotherEC(int[] a, int sum) {

        List<Pair> addends = new ArrayList<>();

        int i = 0;
        int j = a.length - 1;
        Pair p;

        while (i < j) {
            if (a[i] + a[j] == sum) {

                int[] ordered = orderPair(a[i], a[j]);

                p = new Pair(ordered[0], ordered[1]);
                if (!addends.contains(p)) {

                    addends.add(p);
                }
                i++;
            } else {
                i++;
            }
            if (i == j - 1) {
                i = 0;
                j--;
            }

        }
        return addends;

    }

    /**
     * (TASK 5) Takes an int[] and moves all values to the left of "k" to the
     * back of the array
     *
     * Big-O: (log(N)/log(2))
     *
     * @param a
     * @param k
     * @return
     */
    public static int[] placeArrayPartAtEndFrom(int[] a, int k) {

        int[] part1 = Arrays.copyOf(a, k);

        int[] part2 = Arrays.copyOfRange(a, k, a.length);

        int[] newArray = new int[a.length];

        System.arraycopy(part2, 0, newArray, 0, part2.length);

        System.arraycopy(part1, 0, newArray,
                part2.length, part1.length);

        return newArray;

    }

    /**
     * (TASK 6) find the first number that has the smallest amount of change
     * between it and the next number in the array
     *
     * @param a
     * @return
     */
    public static int getFirstNumberOfSmallestChange(int[] a) {

        int change = Integer.MAX_VALUE;
        int num = 0;

        for (int i = 1; i < a.length; i++) {
            int currentChange = Math.abs(a[i] - a[i - 1]);
            if (currentChange < change) {
                change = currentChange;
                num = a[i - 1];
            }
        }

        return num;
    }

    /**
     * A private function used to encapsulate a common procedure. This function
     * takes two integers, and puts them in ascending order.
     *
     * @param a
     * @param b
     * @return
     */
    private static int[] orderPair(int a, int b) {
        int[] ret = new int[2];

        if (a > b) {
            ret[0] = b;
            ret[1] = a;
        } else {
            ret[1] = b;
            ret[0] = a;
        }
        return ret;
    }

}
