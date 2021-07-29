package org.academiadecodigo.shellmurais;

public class GenieDemon extends Genie {

    // VARIABLES ////
    private boolean recycled = false;

    // CONSTRUCTOR ////
    public GenieDemon(int totalWishes) {
        super(totalWishes);
    }

    @Override
    public void grantWish() {
        System.out.println("demon");
        super.grantWish();
    }

    public void recycle() {

        if (recycled) {
            System.out.println(Messages.DEMON_RECYCLE_FAILURE);
        } else {
            System.out.println(Messages.DEMON_RECYCLE_SUCCESS);
            recycled = true;
        }
    }

}
