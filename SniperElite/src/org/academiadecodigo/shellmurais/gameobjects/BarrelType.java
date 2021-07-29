package org.academiadecodigo.shellmurais.gameobjects;

public enum BarrelType {

    PLASTIC("Plastic Barrel",20),
    WOOD("Wood Barrel",50),
    METAL("Metal Barrel",80);

    private String barrelType;
    private int maxDamage;

    BarrelType(String barrelType, int maxDamage) {
        this.barrelType = barrelType;
        this.maxDamage = maxDamage;
    }

    public String getBarrelType() { return barrelType; }

    public int getMaxDamade() { return maxDamage; }

}
