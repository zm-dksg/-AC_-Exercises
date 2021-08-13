package org.academiadecodigo.shellmurais;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Square {

    private Rectangle square;

    private boolean isColored = false;

    public Square(int x, int y) {
        square = new Rectangle(x,y,10,10);
        square.setColor(Color.BLACK);
        init();

    }

    private void init() {
        square.draw();

    }

    public void changeColor() {
        if (isColored) {
            square.draw();
            isColored = false;

        } else {
            square.fill();
            isColored = true;

        }

    }

    public void reset() {
        square.draw();
        isColored = false;

    }

    public void fill() {
        square.fill();
        isColored = true;

    }

    public boolean isColored() { return isColored; }

}
