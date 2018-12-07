package week7_SortedList;

import week2.*;

/**
 *
 * @author jerem
 */
public class Pair implements Comparable {

    int firstNum, secondNum;

    public Pair(int firstNum, int secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public int getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }

    @Override
    public String toString() {
        return "(" + firstNum + ", " + secondNum + ")";
    }

    @Override
    public int compareTo(Object obj) {
        final Pair other = (Pair) obj;
        int ret;
        if (this.equals(other)) {
            ret = 0;
        } else {
            if (this.firstNum - other.firstNum == 0) {
                ret = this.secondNum - other.secondNum;
            } else {
                ret = this.firstNum - other.firstNum;
            }
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.firstNum;
        hash = 41 * hash + this.secondNum;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (this.firstNum != other.firstNum) {
            return false;
        }
        if (this.secondNum != other.secondNum) {
            return false;
        }
        return true;
    }

}
