package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Range range = new Range(1,10);
        Iterator<Integer> it = range.iterator();

        while (it.hasNext()) {
            if (((MyIterator) it).isEven()) {
                System.out.println(((MyIterator) it).getCur() + " is even");
            } else {
                System.out.println(((MyIterator) it).getCur() + " is odd");
            }
            it.next();

        }

    }

}