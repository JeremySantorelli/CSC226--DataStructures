package week6.Checkout.StoreTypes;

import java.util.HashMap;
import java.util.Map;
import week6.Checkout.Output.Writer;
import week6.Checkout.POS;

/**
 *
 * @author Jeremy Santorelli
 */
public abstract class Line {

    protected Writer output;
    protected Map<Integer, POS> posStations = new HashMap<>();
    protected int afterMinutes = 0;
    protected static Line gsp;
    protected int openMinutes;
    protected double arrivalProb = 0;
    protected int minServiceTime = 0;
    protected int maxServiceTime = 0;
    protected int averageCustomerVolume = 0;
    protected int n = 0;
    protected int iteration = 0;
    protected int customersStillInStore = 0;

    public abstract void openDoors();

    public String posStationsToString() {
        String ret = "";
        for (Map.Entry pair : posStations.entrySet()) {
            ret += "Line " + ((int) pair.getKey() + 1)
                    + " = " + (POS) pair.getValue() + "\n";
        }
        return ret;
    }

    public String getGlobalCheckoutStatistics() {
        int globalNumberOfPeopleServed = 0;
        double totalWaitTime = 0;
        String ret = "\n";
        for (Map.Entry pair : posStations.entrySet()) {
            POS c = (POS) pair.getValue();
            //System.out.println(c.getNumPeopleServed());
            globalNumberOfPeopleServed += c.getNumPeopleServed();
            totalWaitTime += c.getAverageWaitTime();
            ret += "Line " + ((int) pair.getKey() + 1)
                    + " Statistics\n\nServed: "
                    + c.getNumPeopleServed() + "\nAverage Wait: "
                    + waitToMinuteAndSecond(c.getAverageWaitTime()) + "\n\n";

            pair.setValue(c);
        }
        ret += "Grand Totals\n\nTotal People Served: "
                + globalNumberOfPeopleServed
                + "\nAverage Wait: " + waitToMinuteAndSecond(
                        (totalWaitTime / posStations.size()))
                + "\nAfter Minutes: " + afterMinutes;
        return ret;
    }

    protected String waitToMinuteAndSecond(double w) {
        String[] doubleArr = ("" + w).split("\\.");
        double minutes = Double.parseDouble(doubleArr[0]) * 1.0;
        double seconds = 0;
        try {
            seconds = (Double.parseDouble("." + doubleArr[1]));
        } catch (Exception e) {
            //No Seconds
        }
        seconds = seconds * 60;
        String finalSecs = (int) seconds < 10 ? "0" 
                + (int) seconds : "" + (int) seconds;
        return "00:" + (int) minutes + ":" + finalSecs;
    }

    protected void validateParameters(int n, int openMinutes,
            double arrivalProb, int minServiceTime,
            int maxServiceTime, Writer w) throws ArithmeticException,
            IllegalStateException {

        if (n < 1) {
            throw new ArithmeticException(
                    "You must have at least one register");
        }
        if (openMinutes < 1) {
            throw new IllegalStateException(
                    "Setting open minutes <= 0 sets store to closed");
        }
        if (w == null) {
            throw new IllegalStateException(
                    "An output method is reqired");
        }
        if (minServiceTime < 1 || maxServiceTime < 1) {
            throw new IllegalStateException(
                    "min and max service time must be greater than 0");
        }
        if (minServiceTime > maxServiceTime) {
            throw new IllegalStateException(
                    "min service time has been set "
                    + "larger than max serve time");
        }
    }
}
