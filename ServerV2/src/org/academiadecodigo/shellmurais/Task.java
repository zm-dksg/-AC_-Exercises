package org.academiadecodigo.shellmurais;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Task implements Runnable {

    // PROPERTIES ////
    private final String pathIMG;
    private final String pathHOME;
    private final ServerSocket serverSocket;

    // CONSTRUCTOR ////
    public Task(String pathHOME, String pathIMG, ServerSocket serverSocket) {
        this.pathHOME = pathHOME;
        this.pathIMG = pathIMG;
        this.serverSocket = serverSocket;

    }

    @Override
    public void run() {
        while (true) {
            try (Socket clientSocket = serverSocket.accept()) {

                BufferedReader in  = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                String str1 = in.readLine();
                System.out.println(str1);

                switch (str1) {
                    case "GET / HTTP/1.1":
                        out.write(Header.homeScreen);

                        FileReader inputStream  = new FileReader(pathHOME);
                        BufferedReader inBuffer = new BufferedReader(inputStream);

                        String str2;
                        while ((str2 = inBuffer.readLine()) != null) {
                            out.write(str2);

                        }
                        out.flush();
                        out.close();
                        break;

                    case "GET /meme HTTP/1.1":
                        out.write(Header.imgSenpai);
                        out.flush();

                        FileInputStream fileInputStream = new FileInputStream(pathIMG);
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
                "Content-Type: image/jpg \r\n"+
                "Content-Length: <file_byte_size> \r\n"+
                "\r\n";

        public static final String notFound = "HTTP/1.0 404 Not Found\r\n"+
                "Content-Type: text/html; charset=UTF-8\r\n"+
                "Content-Length: <file_byte_size> \r\n"+
                "\r\n";

    }

}
