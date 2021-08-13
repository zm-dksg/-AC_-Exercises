package org.academiadecodigo.carcrash;

import org.academiadecodigo.carcrash.cars.Car;
import org.academiadecodigo.carcrash.cars.CarFactory;
import org.academiadecodigo.carcrash.cars.TowTruck;
import org.academiadecodigo.carcrash.field.Field;

public class Game {

    public static final int MANUFACTURED_CARS = 40;

    // container of cars
    private Car[] cars;

    // animation delay
    private int delay;

    public Game(int cols, int rows, int delay) {
        Field.init(cols, rows);
        this.delay = delay;
    }

    // creates a bunch of cars and randomly puts them in the field
    public void init() {

        cars = new Car[MANUFACTURED_CARS];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = CarFactory.getNewCar();
            //System.out.println(cars[i].getName() + " : Speed " + cars[i].getSpeed() + " : Pos (" + cars[i].getPos().getCol() + "," + cars[i].getPos().getRow() + ")");
        }
        Field.draw(cars);

    }

    // starts the animation @throws InterruptedException
    public void start() throws InterruptedException {
        boolean gameRunning = true;
        while (gameRunning) {
            // Pause for a while
            Thread.sleep(delay);
            // Move all cars
            moveAllCars();
            // Update screen
            Field.draw(cars);

            //gameRunning = false;
        }

    }

    private void moveAllCars() {
        for (int i = 0; i < cars.length; i++) {
            if (!cars[i].isCrashed()) {

                if (cars[i].getName() == "J" || cars[i].getName() == "T") {
                    switch (cars[i].getDirection()) {
                        // o carro só pode andar na vertical
                        case "HORIZONTAL":  switch (cars[i].getWay()) {
                                                case "UP":
                                                    if ((cars[i].getPos().getRow()-1) > 0) { cars[i].posGoUP(); }
                                                    else { cars[i].setWay("DOWN"); }
                                                    break;

                                                case "DOWN":
                                                    if ((cars[i].getPos().getRow()+1) < 24) { cars[i].posGoDOWN(); }
                                                    else { cars[i].setWay("UP"); }
                                                    break;
                                            }

                        // o carro só pode andar na horizontal
                        case "VERTICAL":    switch (cars[i].getWay()) {
                                                case "LEFT":
                                                    if ((cars[i].getPos().getCol()-1) > 0) { cars[i].posGoLEFT(); }
                                                    else { cars[i].setWay("RIGHT"); }
                                                    break;

                                                case "RIGHT":
                                                    if ((cars[i].getPos().getCol()+1) < 99) { cars[i].posGoRIGHT(); }
                                                    else { cars[i].setWay("LEFT"); }
                                                    break;
                                            }
                    }
                } else {
                    switch (Generate.randomNumber(4)) {
                        case 0: cars[i].posGoUP();
                                break;
                        case 1: cars[i].posGoDOWN();
                                break;
                        case 2: cars[i].posGoLEFT();
                                break;
                        case 3: cars[i].posGoRIGHT();
                                break;
                    }
                }

                verifyCarCrashes(i);
            }
        }
    }

    private void verifyCarCrashes(int i) {
        for (int j = 0; j < cars.length; j++) {
            if (j == i) { continue; }
            if (cars[i].getPos().getCol() == cars[j].getPos().getCol()) {
                if (cars[i].getPos().getRow() == cars[j].getPos().getRow()) {

                    switch (cars[i].getName()) {
                        // first car is a jeep
                        case "J":   switch (cars[j].getName()) {
                                        case "J":   cars[i].setCrashed();
                                                    cars[j].setCrashed();
                                                    break;
                                        default:    cars[j].setCrashed();
                                                    break;
                                    }

                        // first car is a tow truck
                        case "T":   switch (cars[j].getName()) {
                                        case "T":   cars[i].setCrashed();
                                                    cars[j].setCrashed();
                                                    break;
                                        case "J":   cars[i].setCrashed();
                                                    break;
                                        default:    ((TowTruck) cars[i]).repairCar(cars[j]);
                                                    break;
                                    }

                        // first car is not a jeep nor a tow truck
                        default:    switch (cars[j].getName()) {
                                        case "J":   cars[i].setCrashed();
                                                    break;
                                        case "T":   ((TowTruck) cars[j]).repairCar(cars[i]);
                                                    break;
                                        default:    cars[i].setCrashed();
                                                    cars[j].setCrashed();
                                                    break;
                                    }
                    }

                }
            }
        }
    }

}
