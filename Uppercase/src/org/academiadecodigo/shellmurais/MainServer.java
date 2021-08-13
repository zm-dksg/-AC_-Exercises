package org.academiadecodigo.shellmurais;

import java.io.IOException;
import java.net.*;

public class MainServer {

    public static void main(String[] args) {

        try (DatagramSocket serverSocket = new DatagramSocket(5555);) {
            String hostName = "192.168.1.4";
            int portNumber = 7000;

            byte[] serverRecvBuffer = new byte[1024];
            byte[] serverSendBuffer;

            DatagramPacket serverRecvPacket;
            DatagramPacket serverSendPacket;

            serverRecvPacket = new DatagramPacket(serverRecvBuffer, serverRecvBuffer.length);
            serverSocket.receive(serverRecvPacket);

            String str = new String(serverRecvBuffer);
            System.out.println("Printing Message...");
            System.out.println("> " + str + " = " + str.toUpperCase());

            str = str.toUpperCase();
            serverSendBuffer = str.getBytes();
            serverSendPacket = new DatagramPacket(serverSendBuffer, serverSendBuffer.length,
                    InetAddress.getByName(hostName), portNumber);

            serverSocket.send(serverSendPacket);

        } catch (IOException e) { e.printStackTrace(); }

    }

}