package org.academia.shellmurais;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    private static final int PORT_NUMBER = 9121;

    private ArrayList<ServerResponse> clientList;
    private ServerSocket serverSocket;

    public Server() {
        clientList = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(PORT_NUMBER);

        } catch (IOException e) { e.printStackTrace(); }

    }

    public Socket clientAccept() throws IOException {
        return serverSocket.accept();

    }

    public int messageAnalyzer(String str) {
        String[] strArr = str.split(" ");
        switch (strArr[0]) {
            case "/whisper":
                return 1;
            case "/rename":
                return 2;
            case "/quit":
                return 3;

            default:
                return 0;

        }

    }

    public void broadcast(String message, ServerResponse user) {
        message = user.getClientName() + ": " + message;
        for (ServerResponse client : clientList) {
            if (client.equals(user)) { continue; }

            client.out().println(message);

        }

    }

    public void whisper(String message, ServerResponse user) {
        String[] msgArr = message.split(" ");

        StringBuilder finalMsg = new StringBuilder("whisper@" + user.getClientName());
        for (int i = 2; i < msgArr.length; i++) {
            finalMsg.append(" ").append(msgArr[i]);
        }

        for (ServerResponse serverResponse : clientList) {
            if (serverResponse.getClientName().equals(msgArr[1])) {
                serverResponse.out().println(finalMsg);

            }

        }


    }

    public String renameUser(String message) {
        String[] msgArr = message.split(" ");
        return msgArr[1];
    }

    // GETTERS && SETTERS
    public ArrayList<ServerResponse> getClientList() {
        return clientList;

    }

    public boolean isOpen() {
        return !serverSocket.isClosed();

    }

}
