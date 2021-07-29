package org.academiadecodigo.shellmurais;

public class ArabiaNights {

    public static void main(String[] args) {

        // magic lamp creation
        MagicLamp magicLamp  = new MagicLamp(3);
        MagicLamp magicLamp2 = new MagicLamp(30);


        // making genies from magic lamp 1
        Genie genie1 = magicLamp.rubMagicLamp(3); // friendly 1
        System.out.println(Messages.LINE);

        Genie genie2 = magicLamp.rubMagicLamp(3); // grumpy 1
        System.out.println(Messages.LINE);

        Genie genie3 = magicLamp.rubMagicLamp(3); // friendly 2
        System.out.println(Messages.LINE);


        // trying to create more genies than the genie capacity
        Genie genie4 = magicLamp.rubMagicLamp(3); // demon 1
        System.out.println(Messages.LINE);

        Genie genie5 = magicLamp.rubMagicLamp(3); // demon 2
        System.out.println(Messages.LINE);


        // asking for wishes
        for (int i = 0; i < 3; i++) { genie1.grantWish(); } // friendly 1
        System.out.println(Messages.LINE);

        for (int i = 0; i < 3; i++) { genie2.grantWish(); } // grumpy 1
        System.out.println(Messages.LINE);

        for (int i = 0; i < 4; i++) { genie3.grantWish(); } // friendly 2
        System.out.println(Messages.LINE);

        for (int i = 0; i < 3; i++) { genie4.grantWish(); } // demon 1
        System.out.println(Messages.LINE);

        for (int i = 0; i < 6; i++) { genie5.grantWish(); } // demon 2
        System.out.println(Messages.LINE);


        // recharging lamp
        magicLamp.rechargeMagicLamp((GenieDemon) genie4); // demon 1
        System.out.println(Messages.LINE);

        Genie genie6 = magicLamp.rubMagicLamp(3); // friendly 3
        System.out.println(Messages.LINE);

        Genie genie7 = magicLamp.rubMagicLamp(3); // grumpy 2
        System.out.println(Messages.LINE);

        Genie genie8 = magicLamp.rubMagicLamp(3); // friendly 4
        System.out.println(Messages.LINE);


        // recharging lamp again
        magicLamp.rechargeMagicLamp((GenieDemon) genie4); // demon 1
        System.out.println(Messages.LINE);

        magicLamp.rechargeMagicLamp((GenieDemon) genie5); // demon 2
        System.out.println(Messages.LINE);


        // making genies from magic lamp 2
        Genie genie21 = magicLamp2.rubMagicLamp(3); // friendly 1
        System.out.println(Messages.LINE);

        Genie genie22 = magicLamp2.rubMagicLamp(3); // grumpy 1
        System.out.println(Messages.LINE);


        magicLamp.compareMagicLamps(magicLamp2); // compare

    }

}
