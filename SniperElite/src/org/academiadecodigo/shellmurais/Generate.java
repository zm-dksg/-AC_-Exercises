package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.gameobjects.Barrel;
import org.academiadecodigo.shellmurais.gameobjects.BarrelType;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.Tree;
import org.academiadecodigo.shellmurais.gameobjects.enemy.ArmouredEnemy;
import org.academiadecodigo.shellmurais.gameobjects.enemy.SoldierEnemy;

public class Generate {

    public static GameObject randomGameObject() {

        int temp = randomNumber(100);

        // armoured soldier - 30%
        if (temp >= 0 && temp <= 29) {
            return new ArmouredEnemy();
        }
        // soldier enemy - 30%
        else if (temp >= 30 && temp <= 59) {
            return new SoldierEnemy();
        }
        // barrel - 20%
        else if (temp >= 60 && temp <= 79) {
            return new Barrel();
        }
        // tree - 20%
        else if (temp >= 80 && temp <= 100) {
            return new Tree();
        }
        else {
            return null;
        }
    }


    public static BarrelType randomBarrelType() {

        int temp = randomNumber(3);

        // plastic barrel - 33%
        if (temp == 0) { return BarrelType.values()[0]; }
        // wood barrel - 33%
        else if (temp == 1) { return BarrelType.values()[1]; }
        // metal barrel - 33%
        else if (temp == 2) { return BarrelType.values()[2]; }
        else { return null; }

    }


    public static int randomNumber(int max) {
        return (int) (Math.random() * max);
    }

}
