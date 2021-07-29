package org.academiadecodigo.shellmurais;

public class GenieFriendly extends Genie {

    // CONSTRUCTOR ////
    public GenieFriendly(int totalWishes) {
        super(totalWishes);
    }

    @Override
    public void grantWish() {

        if (getGrantedWishes() == getTotalWishes()) {
            System.out.println("friendly");
            System.out.println(Messages.GENIE_WISH_NOT_GRANTED);
        } else {
            System.out.println("friendly");
            super.grantWish();
        }
    }

}
