package assignment4.auction;

import java.util.Random;
import week4_Stack.LinkedStack;
import week4_Stack.Stack;

/**
 *
 * @author Jeremy Santorelli
 */
public class RunAuction {

    public static void main(String[] args) {
        
        //Auction Parameters
        String[] bidders = {"John", "Hank", "Jill", "Thad", "Dan", "Tom", "Frank", "Bob"};
        int auctionTime = 40;
        int minBid = 1;
        int currentBid = 0;
        int numBids = 0;
        boolean firstBid = true;
        
        //Auction Result Variables
        String result = "";
        Stack bids = new LinkedStack();
        Stack history = new LinkedStack();
        Bidder highBidder = null;

        Random r = new Random();

        while (numBids < auctionTime) {//Run Auction
            Bidder newBidder = new Bidder(bidders[r.nextInt(bidders.length)], r.nextInt(5 + currentBid) + 1);

            if (firstBid) {
                highBidder = newBidder;
                result = BidResult.NEW.getValue();
                currentBid += minBid;
                firstBid = false;
                bids.push(new BidRecord(newBidder, result, highBidder, currentBid));
                history.push(newBidder);

            } else if (newBidder.getMaxBid() > highBidder.getMaxBid()) {
                if (newBidder.getName().equals(highBidder.getName())) {
                    result = BidResult.MAX.getValue();
                    highBidder = newBidder;
                    bids.push(new BidRecord(newBidder, result, highBidder, currentBid));
                } else {
                    currentBid = highBidder.getMaxBid() + minBid;
                    highBidder = newBidder;
                    result = BidResult.NEW.getValue();
                    bids.push(new BidRecord(newBidder, result, highBidder, currentBid));
                    history.push(newBidder);
                }

            } else if (highBidder.getMaxBid() > newBidder.getMaxBid() && newBidder.getMaxBid() > currentBid) {
                result = BidResult.INCREASE.getValue();
                currentBid = newBidder.getMaxBid();
                bids.push(new BidRecord(newBidder, result, highBidder, currentBid));
                history.push(newBidder);
            } else if (newBidder.getMaxBid() == currentBid) {
                result = BidResult.NOCHANGE.getValue();
                bids.push(new BidRecord(newBidder, result, highBidder, currentBid));
                history.push(newBidder);
            }

            numBids++;

        }
        
        //Output
        
        Stack bidsRev = new LinkedStack();

        while (!bids.isEmpty()) {
            bidsRev.push(bids.top());
            bids.pop();
        }

        System.out.println("Bids\n");
        System.out.println("\tNew Bid\tResult\t\t\t\tHigh Bidder\tHigh Bid\tMax Bid");

        System.out.println(bidsRev.toString());
        System.out.println("\nHistory\n");
        System.out.println("\tName\tBid");
        while (!history.isEmpty()) {
            System.out.print(history.top().toString());
            history.pop();
        }

        System.out.println("\n\nAuction End\n\nWinner: " + highBidder.getName() + " !! @ $" + currentBid);

    }

}
