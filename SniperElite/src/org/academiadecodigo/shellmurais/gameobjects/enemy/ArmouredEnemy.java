package org.academiadecodigo.shellmurais.gameobjects.enemy;

import org.academiadecodigo.shellmurais.Messages;
import org.academiadecodigo.shellmurais.SEGame;

public class ArmouredEnemy extends Enemy {

    private int armour = 50;

    public ArmouredEnemy() { super.setName("Armoured Enemy"); }

    @Override
    public void hit(int damage) {

        if (armour <= 0) {
            super.hit(damage);
            SEGame.anotherShotFired();
        } else {

            armour -= damage;
            System.out.println(getMessage());

            if (armour <= 0) { System.out.println(Messages.ENEMY_ARMOUR); }
        }
    }

    @Override
    public String getMessage() { return super.getMessage(); }

}
