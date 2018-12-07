package week9_Recursion;

/**
 *
 * @author Jeremy Santorelli
 */
public class RecursionAssignment {

    //Question 1
    static int countHanoiMoves(int n) {
        if (n == 0) {
            return 0;
        }
        return 2 * countHanoiMoves(n - 1) + 1;
    }

    //Question 2
    static String rotateR(String s, int r, String back) {
        if (s.length() < r) {
            return s + back;
        } else {
            return rotateR(s.substring(1), r, back += s.charAt(0));
        }
    }

    //Question 3
    public static String noX(String s) {
        if (s.length() == 0) {
            return s;
        }
        String p = s.startsWith("x") ? "" : s.substring(0, 1);
        return p + noX(s.substring(1));
    }

    //Question 4    
    public static Double squareRoot(int n) {
        if (n < 0) {
            return null;
        } else if (n > -1 && n < 2) {
            return Double.parseDouble("" + n);
        } else {
            return squareRoot(n, 0, n, 0.00000000000001);
        }
    }

    public static double squareRoot(int n, double lLimit,
            double mLimit, double e) {
        double sqrt = (lLimit + mLimit) / 2;
        double difference = sqrt * sqrt - n;
        if (difference > e) {
            return squareRoot(n, lLimit, sqrt, e);
        }
        if (-difference > e) {
            return squareRoot(n, sqrt, mLimit, e);
        }
        return sqrt;
    }

    //Question 5
    public static boolean isUpperBound(int[] a, int size, int item) {
        if (size == 0) {
            return a[0] <= item;
        } else {
            if (a[size - 1] > item) {
                return false;
            }
            return isUpperBound(a, size - 1, item);
        }
    }

    //Question 6
    public static void spacing(int n, int max, String temp) {
        if (n > max) {
            return;
        }
        if (n <= max) {
            System.out.println(temp + "Call number " + n);
        }
        String t = temp;
        spacing(n + 1, max, temp += " ");
        System.out.println(t + "ALSO number " + n);
    }
}
