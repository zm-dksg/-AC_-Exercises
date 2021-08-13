package org.academiadecodigo.shellmurais.casadebanho1;

public class Main {

    public static void main(String[] args) {
        Bathroom bathroom = new Bathroom();

        Thread igreja = new Thread(new Cadet(bathroom,"Igreja"));
        Thread carneiro = new Thread(new Cadet(bathroom,"Carneiro"));
        Thread ze = new Thread(new Cadet(bathroom,"Ze"));

        igreja.start();
        carneiro.start();
        ze.start();

    }

}
