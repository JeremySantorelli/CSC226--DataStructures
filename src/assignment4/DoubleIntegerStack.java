package assignment4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Building a Double Stack could be much more dynamic. I could make a "N"Stack
 * if i really wanted to.
 *
 * @author Jeremy Santorelli
 */
public class DoubleIntegerStack {

    private Stack evens;
    private Stack odds;

    public DoubleIntegerStack() {
        try {
            evens = new IntegerStack(100);
            odds = new IntegerStack(100);
        } catch (Exception ex) {
            Logger.getLogger(DoubleIntegerStack.class.getName())
                    .log(Level.SEVERE, null, ex);
        }

    }

    public void push(Object item) {
        Integer add = Integer.parseInt(item.toString());

        if (add % 2 == 0) {
            evens.push(item);
        } else if (add % 2 != 0) {
            odds.push(item);
        }

    }

    public boolean isEmpty() {
        return evens.isEmpty() && odds.isEmpty();
    }

    public Object topEven() {
        return evens.top();
    }

    public Object topOdd() {
        return odds.top();
    }

    public void popEven() {
        evens.pop();
    }

    public void popOdd() {
        odds.pop();
    }

    public int getEvensCount() {
        return evens.getCount();
    }

    public int getOddsCount() {
        return odds.getCount();
    }

    @Override
    public String toString() {
        return "evens=" + evens.toString() + "\n\n odds="
                + odds.toString() + '}';
    }

}
