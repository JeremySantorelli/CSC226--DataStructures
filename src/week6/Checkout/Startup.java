package week6.Checkout;

import week6.Checkout.Output.Writer;
import week6.Checkout.Output.ConsoleWriter;
import week6.Checkout.StoreTypes.Line;
import week6.Checkout.StoreTypes.LineMultiple;
import week6.Checkout.StoreTypes.LineShared;

/**
 *
 * @author Jeremy Santorelli
 */
public class Startup {

    public static void main(String[] args) {

        Writer output = new ConsoleWriter();
        //Question 2 A

        System.out.println("One Line per Register\n\n");
        Line saladStop = LineMultiple.getInstance(
                4 /*number of registers*/,
                1500 /*minutes of operation*/,
                0.8 /*new customer forecast (per minute)*/,
                1 /*minimum service time (minutes)*/,
                30 /*maximum service time (minutes)*/,
                output/*how output is displayed*/
        );

        saladStop.openDoors();
        //Shows that all customers  were served
        System.out.println(saladStop.posStationsToString());
        output.outputMessage(saladStop.getGlobalCheckoutStatistics());

        System.out.println("\n\nShared Line for all Registers\n\n");
//        //Question 2 B
        Line bankOfIT = LineShared.getInstance(
                4 /*number of registers*/,
                1500 /*minutes of operation*/,
                0.8 /*new customer probability*/,
                1 /*minimum service time*/,
                30 /*maximum service time*/,
                output/*how output is displayed*/
        );

        bankOfIT.openDoors();
        //Shows that all customers  were served
        System.out.println(bankOfIT.posStationsToString());
        output.outputMessage(bankOfIT.getGlobalCheckoutStatistics());
//        
    }

}
