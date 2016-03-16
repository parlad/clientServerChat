/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neupane.echoserver;

import com.neupane.echoserver.handler.ClientListner;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author parlad
 */
public class program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int port = 1500;
        try {
            ServerSocket server = new ServerSocket(port);

            List<Socket> clients = new ArrayList<Socket>();

            System.out.println("Server is running at" + port);

            while (true) {
                Socket client = server.accept();

                client.getChannel();

                clients.add(client);

                System.out.println("Connection request from" + " ," + client.getInetAddress().getHostAddress());

                ClientListner clientListner = new ClientListner(client, clients);
                clientListner.start();
            }

        } catch (IOException i) {
            System.out.println(i.getMessage());
        }
    }

}
// out.println(">>");
//                    out.flush();
