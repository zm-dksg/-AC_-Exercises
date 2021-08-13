package org.academia.shellmurais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReader implements Runnable {

    private BufferedReader in;
    private String message;
    private Client client;
    private Socket clientSocket;

    public ClientReader(Client client,Socket clientSocket) {
        this.client = client;
        this.clientSocket = clientSocket;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) { e.printStackTrace(); }

    }

    @Override
    public void run() {
        try {
            while (client.isUserInChat()) {
                message = in.readLine();
                if (renameUser(message)) {
                    continue;

                }
                System.out.println(message);

            }
            System.out.println("User: User left the chat");
            closeAll();

        } catch (IOException e) { e.printStackTrace(); }

    }

    public boolean renameUser(String message) {
        String[] strArr = message.split(" ");
        if (strArr[0].equals("/rename")) {
            client.setName(strArr[1]);
            return true;

        } else {
            return false;

        }

    }

    public void closeAll() {
        try {
            in.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
