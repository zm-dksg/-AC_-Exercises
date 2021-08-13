package org.academiadecodigo.shellmurais;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Memory {

    private final String PATH = "SaveFile";

    public void save(Square[][] grid) {
        try {
            FileOutputStream outputStream = new FileOutputStream(PATH);
            byte b;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j].isColored()) {
                        b = 1;
                        outputStream.write(b);

                    } else {
                        b = 0;
                        outputStream.write(b);

                    }

                }

            }
            outputStream.close();
        } catch (IOException e) { System.out.println("IOException"); }

    }

    public Square[][] load(Square[][] grid) {
        try {
            FileInputStream inputStream = new FileInputStream(PATH);
            int b;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    b = inputStream.read();
                    if (b == 1) {
                        grid[i][j].changeColor();

                    }

                }

            }

            inputStream.close();
        } catch (IOException e) { System.out.println("IOException"); }
        return grid;

    }

}
