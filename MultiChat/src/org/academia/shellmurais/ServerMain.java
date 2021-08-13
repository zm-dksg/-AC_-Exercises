package org.academia.shellmurais;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    public static void main(String[] args) {

        Server server = new Server();
        ExecutorService cashedPool = Executors.newCachedThreadPool();

        serverStartPrint();
        while (true) {
            try {
                cashedPool.submit(new ServerResponse(server.clientAccept(), server));

            } catch (IOException e) { e.printStackTrace(); }

        }

    }

    public static void serverStartPrint() {
        try {
            System.out.println("> Server Initializing...");
            Thread.sleep(500);
            System.out.println("> Server Online");
            Thread.sleep(500);
            System.out.println("> Creating chat...");
            Thread.sleep(500);
            System.out.println("> Chat created");
            Thread.sleep(500);
            System.out.println("> Waiting for users...");

        } catch (InterruptedException e) { e.printStackTrace(); }

    }

}
