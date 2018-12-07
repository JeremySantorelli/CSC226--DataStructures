package week6.Checkout;

import week6_Queue.BoundedQueue;

/**
 *
 * @author Jeremy Santorelli
 */
public class POSWithLine implements POS{

    private BoundedQueue<Integer> waitQ;

    private int numPeopleServed = 0;
    private double serviceTime = 0;
    private double totalWaitTime = 0;

    public POSWithLine(int n) {
        waitQ = new BoundedQueue<>(n);
    }

    public void iterateOneMinute(int i, int minServiceTime,
            int maxServiceTime) {

        if (serviceTime > 0) {
            serviceTime--;
        } else {
            if (!waitQ.isEmpty()) {
                totalWaitTime = i - waitQ.dequeue();
                numPeopleServed++;
                serviceTime = (minServiceTime 
                        + (maxServiceTime - minServiceTime + 1) 
                        * Math.random());

            }
        }
    }

    public void newCustomer(int customerID) {
        waitQ.enqueue(customerID);
    }

    public int getLineSize() {
        return waitQ.size();
    }

    public int getNumPeopleServed() {
        return numPeopleServed;
    }

    public double getAverageWaitTime() {
        return totalWaitTime / numPeopleServed;
    }

    public String toString() {
        return waitQ.toString();
    }

}
