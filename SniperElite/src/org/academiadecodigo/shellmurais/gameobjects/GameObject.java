package org.academiadecodigo.shellmurais.gameobjects;

public abstract class GameObject {

    private String name = "";

    public abstract String getMessage();

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

}
