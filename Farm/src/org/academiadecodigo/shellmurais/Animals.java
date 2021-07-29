package org.academiadecodigo.shellmurais;

public abstract class Animals {

    // VARIABLES ////
    private boolean animalBought = false;

    public abstract void talk();

    // GETTERS && SETTERS ////
    public boolean getAnimalBought() { return animalBought; }

    public void setBoughtAnimal() { animalBought = true; }

}
