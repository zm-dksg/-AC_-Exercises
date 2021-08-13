package org.academiadecodigo.shellmurais;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    // VARIABLES ////
    static final int portNumber = 6864;
    static final String PATH_HOME = "resources/HomeScreen.html";
    static final String PATH_IMG  = "resources/meme.jpg";

    // MAIN ////
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            ExecutorService cachedPool = Executors.newCachedThreadPool();
            cachedPool.submit(new Task(PATH_HOME, PATH_IMG, serverSocket));
            cachedPool.shutdown();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
