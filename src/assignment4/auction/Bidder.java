package assignment4.auction;

/**
 *
 * @author Jeremy Santorelli
 */
public class Bidder {

    private String name;
    private int maxBid;

    public Bidder(String name, int maxBid) {
        this.name = name;
        this.maxBid = maxBid;
    }

    public String getName() {
        return name;
    }

    public int getMaxBid() {
        return maxBid;
    }

    public void setMaxBid(int maxBid) {
        this.maxBid = maxBid;
    }

    @Override
    public String toString() {
        return "\t" + name + "\t\t" + maxBid + "\n";
    }

}
