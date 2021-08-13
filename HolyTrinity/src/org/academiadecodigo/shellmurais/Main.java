package org.academiadecodigo.shellmurais;

import java.util.stream.*;

public class Main {

    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        message = Stream.of(message.split(" ")).filter(str -> !str.equals("garbage"))
                .map(String::toUpperCase).reduce("", (acc,str) -> acc + " " + str);

        System.out.println(message);
    }

}
