package org.academiadecodigo.carcrash.cars;

public class TowTruck extends Car{

    public TowTruck(String direction, String way) {
        super("T",2);
        setDirection(direction);
        setWay(way);
    }

    public void repairCar(Car car) { car.setRepaired(); }

}
