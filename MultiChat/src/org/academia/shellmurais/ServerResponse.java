package org.academia.shellmurais;

import java.io.*;
import java.net.Socket;

public class ServerResponse implements Runnable {

    private PrintWriter out;
    private BufferedReader in;

    private Server server;
    private String message;

    private String clientName = "defaultUser";

    public ServerResponse(Socket clientSocket, Server server) {
        this.server = server;
        server.getClientList().add(this);

        try {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        } catch (IOException e) { e.printStackTrace(); }

    }

    @Override
    public void run() {
        try {
            while (server.isOpen()) {
                message = in.readLine();

                int msgFlag = server.messageAnalyzer(message);

                switch (msgFlag) {
                    case 0:
                        server.broadcast(message,this);
                        break;
                    case 1:
                        server.whisper(message,this);
                        break;
                    case 2:
                        clientName = server.renameUser(message);
                        out.println(message);
                        break;
                    case 3: //quit
                        break;

                }

            }
            System.out.println("User: User left the chat");
            closeAll();

        } catch (IOException e) { e.printStackTrace(); }

    }

    // GETTERS && SETTERS
    public String getClientName() {
        return clientName;

    }

    public PrintWriter out() {
        return out;

    }

    public void closeAll() {
        try {
            in.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
