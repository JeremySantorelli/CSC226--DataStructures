package assignment4.auction;

/**
 *
 * @author Jeremy Santorelli
 */
public enum BidResult {

    NEW("New High Bidder"), INCREASE("High Bid Increased"),
    NOCHANGE("No Change"), MAX("Max Bid Increased");

    private final String name;

    BidResult(String s) {
        this.name = s;
    }

    public String getValue() {
        return name;
    }

}
