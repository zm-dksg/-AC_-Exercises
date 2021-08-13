package org.academia.shellmurais;

public class ClientMain {

    private static final String HOST_NAME = "192.168.1.21";
    private static final int PORT_NUMBER = 9121;

    public static void main(String[] args) {

        Client client = new Client();
        client.init(HOST_NAME,PORT_NUMBER);

    }

}
