package SocketClient;

import java.io.PrintWriter;
import java.util.Scanner;

public class write extends Thread {  // majuscule par convention Java
    PrintWriter pw;

    public write(PrintWriter pw) {
        this.pw = pw;
    }

    @Override
    public void run() {
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String msg = sc.nextLine();  // lire ce que l'user tape
                pw.println(msg);            // envoyer au serveur
                pw.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}