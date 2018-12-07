package week6.Checkout.StoreTypes;

import java.util.Map;
import week6.Checkout.Output.Writer;
import week6.Checkout.POSWithLine;

/**
 * A simulator Class that represents a business with multiple lines and multiple
 * cashiers
 *
 * @author Jeremy Santorelli
 */
public class LineMultiple extends Line {

    @Override
    public void openDoors() {
        int customerID = 1;
        turnOnPOSStations();
        do {
            if (Math.random() < super.arrivalProb
                    && super.openMinutes > 0) {
                super.posStations.get(
                        findShortestLine())
                        .newCustomer(customerID++);
            }
            //super.output.outputMessage(posStationsToString());
            iterateOneMinute();
            if (super.openMinutes < 1) {
                super.afterMinutes++;
            }
            super.openMinutes--;
            super.iteration++;
        } while (super.openMinutes > 0 || super.customersStillInStore > 0);

    }

    private void iterateOneMinute() {
        int customersWaiting = 0;
        for (Map.Entry pair : super.posStations.entrySet()) {
            POSWithLine c = (POSWithLine) pair.getValue();

            c.iterateOneMinute(
                    super.iteration,
                    super.minServiceTime,
                    super.maxServiceTime
            );
            customersWaiting += c.getLineSize();
            super.posStations.replace((int) pair.getKey(), c);
        }
        super.customersStillInStore = customersWaiting;

    }

    private int findShortestLine() {

        int shortestLine = super.averageCustomerVolume;
        int shortestLineID = super.posStations.size() + 1;
        for (Map.Entry pair : super.posStations.entrySet()) {
            POSWithLine c = (POSWithLine) pair.getValue();
            if (c.getLineSize() < shortestLine) {
                shortestLine = c.getLineSize();
                shortestLineID = (int) pair.getKey();
            }
        }
        if (shortestLineID == super.posStations.size() + 1) {
            return 0;
        } else {
            return shortestLineID;
        }
    }

    private void turnOnPOSStations() {
        int size = super.averageCustomerVolume
                / (int) ((super.n - ((double) n * 0.1)) * 2);
        for (int i = 0; i < n; i++) {

            super.posStations.put(i, new POSWithLine(size));
        }

    }

    private LineMultiple(int n, int openMinutes,
            double arrivalProb, int minServiceTime,
            int maxServiceTime, Writer w) {
        super.validateParameters(n, openMinutes, arrivalProb,
                minServiceTime, maxServiceTime, w);
        super.n = n;
        super.openMinutes = openMinutes;
        super.arrivalProb = arrivalProb;
        super.minServiceTime = minServiceTime;
        super.maxServiceTime = maxServiceTime;
        Double acv = openMinutes * (arrivalProb + arrivalProb);
        super.averageCustomerVolume = acv.intValue();
        super.output = w;
    }

    public static Line getInstance(int n, int openMinutes,
            double arrivalProb, int minServiceTime,
            int maxServiceTime, Writer w) {

        if (LineMultiple.gsp == null) {
            LineMultiple.gsp = new LineMultiple(n, openMinutes,
                    arrivalProb, minServiceTime, maxServiceTime, w);
        }
        return LineMultiple.gsp;

    }
}
