package org.academiadecodigo.shellmurais;

public class GenieGrumpy extends Genie {

    // CONSTRUCTOR ////
    public GenieGrumpy(int totalWishes) {
        super(totalWishes);
    }

    @Override
    public void grantWish() {

        if (getGrantedWishes() == 1) {
            System.out.println("grumpy");
            System.out.println(Messages.GENIE_WISH_NOT_GRANTED);
        } else {
            System.out.println("grumpy");
            super.grantWish();
        }
    }

}
