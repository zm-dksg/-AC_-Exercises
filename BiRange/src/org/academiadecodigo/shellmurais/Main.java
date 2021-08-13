package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        BiRange range1 = new BiRange(1,10,true);
        Iterator<Integer> it1 = range1.iterator();

        while (it1.hasNext()) {
            System.out.println(it1.next());

        }

        System.out.println();

        BiRange range2 = new BiRange(1,10,false);
        Iterator<Integer> it2 = range2.iterator();

        while (it2.hasNext()) {
            System.out.println(it2.next());

        }

    }

}
