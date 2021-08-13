package org.academia.shellmurais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {

        int portNumber = 9121;

        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;

        BufferedReader scan;
        String message;
        String response;

        boolean chatRunning = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            clientSocket = serverSocket.accept();

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            scan = new BufferedReader(new InputStreamReader(System.in));
            while (chatRunning) {
                message = in.readLine();
                System.out.println("User: " + message);
                if (message.equals("quit chat")) {
                    System.out.println("Server: end of chat");
                    out.println("end of chat");
                    break;
                }

                System.out.print("Server: ");
                response = scan.readLine();
                out.println(response);
                System.out.println();

            }

            in.close();
            out.close();
            clientSocket.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
