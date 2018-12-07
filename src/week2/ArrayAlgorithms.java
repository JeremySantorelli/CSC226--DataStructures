/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author jerem
 */
public class ArrayAlgorithms {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 10, 23, 9, 49, 11, 100};

        int[] b = reverseArray1(a);

        System.out.println("A: " + Arrays.toString(a));
        System.out.println("B: " + Arrays.toString(b));

        Pair p = secondMax(a);

        System.out.println("secondMax = " + p.toString());

    }

    public static Pair secondMax(int[] a) {
        int first = 0, second = 0;

        for (int j = 0; j < a.length; j++) {

            if (a[j] > first) {
                second = first;
                first = a[j];
            } else if (a[j] > second) {

                second = a[j];
            }

        }
        return new Pair(first, second);

    }

    public static int[] reverseArray(int[] a) {

        int[] temp = new int[a.length];

        for (int i = a.length - 1; i >= 0; i--) {

            temp[a.length - i - 1] = a[i];

        }

        return temp;
    }

    public static int[] reverseArray1(int[] a) {
        for (int j = 0; j < a.length / 2; j++) {
            int temp = a[j];
            int tempEnd = a[a.length - j - 1];
            a[j] = tempEnd;
            a[a.length - j - 1] = temp;
        }
        return a;
    }
}
