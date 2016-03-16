package com.neupane.echoclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author parlad
 */
public class program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the server address also hostaname:");
        String address = scanner.nextLine();
        System.out.println("Enter port:");
        int port = scanner.nextInt();

        try {
            Socket socket = new Socket(address, port);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException i) {
            System.out.println(i.getMessage());

        }

    }

}
