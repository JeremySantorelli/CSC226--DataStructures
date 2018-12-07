package exam1;

import java.util.Arrays;
import week3_ArrayList.LinkedLizt;
import week3_ArrayList.Lizt;
import week4_Stack.LinkedStack;
import week4_Stack.Stack;

/**
 *
 * @author jerem
 */
public class Question1 {

    public static void main(String[] args) {

        Stack<Integer> myNumStack = new LinkedStack<>();

        Integer[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] test2 = {1};
        Integer[] test3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, null};
        Integer[] test4 = {};
        Integer[] test5 = null;

        for (int i = 0; i < test1.length; i++) {
            myNumStack.push(test1[i]);
        }
        //Question 1
        System.out.println(getBottom(myNumStack));

        System.out.println(myNumStack.toString());
        //Question 2A
        myNumStack.addSecond(45);

        System.out.println(myNumStack.toString());
        //Question 2B
        myNumStack.removeLast();

        System.out.println(myNumStack.toString());

        //Question 3
        int[] t3 = {1, 0, 3, 0, 4, 0, 0, 6};

        moveZerosToBack(t3);

        System.out.println(Arrays.toString(t3));

    }

    //Question 1
    public static Integer getBottom(Stack<Integer> s) {

        Stack<Integer> temp = new LinkedStack<>();

        Integer last = 0;

        while (!s.isEmpty()) {
            temp.push(s.top());
            last = s.top();
            s.pop();
        }

        while (!temp.isEmpty()) {
            s.push(temp.top());
            temp.pop();

        }

        return last;

    }

    
    //Question 3
    public static void moveZerosToBack(int[] a) {

        int backCount = a.length - 1;
        for (int j = 0; j < (a.length / 2); j++) {
            if (a[j] == 0) {
                while (a[backCount] == 0) {
                    System.out.println(backCount);
                    backCount--;
                }
                int temp = a[j];
                int tempEnd = a[backCount];
                a[j] = tempEnd;
                a[backCount] = temp;
                backCount--;
            }
        }

    }

}
