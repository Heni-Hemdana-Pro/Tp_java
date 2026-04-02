package SocketServer;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class write extends Thread {
    Socket socket;
    Scanner sc;
    PrintWriter pw;

    public write(PrintWriter pw, Scanner sc) {
        this.pw = pw;
        this.sc = sc;
    }

    @Override
    public void run() {
        try {
            sc = new Scanner(System.in);
            String msg = sc.nextLine();
            while(true){
                pw = new PrintWriter(socket.getOutputStream());
                pw.println("donner votre Id");
                pw.flush();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
