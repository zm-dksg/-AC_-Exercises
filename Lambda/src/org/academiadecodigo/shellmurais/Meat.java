package org.academiadecodigo.shellmurais;

public class Meat {

    private String animal;

    public Meat(String animal) {
        this.animal = animal;
    }

    public Meat getMeat() {
        return this;
    }

    public String getAnimal() {
        return animal;
    }

    public Meat setAnimal(Meat meat) {
        animal = meat.getAnimal();
        return this;
    }

}
