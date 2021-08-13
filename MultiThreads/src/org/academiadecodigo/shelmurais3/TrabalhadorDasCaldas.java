package org.academiadecodigo.shelmurais3;

public class TrabalhadorDasCaldas implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("TRABALHADOR DAS CALDAS: Aqui a fazer loiça...");

            try {
                Thread.sleep(250);

            } catch (InterruptedException e) {
                System.out.println("Estava a dormir, mas acordaram-me");
                e.printStackTrace();

            }

        }
        System.out.println("TRABALHADOR DAS CALDAS: Não faço mais um caralho!");

    }

}
