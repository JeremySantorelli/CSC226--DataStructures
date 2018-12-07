package week6.Checkout;

/**
 *
 * @author Jeremy Santorelli
 */
public class POSSharedLine implements POS{

    private int currentCustomer = -1;
    private int numPeopleServed = 0;
    private double serviceTime = 0;
    private double totalWaitTime = 0;

    @Override
    public void iterateOneMinute(int i, int minServiceTime,
            int maxServiceTime) {
        if (serviceTime > 0) {
            serviceTime--;
        } else {
            if (currentCustomer > -1) {
                totalWaitTime = i - currentCustomer;
                numPeopleServed++;
                serviceTime = (minServiceTime 
                        + (maxServiceTime - minServiceTime + 1) 
                        * Math.random());
                currentCustomer = -1;

            }
        }
    }

    public int getCurrentCustomer() {
        return currentCustomer;
    }

    @Override
    public double getAverageWaitTime() {
        return totalWaitTime / numPeopleServed;
    }

    @Override
    public int getNumPeopleServed() {
        return numPeopleServed;
    }

    @Override
    public void newCustomer(int customerID) {
        this.currentCustomer = customerID;
    }

    @Override
    public String toString() {
        return "currentCustomer=" + currentCustomer;
    }
    
    

}
