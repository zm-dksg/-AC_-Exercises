package org.academiadecodigo.shellmurais;

public class Generator {

    public static Animals randomAnimal() {

        int num = randomNumber(1,100);

        if (num >= 1  && num<=5) {
            return new Pig();
        } else if (num >= 6  && num<=50) {
            return new Cow();
        } else {
            return new Chicken();
        }
    }

    private static int randomNumber(int min, int max) {
        return (int) Math.floor((Math.random() * max) + min );
    }

}
