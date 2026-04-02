package SocketServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HandlerClient extends Thread {
    Socket socket;
    public HandlerClient(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run(){
        try{
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("donner votre Id");
        pw.flush();

        // recevoir un message

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String id = br.readLine();
        System.out.println("Received Id: " + id);


        CustomSocket custom=new CustomSocket(socket, id);
        SocketManager.list_of_sockets.add(custom);

        new Read(id,br).start();


    } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
