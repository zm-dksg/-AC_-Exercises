package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.gameobjects.Barrel;
import org.academiadecodigo.shellmurais.gameobjects.GameObject;
import org.academiadecodigo.shellmurais.gameobjects.enemy.Enemy;
import org.academiadecodigo.shellmurais.gameobjects.Tree;

public class SEGame {

    private static int shotsFired = 0;

    private GameObject[] gameObjects;
    private SniperRifle sniperRifle = new SniperRifle();


    public void start() {

        gameObjects = createObjects(10);

        for (GameObject gameObject : gameObjects) {

            System.out.println(Messages.LINE);

            // checks the type of game object and prints their message
            // tree:   does nothing
            // others: shoots the game object until it's dead/destroyed
            if (gameObject instanceof Tree) {
                System.out.println(gameObject.getMessage());
            } else if (gameObject instanceof Barrel) {

                System.out.println("> " + ((Barrel) gameObject).getBarrelType());

                while (isBarrelUndestroyed((Barrel) gameObject)) {
                    sniperRifle.shoot((Barrel) gameObject);
                }
            } else {

                System.out.println("> " + gameObject.getName());

                while (isEnemyAlive((Enemy) gameObject)) {
                    sniperRifle.shoot((Enemy) gameObject);
                }
            }
        }

        System.out.println(Messages.LINE);
        System.out.println("The total number of shots fired is: " + shotsFired);

    }

    private GameObject[] createObjects(int num) {

        GameObject[] tempArray = new GameObject[num];

        for (int i = 0; i < num; i++) {
            tempArray[i] = Generate.randomGameObject();
        }

        return tempArray;

    }

    public static void anotherShotFired() { shotsFired += 1; }

    private boolean isEnemyAlive(Enemy enemy) {
        return !enemy.isDestroyed();
    }

    private boolean isBarrelUndestroyed(Barrel barrel) {
        return !barrel.isDestroyed();
    }

}
