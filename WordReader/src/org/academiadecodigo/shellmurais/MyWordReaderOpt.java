package org.academiadecodigo.shellmurais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MyWordReaderOpt implements Iterable<String> {

    FileReader fileReader;
    BufferedReader bFileReader;

    private int cur = -1;
    private String line = "";
    private String result = "";
    private String[] strArray;

    public MyWordReaderOpt(String fileName) {
        try {
            fileReader = new FileReader(fileName);
            bFileReader = new BufferedReader(fileReader);

            line = bFileReader.readLine();
            strArray = line.split(" +");

        } catch (Exception e) { System.out.println("fizeste merda"); }

    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            @Override
            public boolean hasNext() {
                try {
                    if (cur+1 < strArray.length) { return true; }
                    if ((line = bFileReader.readLine()) != null) {
                        strArray = line.split(" ");
                        cur = -1;
                        return true;

                    } else { return false; }

                } catch (Exception e) { System.out.println("fizeste merda"); }

                return false;

            }

            @Override
            public String next() {
                return strArray[++cur];
            }

        };

    }

}
