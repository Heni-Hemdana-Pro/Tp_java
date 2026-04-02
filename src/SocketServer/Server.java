package SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Starting Server...");

        try {
            ServerSocket server = new ServerSocket(9004);
            System.out.println("Server waiting...");

            int nbClient = 0;
            while (nbClient<3) {

            Socket socket = server.accept();
            System.out.println("Client connected...");
            nbClient++;

            // ouvrir le socket en mode ecriture

            HandlerClient handler = new HandlerClient(socket);
            handler.start();

            }


        } catch (IOException e) {
            System.out.println("erreur Serveur"+e.getMessage());
        }

        System.out.println("End Server processing...");
    }
}
