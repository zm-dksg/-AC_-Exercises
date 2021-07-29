package org.academiadecodigo.shellmurais;

public class Pig extends Animals {

    // VARIABLES ////
    private boolean returned = false;

    public void talk() { System.out.println(Messages.TALK_PIG); }

    public void returnPig() { returned = true; }

    // GETTERS && SETTERS ////
    public boolean getReturned() { return returned; }

}
