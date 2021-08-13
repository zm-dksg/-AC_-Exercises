package org.academiadecodigo.shellmurais;

import org.academiadecodigo.shellmurais.files.FileException;
import org.academiadecodigo.shellmurais.files.FileNotFoundException;
import org.academiadecodigo.shellmurais.files.NotEnoughPermissionsException;
import org.academiadecodigo.shellmurais.files.NotEnoughSpaceException;

public class FileManager {

    private boolean loggedIn = false;
    private int numFiles = 0;
    private File[] files;

    public FileManager(int maxFiles) {
        files = new File[maxFiles];

    }


    public void logIn() {
        loggedIn = true;
        System.out.println(Messages.FILE_MANAGER_LOGIN);

    }
    public void logOut() throws NotEnoughPermissionsException {

        if (!isLoggedIn()) { throw new NotEnoughPermissionsException(); }

        loggedIn = false;
        System.out.println(Messages.FILE_MANAGER_LOGOUT);

    }

    public boolean isLoggedIn() { return loggedIn; }


    public void createFile(String fileName) throws NotEnoughPermissionsException, NotEnoughSpaceException {

        if (!isLoggedIn()) { throw new NotEnoughPermissionsException(); }
        if (isFull()) { throw new NotEnoughSpaceException(); }

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = new File(fileName);
                numFiles += 1;
                System.out.println("Created new file");
                break;
            }
        }

    }

    public File getFile(String fileName) throws NotEnoughPermissionsException, FileNotFoundException {

        if (!isLoggedIn()) { throw new NotEnoughPermissionsException(); }

        for (int i = 0; i < numFiles; i++) {
            if (files[i] == null) { return null; }
            if (files[i].getFileName() == fileName) {
                return files[i];
            }
        }

        throw new FileNotFoundException();

    }


    public boolean isFull() {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) { return false; }
        }
        return true;

    }
    public int currentNumFiles() { return numFiles; }

}
