package assignment2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jerem
 */
public class Test {

    public static void main(String[] args) {

        Random rd = new Random();

        int min = 0;
        int max = 10;

        int[] efficiencyTesting = new int[10000];
        for (int i = 0; i < efficiencyTesting.length; i++) {

            efficiencyTesting[i] = rd.nextInt((max - min) + 1) + min;
        }

        int[] testArr = {5, 2, 7, 9, 6, 4, 1, 0, 11};
        int[] testArr1 = {11, 9, 5, 23, 13};

        int[] matchingArr = {5, 2, 7, 9, 6, 4, 1, 0, 11};
        int[] flipArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16};

        //Task 1 : get two smallest numbers in array
        System.out.println("Task 1 : get two smallest numbers in array\n");
        System.out.println("testArr: "
                + IntegerArrayUtility
                        .findTwoSmallest(testArr)
                        .toString());
        System.out.println("testArr1: "
                + IntegerArrayUtility
                        .findTwoSmallest(testArr1)
                        .toString());
        System.out.println("matchingArr: "
                + IntegerArrayUtility
                        .findTwoSmallest(matchingArr)
                        .toString());
        System.out.println("flipArr: "
                + IntegerArrayUtility
                        .findTwoSmallest(flipArr)
                        .toString());

        //Task 2 : return List of matching numbers from two seperate arrays
        System.out.println("\nTask 2 : return List of matching numbers"
                + " from two seperate arrays\n");
        System.out.println("Matches for testArr and testArr1 : "
                + IntegerArrayUtility
                        .getListOfMatchingInts(testArr, testArr1)
                        .toString());
        System.out.println("Matches for testArr and matchingArr : "
                + IntegerArrayUtility
                        .getListOfMatchingInts(testArr, matchingArr)
                        .toString());
        System.out.println("Matches for flipArr and testArr1 : "
                + IntegerArrayUtility
                        .getListOfMatchingInts(flipArr, testArr1)
                        .toString());

        //Task 3 : check if two arrays match return boolean value
        System.out.println("\nTask 3 : check if two arrays match return "
                + "boolean value\n");
        System.out.println(
                IntegerArrayUtility
                        .checkIdentical(testArr, testArr1));
        System.out.println(
                IntegerArrayUtility
                        .checkIdentical(testArr, matchingArr));

        //Task 4 : find all addends to a given sum
        System.out.println("\nTask 4 : find all addends to a given sum\n");
        System.out.println(
                IntegerArrayUtility
                        .findFirstAddendPair(testArr, 7));
        System.out.println(
                IntegerArrayUtility
                        .findFirstAddendPair(testArr1, 7));

        //Task 5 : from a given index place all items from that point to 
        //         the end of the array
        System.out.println("\nTask 5 : from a given index place all items "
                + "from that point to the end of the array\n");
        System.out.println(Arrays.toString(
                IntegerArrayUtility
                        .placeArrayPartAtEndFrom(flipArr, 6)));

        //Task 6 : find the first number that has the smallest change 
        //         between itself and the next number
        System.out.println("\nTask 6 : find the first number that has"
                + " the smallest change between itself and the next number\n");
        System.out.println(
                IntegerArrayUtility
                        .getFirstNumberOfSmallestChange(testArr));
        System.out.println(
                IntegerArrayUtility
                        .getFirstNumberOfSmallestChange(testArr1));
        System.out.println(
                IntegerArrayUtility
                        .getFirstNumberOfSmallestChange(matchingArr));
        System.out.println(
                IntegerArrayUtility
                        .getFirstNumberOfSmallestChange(flipArr));

        //Extra Credit : find matches in a different way (Task 2)
        System.out.println("\nExtra Credit : find matches in a"
                + " different way (Task 2)\n");
        System.out.println("Matches for testArr and testArr1 : "
                + IntegerArrayUtility
                        .getListOfMatchingIntsEC(testArr, testArr1)
                        .toString());
        System.out.println("Matches for testArr and matchingArr : "
                + IntegerArrayUtility
                        .getListOfMatchingIntsEC(testArr, matchingArr)
                        .toString());
        System.out.println("Matches for flipArr and testArr1 : "
                + IntegerArrayUtility
                        .getListOfMatchingIntsEC(flipArr, testArr1)
                        .toString());

        //Extra Credit : find addends in different way (Task 4)
        System.out.println("\nExtra Credit : find addends in different"
                + " way (Task 4)\n");
        long start = System.currentTimeMillis();
        System.out.println(
                IntegerArrayUtility
                        .findAllAddendPairsEC(efficiencyTesting, 7));
        long middle = System.currentTimeMillis();
        System.out.println(
                IntegerArrayUtility
                        .findAllAddendPairsAnotherEC(
                                efficiencyTesting, 7));
        long end = System.currentTimeMillis();

        long time = middle - start;
        long time1 = end - middle;
        System.out.println("\nTask 4 Run Testing\nMethod 1: " +
                time + "ms\nMethod 2: " + time1 + "ms");

    }

}
