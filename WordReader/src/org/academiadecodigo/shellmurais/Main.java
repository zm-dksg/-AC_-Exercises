package org.academiadecodigo.shellmurais;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        /*//MyWordReader wordReader = new MyWordReader("test.txt");
        //MyWordReader wordReader = new MyWordReader("test2.txt");
        //MyWordReader wordReader = new MyWordReader("auto-da-barca-do-inferno.txt");
        MyWordReader wordReader = new MyWordReader("War-and-Peace.txt");

        Iterator<String> it = wordReader.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }*/

        //MyWordReaderOpt wordReader = new MyWordReaderOpt("test.txt");
        //MyWordReaderOpt wordReader = new MyWordReaderOpt("test2.txt");
        //MyWordReaderOpt wordReader = new MyWordReaderOpt("auto-da-barca-do-inferno.txt");
        MyWordReaderOpt wordReader = new MyWordReaderOpt("War-and-Peace.txt");

        Iterator<String> it = wordReader.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());

        }

    }

}
