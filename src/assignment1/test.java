package assignment1;

/**
 *
 * @author Jeremy Santorelli
 */
public class test {

    public static void main(String[] args) {

        Writer output = new ConsoleWriter();

        int largestColumn = 0;
        int numberOfRows = 0;

        Integer[][] twoDArray = {//notional 2d array input
            {},
            {null, 3, null, 12},
            {},
            {null, null, null, 3},
            {45},
            {},
            {null, 13, 10, 34}
        };

        numberOfRows = twoDArray.length;
        //Find the largest Column Length
        for (int row = 0; row < twoDArray.length; row++) {

            if (twoDArray[row].length > largestColumn) {
                largestColumn = twoDArray[row].length;
            }
        }

        output.outputMessage("ADD ENTRIES\n");
        //Make sure it is a 2d Array
        if (numberOfRows > 0 && largestColumn > 0) {
            /* used constructor with parameters 
            in order to have LIST instance on creation*/
            SparseArray s = new SparseArray(
                    numberOfRows, largestColumn);
            //Find only important parts of Sparse Array
            for (int sparseRow = 0;
                    sparseRow < twoDArray.length;
                    sparseRow++) {

                for (int sparseCol = 0;
                        sparseCol < twoDArray[sparseRow].length;
                        sparseCol++) {

                    if (twoDArray[sparseRow][sparseCol] != null) {
                        SparseArrayEntry temp = new SparseArrayEntry(
                                sparseRow, sparseCol,
                                twoDArray[sparseRow][sparseCol]);
                        output.outputMessage(s.addEntry(temp));
                    }

                }

            }

            //Test 2 Check "getValueAt()"
            output.outputMessage("\n\nGET VALUES IN LIST\n");

            output.outputMessage(s.getValueAt(1, 3) + "\n");
            output.outputMessage(s.getValueAt(6, 1) + "\n");
            output.outputMessage(s.getValueAt(0, 0) + "\n");

            //Test 3 Check "removeColumn()"
            s.removeColumn(1, true);

            output.outputMessage("\n\nWERE ENTRIES REMOVED?\n");

            for (SparseArrayEntry test2 : s.getEntries()) {

                output.outputMessage(test2.toString() + "\n");

            }

        } else {

            output.outputMessage("Problem with Array Input");
        }
    }

}
