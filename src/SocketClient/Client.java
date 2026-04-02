package SocketClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Start Client...");

        try {
            Socket socket = new Socket("127.0.0.1", 9004);
            System.out.println("I'm connected to the server...");

            // Lire le message "donner votre Id" du serveur
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String ligne = br.readLine();
            System.out.println(ligne);  // affiche "donner votre Id"

            // Saisir et envoyer l'Id
            Scanner sc = new Scanner(System.in);
            String id = sc.nextLine();

            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(id);
            pw.flush();

            // Lancer les deux threads
            new Read(br).start();        // écouter les messages du serveur
            new write(pw).start();       // ✅ CORRECTION : envoyer des messages

        } catch (IOException e) {
            System.out.println("erreur client : " + e.getMessage());
        }
    }
}