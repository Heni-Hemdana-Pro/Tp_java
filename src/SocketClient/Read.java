package SocketClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Read extends Thread{
    BufferedReader br;
    Socket socket;

    public Read(BufferedReader br) {
        this.br = br;
    }

    public void run(){
        try{
            while(true){
                String ligne = br.readLine();
                System.out.println(ligne);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
