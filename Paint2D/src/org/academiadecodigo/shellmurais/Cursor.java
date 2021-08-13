package org.academiadecodigo.shellmurais;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Cursor implements KeyboardHandler {

    private Keyboard keyboard;
    private KeyboardEvent up    = new KeyboardEvent();
    private KeyboardEvent down  = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent left  = new KeyboardEvent();
    private KeyboardEvent space = new KeyboardEvent();
    private KeyboardEvent g = new KeyboardEvent();
    private KeyboardEvent s = new KeyboardEvent();
    private KeyboardEvent l = new KeyboardEvent();
    private KeyboardEvent r = new KeyboardEvent();
    private KeyboardEvent f = new KeyboardEvent();
    private KeyboardEvent a = new KeyboardEvent();
    private KeyboardEvent x = new KeyboardEvent();
    private KeyboardEvent y = new KeyboardEvent();
    private KeyboardEvent n1 = new KeyboardEvent();
    private KeyboardEvent n2 = new KeyboardEvent();
    private KeyboardEvent n3 = new KeyboardEvent();
    private KeyboardEvent n4 = new KeyboardEvent();
    private KeyboardEvent n5 = new KeyboardEvent();
    private KeyboardEvent n6 = new KeyboardEvent();
    private KeyboardEvent n7 = new KeyboardEvent();
    private KeyboardEvent n8 = new KeyboardEvent();
    private KeyboardEvent n9 = new KeyboardEvent();
    private KeyboardEvent quit = new KeyboardEvent();

    private Rectangle cursor;
    private Grid grid;

    private boolean isPainting = false;
    private boolean isPaintingBig = false;

    public Cursor(Grid grid) {
        keyboard = new Keyboard(this);
        cursor = new Rectangle(10,10,10,10);
        this.grid = grid;

    }

    public void init() {
        cursor.setColor(Color.CYAN);
        cursor.fill();

        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        g.setKey(KeyboardEvent.KEY_G);
        g.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        l.setKey(KeyboardEvent.KEY_L);
        l.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        r.setKey(KeyboardEvent.KEY_R);
        r.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        f.setKey(KeyboardEvent.KEY_F);
        f.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        a.setKey(KeyboardEvent.KEY_A);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        x.setKey(KeyboardEvent.KEY_X);
        x.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        y.setKey(KeyboardEvent.KEY_Y);
        y.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        n1.setKey(KeyboardEvent.KEY_1);
        n1.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n2.setKey(KeyboardEvent.KEY_2);
        n2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n3.setKey(KeyboardEvent.KEY_3);
        n3.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n4.setKey(KeyboardEvent.KEY_4);
        n4.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n5.setKey(KeyboardEvent.KEY_5);
        n5.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n6.setKey(KeyboardEvent.KEY_6);
        n6.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n7.setKey(KeyboardEvent.KEY_7);
        n7.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n8.setKey(KeyboardEvent.KEY_8);
        n8.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        n9.setKey(KeyboardEvent.KEY_9);
        n9.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        quit.setKey(KeyboardEvent.KEY_Q);
        quit.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(up);
        keyboard.addEventListener(down);
        keyboard.addEventListener(right);
        keyboard.addEventListener(left);
        keyboard.addEventListener(space);
        keyboard.addEventListener(g);
        keyboard.addEventListener(s);
        keyboard.addEventListener(l);
        keyboard.addEventListener(r);
        keyboard.addEventListener(f);
        keyboard.addEventListener(a);
        keyboard.addEventListener(x);
        keyboard.addEventListener(y);
        keyboard.addEventListener(n1);
        keyboard.addEventListener(n2);
        keyboard.addEventListener(n3);
        keyboard.addEventListener(n4);
        keyboard.addEventListener(n5);
        keyboard.addEventListener(n6);
        keyboard.addEventListener(n7);
        keyboard.addEventListener(n8);
        keyboard.addEventListener(n9);
        keyboard.addEventListener(quit);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (getY() - 10 >= 10) {
                    cursor.translate(0,-10);
                    if (isPainting) { grid.changeSquareColor(getX(),getY()); }
                    if (isPaintingBig) { grid.changeBigSquareColor(getX(),getY()); }

                } break;
            case KeyboardEvent.KEY_DOWN:
                if (getY() + 10 <= 500) {
                    cursor.translate(0,10);
                    if (isPainting) { grid.changeSquareColor(getX(),getY()); }
                    if (isPaintingBig) { grid.changeBigSquareColor(getX(),getY()); }

                } break;
            case KeyboardEvent.KEY_RIGHT:
                if (getX() + 10 <= 500) {
                    cursor.translate(10,0);
                    if (isPainting) { grid.changeSquareColor(getX(),getY()); }
                    if (isPaintingBig) { grid.changeBigSquareColor(getX(),getY()); }

                } break;
            case KeyboardEvent.KEY_LEFT:
                if (getX() - 10 >= 10) {
                    cursor.translate(-10,0);
                    if (isPainting) { grid.changeSquareColor(getX(),getY()); }
                    if (isPaintingBig) { grid.changeBigSquareColor(getX(),getY()); }

                } break;
            case KeyboardEvent.KEY_SPACE:
                grid.changeSquareColor(getX(),getY());
                space.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
                isPainting = true;
                break;
            case KeyboardEvent.KEY_G:
                grid.changeBigSquareColor(getX(),getY());
                g.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
                isPaintingBig = true;
                break;
            case KeyboardEvent.KEY_S:
                grid.save();
                break;
            case KeyboardEvent.KEY_L:
                grid.load();
                break;
            case KeyboardEvent.KEY_R:
                grid.resetSquares();
                break;
            case KeyboardEvent.KEY_F:
                grid.fillSquares();
                break;
            case KeyboardEvent.KEY_A:
                grid.changeAllSquares();
                break;
            case KeyboardEvent.KEY_X:
                grid.symmetryX();
                break;
            case KeyboardEvent.KEY_Y:
                grid.symmetryY();
                break;
            case KeyboardEvent.KEY_1:
                grid.changeColColor(getX());
                break;
            case KeyboardEvent.KEY_2:
                grid.changeRowColor(getY());
                break;
            case KeyboardEvent.KEY_3:
                grid.changeCrossColor(getX(),getY());
                break;
            case KeyboardEvent.KEY_4:
                grid.resetColColor(getX());
                break;
            case KeyboardEvent.KEY_5:
                grid.resetRowColor(getY());
                break;
            case KeyboardEvent.KEY_6:
                grid.resetCrossColor(getX(),getY());
                break;
            case KeyboardEvent.KEY_7:
                grid.fillColColor(getX());
                break;
            case KeyboardEvent.KEY_8:
                grid.fillRowColor(getY());
                break;
            case KeyboardEvent.KEY_9:
                grid.fillCrossColor(getX(),getY());
                break;
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                isPainting = false;
                break;
            case KeyboardEvent.KEY_G:
                g.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                isPaintingBig = false;
                break;

        }

    }

    private int getX() { return cursor.getX(); }
    private int getY() { return cursor.getY(); }

}
