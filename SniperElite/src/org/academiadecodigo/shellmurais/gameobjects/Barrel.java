package org.academiadecodigo.shellmurais.gameobjects;

import org.academiadecodigo.shellmurais.Generate;
import org.academiadecodigo.shellmurais.Messages;
import org.academiadecodigo.shellmurais.SEGame;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage = 0;
    private boolean destroyed = false;

    public Barrel() {
        barrelType = Generate.randomBarrelType();
    }

    @Override
    public void hit(int damage) {

        verifyBarrel();
        if (!destroyed) {

            currentDamage += damage;
            SEGame.anotherShotFired();
            System.out.println(getMessage());

            verifyBarrel();
        }
    }

    @Override
    public String getMessage() {
        if (this.destroyed) { return (Messages.BARREL_DESTROY); }
        else { return (Messages.BARREL_HIT); }
    }

    // checks the current damage to this barrel to the max damage it can take
    private void verifyBarrel() {

        if (currentDamage >= barrelType.getMaxDamade()) {
            destroyed = true;
            System.out.println(getMessage());
        }
    }

    @Override
    public boolean isDestroyed() { return destroyed; }

    public String getBarrelType() { return barrelType.getBarrelType(); }
}
