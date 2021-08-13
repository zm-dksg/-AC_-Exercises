package org.academiadecodigo.shellmurais;

public class Generator {

    public static String createRandomString() {
        String string = "";

        for (int i = 0; i < 5; i++) {
            string = string + "" + randomNumber();
        }

        return string;
    }

    private static int randomNumber() {
        return (int) ((Math.random() * 10));
    }

}
