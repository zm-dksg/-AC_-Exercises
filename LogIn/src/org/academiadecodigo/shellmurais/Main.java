package org.academiadecodigo.shellmurais;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {

    public static void main(String[] args) {
        Prompt prompt = new Prompt(System.in,System.out);
        Verifier verifier = new Verifier(5);

        StringInputScanner username = new StringInputScanner();
        username.setMessage("Username: ");

        PasswordInputScanner password = new PasswordInputScanner();
        password.setMessage("Password: ");

        boolean loggedIn = false;
        while(!loggedIn) {
            String user = prompt.getUserInput(username);
            String pass = prompt.getUserInput(password);

            // checks the username and password with the user list
            if (verifier.verifyCredentials(user,pass)) {
                System.out.println("Welcome " + user + "!");
                loggedIn = true;

            } else {
                System.out.println("Incorrect username or password. Try again.");

            }

        }


    }

}
