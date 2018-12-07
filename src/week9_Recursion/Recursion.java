/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week9_Recursion;

import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jerem
 */
public class Recursion {

    public static void main(String[] args) {
        System.out.println(sum(5));

        try {
            Stack<Integer> s = new Stack<>();
            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);
            s.push(6);
            s.push(7);

            System.out.println(s.toString());

            reverseStack(s);
            System.out.println(s.toString());
            System.out.println(max(new int[]{1, 2, 3, 5, 9, 11, 3, 6, 23, 7}, 9));

            System.out.println(breakRepeats("aabbcc"));

        } catch (Exception ex) {
            Logger.getLogger(Recursion.class.getName()).log(Level.SEVERE, null, ex);
        }

        int n = 4; // Number of disks 
        towerOfHanoi(n, '1', '3', '2');

        print(5);

        System.out.println(
                subsetSumExists(new int[]{-2, 3, 1, 8}, 4, 4));
    }

    public static boolean subsetSumExists(int[] a, int size, int target) {

        if (size == 0) {
            if (a[0] == target) {
                System.out.println(a[0]);
                return true;
            } else {

                return false;
            }
        } else {
            if (subsetSumExists(a, size - 1, target - a[size - 1])) {
                System.out.println(a[size - 1]);
                return true;
            } else {
                if (subsetSumExists(a, size - 1, target)) {
                    System.out.println(a[size - 1]);
                    return subsetSumExists(a, size - 1, target);
                } else {
                    return subsetSumExists(a, size - 1, target);
                }

            }
        }

    }

    public static void print(int n) {
        if (n == 0) {
        } else {
            print(1, n);
        }
    }

    public static void print(int start, int n) {
        if (start == n) {
            System.out.println(n);
        } else {
            System.out.println(start);
            print(start + 1, n);
            System.out.println(start);
        }

    }

    public static void towerOfHanoi(int n, char from, char to, char other) {
        if (n == 1) {
            System.out.println("disk 1 from: " + from + " to: " + to);
            return;
        }
        towerOfHanoi(n - 1, from, other, to);
        System.out.println("disk " + n + " from: " + from + " to: " + to);
        towerOfHanoi(n - 1, other, to, from);
    }

    public static String breakRepeats(String s) {
        if (s.length() < 2 || s.isEmpty()) {
            return s;
        } else {
            if (s.charAt(0) == s.charAt(1)) {
                return s.charAt(0) + "*" + breakRepeats(s.substring(1));
            } else {
                return s.charAt(0) + breakRepeats(s.substring(1));
            }
        }

    }

    public static int max(int[] a, int index) {

        if (index > 0) {
            return Math.max(a[index], max(a, index - 1));
        } else {
            return a[0];
        }
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        } else {
            return sum(n - 1) + n;
        }
    }

    public static void insertAtBottom(Stack<Integer> s, int i) {
        if (s.isEmpty()) {
            s.push(i);
        } else {
            int temp = s.pop();
            insertAtBottom(s, i);
            s.push(temp);
        }
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        {
            int temp = s.pop();
            reverseStack(s);
            insertAtBottom(s, temp);
        }
    }
}
