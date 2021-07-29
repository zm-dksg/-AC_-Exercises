package org.academiadecodigo.shellmurais;

public class Farm {

    // VARIABLES ////
    private String farmName;
    private boolean farmClosed = false;

    // CONSTRUCTOR ////
    public Farm(String farmName) { this.farmName = farmName; }

    public Animals buyAnimal() {

        Animals animal = Generator.randomAnimal();
        animal.setBoughtAnimal();
        System.out.println(farmName + Messages.FARM_BUY);

        return animal;
    }

    public void returnPig(Pig pig) {
        pig.returnPig();
        farmClosed = true;
        System.out.println(farmName + Messages.FARM_CLOSE);
    }

    // GETTERS && SETTERS ////
    public String getFarmName() { return farmName; }

    public boolean getFarmClosed() { return farmClosed; }

}
