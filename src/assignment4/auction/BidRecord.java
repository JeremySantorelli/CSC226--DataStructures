package assignment4.auction;

/**
 *
 * @author Jeremy Santorelli
 */
public class BidRecord {

    private Bidder bidder;
    private String result;
    private Bidder highBidder;
    private int currentBid;

    public BidRecord(Bidder bidder, String result,
            Bidder highBidder, int currentBid) {
        this.bidder = bidder;
        this.result = result;
        this.highBidder = highBidder;
        this.currentBid = currentBid;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public String getResult() {
        return result;
    }

    public Bidder getHighBidder() {
        return highBidder;
    }

    public int getCurrentBid() {
        return currentBid;
    }

    @Override
    public String toString() {
        return "\t" + bidder.getMaxBid() + " " + bidder.getName()
                + "\t" + result + "\t\t\t" + highBidder.getName()
                + "\t\t" + currentBid + "\t\t" + highBidder.getMaxBid()
                + "\n";
    }

}
