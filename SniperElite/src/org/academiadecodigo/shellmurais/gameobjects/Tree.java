package org.academiadecodigo.shellmurais.gameobjects;

import org.academiadecodigo.shellmurais.Messages;

public class Tree extends GameObject {

    public Tree() { super.setName("Tree"); }

    @Override
    public String getMessage() { return Messages.TREE; }

}
