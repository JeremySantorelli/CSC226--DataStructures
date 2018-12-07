package assignment4;

import java.util.Random;

/**
 *
 * @author Jeremy Santorelli
 */
public class Test {

    public static void main(String[] args) {
        DoubleIntegerStack dStack = new DoubleIntegerStack();
        Random r = new Random();
        for (int i = 0; i < 150; i++) {
            dStack.push(r.nextInt(1000));
        }

        System.out.println(dStack.toString());

        System.out.println("ODD COUNT: " + dStack.getEvensCount());
        System.out.println("EVEN COUNT: " + dStack.getOddsCount());

        System.out.println("EVEN TOP: " + dStack.topEven());
        System.out.println("ODD TOP: " + dStack.topOdd());

        for (int j = 0; j < 15; j++) {

            dStack.popEven();
            dStack.popOdd();
        }

        System.out.println(dStack.toString());

        System.out.println("ODD COUNT: " + dStack.getEvensCount());
        System.out.println("EVEN COUNT: " + dStack.getOddsCount());

        System.out.println("EVEN TOP: " + dStack.topEven());
        System.out.println("ODD TOP: " + dStack.topOdd());

        DoubleStackOneArray ts = new DoubleStackOneArray(200);
        for (int i = 0; i < 150; i++) {
            ts.push(r.nextInt(1000));
        }

        System.out.println(ts.toString());

        System.out.println("ODD COUNT: " + ts.getEvenCount());
        System.out.println("EVEN COUNT: " + ts.getOddCount());

        System.out.println("EVEN TOP: " + ts.topEven());
        System.out.println("ODD TOP: " + ts.topOdd());

        for (int j = 0; j < 15; j++) {

            dStack.popEven();
            dStack.popOdd();
        }

        System.out.println(dStack.toString());

        System.out.println("ODD COUNT: " + dStack.getEvensCount());
        System.out.println("EVEN COUNT: " + dStack.getOddsCount());

        System.out.println("EVEN TOP: " + dStack.topEven());
        System.out.println("ODD TOP: " + dStack.topOdd());

    }

}