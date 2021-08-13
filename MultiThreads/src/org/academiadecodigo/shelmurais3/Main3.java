package org.academiadecodigo.shelmurais3;

public class Main3 {

    public static void main(String[] args) {
        System.out.println("GERENTE DAS CALDAS: Há espera que estes trabalhadores acabem...");

        Thread trabalhador = new Thread(new TrabalhadorDasCaldas());
        trabalhador.start();

        try {
            trabalhador.join();

        } catch (InterruptedException e) {
            System.out.println("Acordaram-me da sesta, mas ainda não acabaram.");
            e.printStackTrace();

        }

        System.out.println("GERENTE DAS CALDAS: Finalmente acabaram, vou para casa.");

    }

}
