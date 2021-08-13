package org.academiadecodigo.shellmurais;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MyWordReader implements Iterable<String> {

    FileReader fileReader;
    BufferedReader bFileReader;

    private int cur = -1;
    private String line = "";
    private String result = "";
    private ArrayList<String> strArray;

    public MyWordReader(String fileName) {
        try {
            fileReader = new FileReader(fileName);
            bFileReader = new BufferedReader(fileReader);
            strArray = new ArrayList<>();

            readFile();

        } catch (Exception e) { System.out.println("fizeste merda"); }

    }

    private void readFile() {
        try {
            while ((line = bFileReader.readLine()) != null) {
                String[] temp = line.split(" +");
                for (String s : temp) {
                    strArray.add(s);
                }

            }

        } catch (Exception e) { System.out.println("fizeste merda"); }

    }


    @Override
    public Iterator<String> iterator() {
        return strArray.listIterator();

    }

}
