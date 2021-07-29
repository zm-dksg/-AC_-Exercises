package org.academiadecodigo.shellmurais.gameobjects.enemy;

public class SoldierEnemy extends Enemy {

    public SoldierEnemy() { super.setName("Soldier Enemy"); }

    @Override
    public void hit(int damage) { super.hit(damage); }

    @Override
    public String getMessage() { return super.getMessage(); }

}
