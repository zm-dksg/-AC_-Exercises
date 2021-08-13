package org.academiadecodigo.shellmurais;

import java.io.FileInputStream;
import java.io.FileOutputStream;


public class Copy {

    FileInputStream  inputStream;
    FileOutputStream outputStream;

    private byte[] buffer;
    private int size;

    public void copyFile(String inputFile, String outputFile) {
        try {
            inputStream = new FileInputStream(inputFile);
            outputStream = new FileOutputStream(outputFile);

            buffer = new byte[1024];
            while ((size = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, size);

            }

            inputStream.close();
            outputStream.close();

        } catch (Exception e) { System.out.println("fizeste merda"); }

    }



}
