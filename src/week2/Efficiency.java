/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week2;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author jerem
 */
public class Efficiency {

    public static int findMin(int[] arr) {
        int minSoFar = arr[0];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count++;
            if (arr[i] < minSoFar) {

                minSoFar = arr[i];

            }
        }
        System.out.println("Count = " + count);
        return minSoFar;

    }

    public static int findMin1(int[] arr) {
        int min = 0;
        int count = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            count++;
            if (i == 0) {
                min = arr[i];
            }
            for (int j = i + 1; j < length; j++) {
                count++;
                if (arr[j] < min) {
                    min = arr[j];
                    i = j + 1;
                    break;
                } else if (j == length - 1) {
                    i = j + 1;
                    break;
                }
            }

        }
        System.out.println("Count = " + count);
        return min;

    }

    public static int findMin2(int[] arr) {
        Arrays.sort(arr);
        return arr[0];

    }

    public static void main(String[] args) {

        Random rd = new Random();

        int[] a = new int[1000000];
        for (int i = 0; i < a.length; i++) {

            a[i] = rd.nextInt();
        }

        long star = System.currentTimeMillis();
        System.out.println("First Method " + Efficiency.findMin(a));
        long end = System.currentTimeMillis();

        long star1 = System.currentTimeMillis();
        System.out.println("Second Method " + Efficiency.findMin1(a));
        long end1 = System.currentTimeMillis();

        long star2 = System.currentTimeMillis();
        System.out.println("First Method " + Efficiency.findMin2(a));
        long end2 = System.currentTimeMillis();

        long time = end - star;
        long time1 = end1 - star1;
        long time2 = end2 - star2;

        System.out.println(time + " ms");
        System.out.println(time1 + " ms");
        System.out.println(time2 + " ms");

    }

}
