package org.academia.shellmurais;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    private String name;
    private boolean userInChat;

    public Client() {
        name = "defaultUser";

    }

    public void init(String hostName, int portNumber) {
        ExecutorService cachedPool;
        Socket clientSocket;

        clientStartPrint();
        try {
            clientSocket = new Socket(hostName,portNumber);

            userInChat = true;

            cachedPool = Executors.newCachedThreadPool();
            cachedPool.submit(new ClientReader(this,clientSocket));
            cachedPool.submit(new ClientWriter(this,clientSocket));

        } catch (IOException e) { e.printStackTrace(); }

    }

    public static void clientStartPrint() {
        try {
            System.out.println("> User Logging-in...");
            Thread.sleep(500);
            System.out.println("> User Online");
            Thread.sleep(500);
            System.out.println("> Joining server...");
            Thread.sleep(500);
            System.out.println("> Server joined");

        } catch (InterruptedException e) { e.printStackTrace(); }

    }

    // GETTERS && SETTERS

    public String getName() {
        return name;

    }
    public void setName(String name) {
        this.name = name;

    }

    public boolean isUserInChat() {
        return userInChat;

    }
    public void leaveChat() {
        userInChat = false;

    }
}
