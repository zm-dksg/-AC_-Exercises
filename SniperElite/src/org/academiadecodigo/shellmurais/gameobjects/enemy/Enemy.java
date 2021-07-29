package org.academiadecodigo.shellmurais.gameobjects.enemy;

import org.academiadecodigo.shellmurais.Messages;
import org.academiadecodigo.shellmurais.SEGame;
import org.academiadecodigo.shellmurais.gameobjects.Destroyable;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;

public abstract class Enemy extends GameObject implements Destroyable {

    private int health = 100;
    private boolean isDead = false;

    @Override
    public void hit(int damage) {

        verifyEnemy();
        if (!isDead)  {

            health -= damage;
            SEGame.anotherShotFired();
            System.out.println(getMessage());

            verifyEnemy();
        }

    }

    @Override
    public String getMessage() {
        if (this.isDead) { return Messages.ENEMY_DEAD; }
        else { return Messages.ENEMY_HIT; }
    }

    private void verifyEnemy() {

        if (health <= 0) {
            isDead = true;
            System.out.println(getMessage());
        }
    }

    @Override
    public boolean isDestroyed() { return isDead; }

}
