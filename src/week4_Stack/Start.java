package week4_Stack;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeremy Santorelli
 */
public class Start {

    public static void main(String[] args) {

        try {
            Stack<Integer> st = new ArrayStack<>();

            for (int i = 0; i < 40; i++) {
                st.push(i);
            }

            runOutput(st);

            st = new LinkedStack();
            for (int i = 39; i > -1; i--) {
                st.push(i);
            }

            runOutput(st);

        } catch (Exception ex) {
            Logger.getLogger(Start.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void runOutput(Stack<Integer> st) {

        System.out.println(st.top());

        System.out.println(st.toString());

        while (!st.isEmpty()) {
            st.pop();
        }

        System.out.println("After Pop: " + st.toString());
    }

}
