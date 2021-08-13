package org.academia.shellmurais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientMain {

    public static void main(String[] args) {

        String hostName = "192.168.1.21";
        int portNumber  = 9121;

        PrintWriter out;
        BufferedReader in;

        BufferedReader scan;
        String message;
        String response = "";

        try (Socket clientSocket = new Socket(hostName,portNumber)) {
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            scan = new BufferedReader(new InputStreamReader(System.in));
            while (!response.equals("end of chat")) {
                System.out.print("User: ");
                message = scan.readLine();
                out.println(message);

                response = in.readLine();
                System.out.println("Server: " + response);
                System.out.println();
            }

            in.close();
            out.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
