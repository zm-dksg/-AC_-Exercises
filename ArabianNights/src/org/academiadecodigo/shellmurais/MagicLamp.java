package org.academiadecodigo.shellmurais;

public class MagicLamp {

    // VARIABLES ////
    private int genieCapacity = 0;
    private int geniesSummoned = 0;
    private int demonsSummoned = 0;
    private int timesRecharged = 0;


    // CONSTRUCTOR ////
    public MagicLamp(int genieCapacity) {
        this.genieCapacity = genieCapacity;
    }


    // receives an integer that will be used to set the genies total wishes
    // returns a friendly genie if genies summoned is pair
    // returns a grumpy genie if genies summoned is odd
    // returns a demon genie if the lamp is at full genie capacity
    public Genie rubMagicLamp(int totalWishes) {

        if (geniesSummoned == genieCapacity) {

            System.out.println(Messages.GENIE_SUMMON_DEMON);
            GenieDemon genieDemon = new GenieDemon(totalWishes);
            demonsSummoned++;

            return genieDemon;
        } else {

            if (geniesSummoned%2 == 0) {

                System.out.println(Messages.GENIE_SUMMON_FRIENDLY);
                GenieFriendly genieFriendly = new GenieFriendly(totalWishes);
                geniesSummoned++;

                return genieFriendly;
            } else {

                System.out.println(Messages.GENIE_SUMMON_GRUMPY);
                GenieGrumpy genieGrumpy = new GenieGrumpy(totalWishes);
                geniesSummoned++;

                return genieGrumpy;
            }
        }
    }

    // recharges the magic lamp (sets genie summoned to zero)
    public void rechargeMagicLamp(GenieDemon genieDemon) {

        if (geniesSummoned < genieCapacity && demonsSummoned == 0) {
            System.out.println(Messages.MAGIC_LAMP_RECHARGE_FAILURE_ONE);
            genieDemon.recycle();
        } else if (geniesSummoned < genieCapacity) {
            System.out.println(Messages.MAGIC_LAMP_RECHARGE_FAILURE_TWO);
            genieDemon.recycle();
        } else {

            genieDemon.recycle();
            System.out.println(Messages.MAGIC_LAMP_RECHARGE_SUCCESS);
            geniesSummoned = 0;
            timesRecharged++;
        }
    }

    // prints the details of both magic lamps
    public void compareMagicLamps(MagicLamp magicLamp2) {

        System.out.println("Magic Lamp:        1 - 2");
        System.out.println("Lamp Capacity:     " + genieCapacity + " - " + magicLamp2.getGenieCapacity());
        System.out.println("Available Summons: " + (genieCapacity-geniesSummoned) + " - " + (magicLamp2.getGenieCapacity()-magicLamp2.getGeniesSummoned()));
        System.out.println("Times Recharged:   " + timesRecharged + " - " + magicLamp2.getTimesRecharged());
    }

    // GETTERS && SETTERS ////
    public int getGenieCapacity() { return genieCapacity; }

    public int getGeniesSummoned() { return geniesSummoned; }

    public int getTimesRecharged() { return timesRecharged; }

}
