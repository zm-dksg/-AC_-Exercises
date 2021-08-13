package org.academiadecodigo.shellmurais;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader urlScan = new BufferedReader(new InputStreamReader(System.in))) {
            URL url = new URL(urlScan.readLine());
            BufferedReader scan = new BufferedReader(new InputStreamReader(url.openStream()));

            String str;
            while ((str = scan.readLine()) != null) {
                System.out.println(str);
            }

            scan.close();

        } catch (IOException e) { e.printStackTrace(); }

    }

}
