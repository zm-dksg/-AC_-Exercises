package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.gameobjects.Destroyable;

public class SniperRifle {

    private final int bulletDamage = 50;

    public void shoot(Destroyable destroyable) {
        if (hit()) { destroyable.hit(bulletDamage); }
        else { System.out.println(Messages.MISS); }
    }

    // probability of hitting the target
    private boolean hit() {
        return Generate.randomNumber(100) < 75;
    }

}
