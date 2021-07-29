package org.academiadecodigo.shellmurais;

public class Genie {

    // VARIABLES ////
    private int totalWishes = 0;
    private int grantedWishes = 0;


    // CONSTRUCTOR ////
    public Genie(int totalWishes) {
        this.totalWishes = totalWishes;
    }


    public void grantWish() {
        System.out.println(Messages.GENIE_WISH_GRANTED);
        grantedWishes++;
    }


    // GETTERS && SETTERS ////
    public int getTotalWishes() { return totalWishes; }

    public int getGrantedWishes() { return grantedWishes; }

}
