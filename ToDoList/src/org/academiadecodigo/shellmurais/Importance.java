package org.academiadecodigo.shellmurais;

public enum Importance {

    HIGH(1),
    MEDIUM(2),
    LOW(3);

    private final int imp;

    Importance(int imp) {
        this.imp = imp;

    }

    public int getImp() { return imp; }

}
