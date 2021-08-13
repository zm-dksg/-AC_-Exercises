package org.academiadecodigo.shellmurais;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

    public static void main(String[] args) {

        final int portNumber = 6969;

        final String PATH_HOME = "resources/HomeScreen.html";
        final String PATH_IMG  = "resources/senpai_never_dies.jpeg";

        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(portNumber); Socket clientSocket = serverSocket.accept()) {

                BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String str1 = in.readLine();
                System.out.println(str1);

                switch (str1) {
                    case "GET / HTTP/1.1":
                        out.write(Header.homeScreen);

                        FileReader inputStream  = new FileReader(PATH_HOME);
                        BufferedReader inBuffer = new BufferedReader(inputStream);

                        String str2;
                        while ((str2 = inBuffer.readLine()) != null) {
                            out.write(str2);

                        }
                        out.flush();
                        out.close();
                        break;

                    case "GET /senpai HTTP/1.1":
                        out.write(Header.imgSenpai);
                        out.flush();

                        FileInputStream fileInputStream = new FileInputStream(PATH_IMG);
                        byte[] buffer = new byte[1024];
                        int offset;
                        while ((offset = fileInputStream.read(buffer)) != -1) {
                            clientSocket.getOutputStream().write(buffer,0,offset);

                        }
                        fileInputStream.close();
                        out.close();
                        break;

                    default:
                        out.write(Header.notFound);
                        out.flush();
                        out.close();
                        break;

                }
                in.close();

            } catch (IOException e) { e.printStackTrace(); }
        }


    }

    public static class Header {
        public static final String homeScreen = "HTTP/1.0 200 Document Follows\r\n"+
                "Content-Type: text/html; charset=UTF-8\r\n"+
                "Content-Length: <file_byte_size> \r\n"+
                "\r\n";

        public static final String imgSenpai = "HTTP/1.0 200 Document Follows\r\n"+
                "Content-Type: image/jpeg \r\n"+
                "Content-Length: <file_byte_size> \r\n"+
                "\r\n";

        public static final String notFound = "HTTP/1.0 404 Not Found\r\n"+
                "Content-Type: text/html; charset=UTF-8\r\n"+
                "Content-Length: <file_byte_size> \r\n"+
                "\r\n";

    }

}
