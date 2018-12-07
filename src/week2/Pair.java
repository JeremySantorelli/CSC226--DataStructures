
package week2;

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
        return "Pair{" + "firstNum=" + firstNum + ", secondNum=" + secondNum + '}';
    }
    
    
    
}
