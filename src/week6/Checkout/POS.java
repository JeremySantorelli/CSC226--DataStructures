package week6.Checkout;

/**
 *
 * @author jerem
 */
public interface POS {

    public void newCustomer(int customerID);

    public int getNumPeopleServed();

    public double getAverageWaitTime();

    public void iterateOneMinute(int i, int minServiceTime, int maxServiceTime);

}
