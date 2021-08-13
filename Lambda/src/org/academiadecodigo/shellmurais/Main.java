package org.academiadecodigo.shellmurais;

public class Main {

    public static void main(String[] args) {

        Machine machine = new Machine();

        // integer machine
        System.out.println("> Integer Machine");
        System.out.println(machine.monoOp(5,(n1) -> n1));
        System.out.println(machine.biOp(5,5,(n1, n2) -> n1 + n2));


        // string machine
        System.out.println("\n> String Machine");
        System.out.println(machine.monoOp("hello",(str1) -> str1.toUpperCase()));
        System.out.println(machine.biOp("Hello","there",(str1, str2) -> str1 + " " + str2));


        // meat machine
        System.out.println("\n> Meat Machine");

        Meat meat1 = new Meat("Porco");
        Meat meat2 = new Meat("Vaca");
        Meat meat3 = new Meat("Galinha");

        machine.monoOp(meat1,(m1) -> m1.getMeat());
        machine.biOp(meat2,meat3,(m1, m2) -> m2.setAnimal(m1.getMeat()));

        System.out.println(meat1.getAnimal());
        System.out.println(meat2.getAnimal());
        System.out.println(meat3.getAnimal());
    }

}
