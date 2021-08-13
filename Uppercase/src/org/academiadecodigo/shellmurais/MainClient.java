package org.academiadecodigo.shellmurais;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MainClient {

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket(5550)) {
            String hostName = "192.168.1.21";
            int portNumber  = 5555;

            /*String hostName = "192.168.1.17";
            int portNumber  = 50505;*/

            byte[] clientRecvBuffer = new byte[1024];
            byte[] clientSendBuffer;

            DatagramPacket clientRecvPacket;
            DatagramPacket clientSendPacket;

            String str = "hello";
            clientSendBuffer = str.getBytes();
            clientSendPacket = new DatagramPacket(clientSendBuffer, clientSendBuffer.length,
                    InetAddress.getByName(hostName), portNumber);
            clientSocket.send(clientSendPacket);

            clientRecvPacket = new DatagramPacket(clientRecvBuffer, clientRecvBuffer.length);
            clientSocket.receive(clientRecvPacket);

            str = new String(clientRecvBuffer);
            System.out.println(str);

        } catch (IOException e) { e.printStackTrace(); }

    }

}