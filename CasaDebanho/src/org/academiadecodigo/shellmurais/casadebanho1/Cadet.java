package org.academiadecodigo.shellmurais.casadebanho1;

public class Cadet implements Runnable {

    private Bathroom bathroom;
    private String name;

    public Cadet(Bathroom bathroom, String name) {
        this.bathroom = bathroom;
        this.name = name;

    }

    @Override
    public void run() {
        Thread.currentThread().setName(name);
        bathroom.enter();
        bathroom.washHands();

    }
}
