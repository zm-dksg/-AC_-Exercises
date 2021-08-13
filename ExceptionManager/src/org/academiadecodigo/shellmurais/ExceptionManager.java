package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.files.FileNotFoundException;
import org.academiadecodigo.shellmurais.files.NotEnoughPermissionsException;
import org.academiadecodigo.shellmurais.files.NotEnoughSpaceException;

public class ExceptionManager {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager(3);

        try {
            fileManager.logOut();
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        fileManager.logIn();

        try {
            fileManager.createFile("myFile");
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (NotEnoughSpaceException e) {
            System.out.println(e.getMessage());
        }

        try {
            File file = fileManager.getFile("myFile");
            System.out.println(file.getFileName());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            fileManager.logOut();
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        fileManager.logIn();

        for (int i = 0; i < 3; i++) {
            try {
                fileManager.createFile("myFile");
            } catch (NotEnoughPermissionsException e) {
                System.out.println(e.getMessage());
            } catch (NotEnoughSpaceException e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            File file = fileManager.getFile("myFile");
            System.out.println(file.getFileName());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            File file = fileManager.getFile("yourFile");
            System.out.println(file.getFileName());
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            fileManager.logOut();
        } catch (NotEnoughPermissionsException e) {
            System.out.println(e.getMessage());
        }

    }

}
