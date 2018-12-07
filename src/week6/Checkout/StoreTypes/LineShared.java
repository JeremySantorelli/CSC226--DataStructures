package week6.Checkout.StoreTypes;

import java.util.Map;
import week6_Queue.BoundedQueue;
import week6.Checkout.Output.Writer;
import week6.Checkout.POSSharedLine;

/**
 * A simulator class that represents a single Line with multiple cashiers
 *
 * @author Jeremy Santorelli
 */
public class LineShared extends Line {

    private final BoundedQueue<Integer> waitQ;

    @Override
    public void openDoors() {
        int customerID = 1;
        turnOnPOSStations();
        do {
            if (Math.random() < super.arrivalProb
                    && super.openMinutes > 0) {
                this.waitQ.enqueue(customerID++);
            }
            //super.output.outputMessage(posStationsToString());
            iterateOneMinute();
            if (openMinutes < 1) {
                afterMinutes++;
            }
            super.openMinutes--;
            super.iteration++;
        } while (super.openMinutes > 0 || super.customersStillInStore > 0);
    }

    private void turnOnPOSStations() {
        for (int i = 0; i < n; i++) {
            super.posStations.put(i, new POSSharedLine());
        }
    }

    private void iterateOneMinute() {
        int customerWaiting = 0;
        for (Map.Entry pair : super.posStations.entrySet()) {
            POSSharedLine c = (POSSharedLine) pair.getValue();
            if (c.getCurrentCustomer() == -1 && !this.waitQ.isEmpty()) {
                c.newCustomer(this.waitQ.dequeue());
            }
            c.iterateOneMinute(
                    super.iteration,
                    super.minServiceTime,
                    super.maxServiceTime
            );
            if (c.getCurrentCustomer() != -1) {
                customerWaiting++;
            }
            super.posStations.replace((int) pair.getKey(), c);

        }
        super.customersStillInStore = customerWaiting;
    }

    private LineShared(int n, int openMinutes,
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
        this.waitQ = new BoundedQueue<>(acv.intValue());
    }

    public static Line getInstance(int n, int openMinutes,
            double arrivalProb, int minServiceTime,
            int maxServiceTime, Writer w) {

        if (LineShared.gsp == null) {
            LineShared.gsp = new LineShared(n, openMinutes, arrivalProb,
                    minServiceTime, maxServiceTime, w);
        }
        return LineShared.gsp;

    }

}
