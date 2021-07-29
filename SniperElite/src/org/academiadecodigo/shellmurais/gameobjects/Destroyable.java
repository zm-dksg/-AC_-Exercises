package org.academiadecodigo.shellmurais.gameobjects;

public interface Destroyable {

    void hit(int damage);

    boolean isDestroyed();

}
