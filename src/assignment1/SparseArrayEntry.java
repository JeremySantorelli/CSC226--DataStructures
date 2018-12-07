package assignment1;

import java.util.Objects;

/**
 *
 * @author Jeremy Santorelli
 */
public class SparseArrayEntry {

    private Integer row, col, value;

    public SparseArrayEntry(Integer row, Integer col, Integer value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return "( " + row + ", " + col + " ) = " + value;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.row);
        hash = 41 * hash + Objects.hashCode(this.col);
        hash = 41 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SparseArrayEntry other = (SparseArrayEntry) obj;
        if (!Objects.equals(this.row, other.row)) {
            return false;
        }
        if (!Objects.equals(this.col, other.col)) {
            return false;
        }
        return true;
    }

}
