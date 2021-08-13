package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.Generate;

public class Position {

    private int col = 0;
    private int row = 0;

    public Position() {
        col = Generate.randomNumber(100);
        row = Generate.randomNumber(25);
    }

    public int getCol() { return col; }
    public void setCol(int col) { this.col = col; }

    public int getRow() { return row; }
    public void setRow(int row) { this.row = row; }
}
