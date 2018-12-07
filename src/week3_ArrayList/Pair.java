package week3_ArrayList;

import assignment2.*;
import java.util.Objects;

/**
 *
 * @author jerem
 */
public class Pair {

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
        return "( " + firstNum + ", " + secondNum + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pair other = (Pair) obj;
        if (!Objects.equals(this.firstNum, other.firstNum) || 
                !Objects.equals(this.secondNum, other.secondNum)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + this.firstNum;
        hash = 19 * hash + this.secondNum;
        return hash;
    }

}
