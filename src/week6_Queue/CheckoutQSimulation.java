package week6_Queue;

import week6_Queue.BoundedQueue;

/**
 *
 * @author jerem
 */
public class CheckoutQSimulation {

    public static void main(String[] args) {

        System.out.println(simulateCheckoutLine(1500, 0.1, 2, 6));

    }

    static int simulateCheckoutLine(int simuTime, double arrivalProb, int minServiceTime, int maxServiceTime) {
        BoundedQueue<Integer> waitQ = new BoundedQueue<>(1000);
        int numPeopleServed = 0;
        int serviceTime = 0;
        int totalTWaitTime = 0;
        for (int i = 0; i < simuTime; i++) {

            if (Math.random() < arrivalProb) {
                waitQ.enqueue(i);
            }

            if (serviceTime > 0) {
                serviceTime--;
            } else {
                if (!waitQ.isEmpty()) {
                    totalTWaitTime = i - waitQ.dequeue();
                    numPeopleServed++;
                    serviceTime = (int) ((int) minServiceTime + (maxServiceTime - minServiceTime + 1) * Math.random());

                }
            }

        }
        System.out.println(numPeopleServed);
        return totalTWaitTime;

    }
}
