package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.Generate;

public class CarFactory {

    public static Car getNewCar() {

        int tempNum = Generate.randomNumber(6);
        int tempNum2 = Generate.randomNumber(2);
        if (tempNum == 0) {
            Porsche porsche = new Porsche();
            return porsche;
        } else if (tempNum == 1) {
            Mustang mustang = new Mustang();
            return mustang;
        } else if (tempNum == 2) {
            Fiat fiat = new Fiat();
            return fiat;
        } else if (tempNum == 3) {
            Lancia lancia = new Lancia();
            return lancia;
        } else if (tempNum == 4) {
            Jeep jeep;
            if (tempNum2 == 0) { jeep = new Jeep("HORIZONTAL","RIGHT"); }
            else { jeep = new Jeep("VERTICAL","UP"); }
            return jeep;
        } else {
            TowTruck towTruck;
            if (tempNum2 == 0) { towTruck = new TowTruck("HORIZONTAL","RIGHT"); }
            else { towTruck = new TowTruck("VERTICAL","UP"); }
            return towTruck;
        }

    }

}
