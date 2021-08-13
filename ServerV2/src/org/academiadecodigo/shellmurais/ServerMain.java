package org.academiadecodigo.shellmurais;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerMain {

    // VARIABLES ////
    static final int portNumber = 6764;
    static final String PATH_HOME = "resources/HomeScreen.html";
    static final String PATH_IMG  = "resources/meme.jpg";

    // MAIN ////
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            Thread thread = new Thread(new Task(PATH_HOME, PATH_IMG, serverSocket));
            thread.start();
            thread.join();
        } catch (IOException | InterruptedException e) { e.printStackTrace(); }

    }

}
