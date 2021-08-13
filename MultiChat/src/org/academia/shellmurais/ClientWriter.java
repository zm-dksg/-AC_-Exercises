package org.academia.shellmurais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientWriter implements Runnable {

    private PrintWriter out;
    private BufferedReader scan;
    private Client client;
    private Socket clientSocket;

    public ClientWriter(Client client, Socket clientSocket) {
        this.client = client;
        this.clientSocket = clientSocket;
        try {
            out  = new PrintWriter(clientSocket.getOutputStream(),true);
            scan = new BufferedReader(new InputStreamReader(System.in));

        } catch (IOException e) { e.printStackTrace(); }

    }

    @Override
    public void run() {
        String response;
        try {
            while (client.isUserInChat()) {
                response = scan.readLine();
                out.println(response);

            }
            userStopPrint();
            closeAll();

        } catch (IOException e) { e.printStackTrace(); }

    }

    public void closeAll() {
        try {
            out.close();
            scan.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

    public static void userStopPrint() {
        try {
            System.out.println("> Leaving chat...");
            Thread.sleep(500);
            System.out.println("> Chat left");
            Thread.sleep(500);
            System.out.println("> User Logging-out...");
            Thread.sleep(500);
            System.out.println("> User Offline");

        } catch (InterruptedException e) { e.printStackTrace(); }

    }

}
