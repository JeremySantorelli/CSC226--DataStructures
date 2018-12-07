package assignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jeremy Santorelli
 */
public class SparseArray {

    private int numRows, numCols;
    private List<SparseArrayEntry> entries;

    public SparseArray() {//Added empty contructor QUESTION 1
    }

    public SparseArray(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.entries = new ArrayList<>();
    }

    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public List<SparseArrayEntry> getEntries() {
        return entries;
    }

    /*
    
        Assignment
    
     */
    public String addEntry(SparseArrayEntry entry) {//QUESTION 2

        if (entry == null) {

            return "Entry is empty";

        } else if (entry.getCol() == null || entry.getRow() == null) {

            return "Entry not given a Row or Column Value";

        } else if (entry.getCol() > numCols
                || entry.getRow() > numRows) {

            return "Entry exceeds 2d Array Bounds";

        } else {

            entries.add(entry);
            return entry.toString();
        }

    }

    public int getValueAt(int row, int col) {//Question 3

        int val = Integer.MIN_VALUE;

        Optional<SparseArrayEntry> found = entries.stream().filter(
                entry -> entry.getCol() == col
                && entry.getRow() == row).findFirst();

        if (found.isPresent()) {
            val = found.get().getValue();
        }

        return val;

    }

    public void removeColumn(int col, boolean shiftColumns) {//Question 4

        boolean removed = entries.removeIf(
                entry -> entry.getCol() == col);

        //I see this being problematic so I have this only if requested
        if (shiftColumns && removed) {

            for (SparseArrayEntry s : entries) {

                if (s.getCol() > col) {

                    s.setCol(s.getCol() - 1);

                }

            }

        }

    }

}
