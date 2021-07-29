package org.academiadecodigo.shellmurais;

public class MainFarm {

    public static void main(String[] args) {

        Farm quintaDoTioManel = new Farm("Quinta do Tio Manel");

        // buying 20 animals from the farm
        Animals[] animals1 = new Animals[20];
        for (int i = 0; i < 20; i++) {

            if (quintaDoTioManel.getFarmClosed()) {
                System.out.println(Messages.LINE);
                System.out.println(quintaDoTioManel.getFarmName() + Messages.FARM_CLOSED_BUY);
            } else {
                System.out.println(Messages.LINE);
                animals1[i] = quintaDoTioManel.buyAnimal();
                System.out.print("[" + (i+1) + "] "); animals1[i].talk();
            }
        }

        System.out.println();


        // trying to return a pig that didn't come from the farm
        Pig piggy = new Pig();
        if (piggy.getAnimalBought()) {

            System.out.println(Messages.LINE);
            System.out.print("[" + 1 + "] "); piggy.talk();

            quintaDoTioManel.returnPig(piggy);
        } else {
            System.out.println(Messages.LINE);
            System.out.println(Messages.FARM_RETURN_FAIL);
        }

        System.out.println();


        //returning all 20 animals that were bought previously
        for (int i = 0; i < 20; i++) {

            if (quintaDoTioManel.getFarmClosed()) {
                System.out.println(Messages.LINE);
                System.out.println(quintaDoTioManel.getFarmName() + Messages.FARM_CLOSED_RETURN);
            } else if (animals1[i] instanceof Pig) {

                if (animals1[i].getAnimalBought()) {

                    System.out.println(Messages.LINE);
                    System.out.print("[" + (i+1) + "] "); animals1[i].talk();

                    quintaDoTioManel.returnPig((Pig) animals1[i]);
                } else {
                    System.out.println(Messages.LINE);
                    System.out.println(Messages.FARM_RETURN_FAIL);
                }
            } else {
                System.out.println(Messages.LINE);
                System.out.println(Messages.FARM_CLOSE_FAIL);
            }
        }

        System.out.println();


        // trying to buy 5 new animals from the same farm that is now close
        Animals[] animals2 = new Animals[5];
        for (int i = 0; i < 5; i++) {
            if (quintaDoTioManel.getFarmClosed()) {
                System.out.println(Messages.LINE);
                System.out.println(quintaDoTioManel.getFarmName() + Messages.FARM_CLOSED_BUY);
            } else {
                System.out.println(Messages.LINE);
                animals2[i] = quintaDoTioManel.buyAnimal();
                System.out.print("[" + (i+1) + "] "); animals2[i].talk();
            }
        }

    }

}
