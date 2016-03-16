package com.neupane.echoserver.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientListner extends Thread {

    private Socket client;
    private List<Socket> clients;

    public ClientListner(Socket client, List<Socket> clients) {
        this.client = client;
        this.clients = clients;
    }

    private void broadcastMessage(String msg)throws IOException{
        for (Socket s : clients) {
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println(msg);
            out.flush();
                    
            
            
        }
    }

    @Override
    public void run() {

        while (!interrupted()) {
            try {

                PrintWriter out = new PrintWriter(client.getOutputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                out.println("hello welcome to the server");
                out.flush();

                String line = "";
                while (!(line = reader.readLine()).toLowerCase().equals("exit")) {

                    System.out.println(line);
                    String sender = client.getInetAddress().getHostAddress();
                    broadcastMessage(sender +":"+ line);
                }
            } catch (IOException e) {
            }
        }
    }

}
