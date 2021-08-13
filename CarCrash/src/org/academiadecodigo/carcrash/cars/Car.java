package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Generate;
import org.academiadecodigo.carcrash.field.Position;

public abstract class Car {

    private String name;
    private int speed;
    private String direction = "";
    private String way = "";
    private boolean crashed = false;

    // the position of the car on the grid
    private Position pos;

    public Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
        pos = new Position();
    }

    public String getName() { return name; }

    public Position getPos() { return pos; }

    public void posGoUP() {
        for (int i = 0; i < speed; i++) {
            if ((pos.getRow()-1) > 0) { pos.setRow(pos.getRow()-(1)); }
        }
    }
    public void posGoDOWN() {
        for (int i = 0; i < speed; i++) {
            if ((pos.getRow()+1) < 24) { pos.setRow(pos.getRow()+1); }
        }
    }
    public void posGoRIGHT() {
        for (int i = 0; i < speed; i++) {
            if ((pos.getCol()+1) < 99) { pos.setCol(pos.getCol()+1); }
        }
    }
    public void posGoLEFT() {
        for (int i = 0; i < speed; i++) {
            if ((pos.getCol()-1) > 0) { pos.setCol(pos.getCol()-1); }
        }
    }

    public String getDirection() { return direction; }
    public void setDirection(String direction) { this.direction = direction; }

    public String getWay() { return way; }
    public void setWay(String way) { this.way = way; }

    public boolean isCrashed() { return crashed; }
    public void setCrashed() { crashed = true; }
    public void setRepaired() { crashed = false; }

    public int getSpeed() { return speed; }

}
