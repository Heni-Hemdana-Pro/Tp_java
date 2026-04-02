package SocketServer;

import java.io.BufferedReader;

public class Read extends Thread{
    BufferedReader br;
    String id;

    public Read(String id, BufferedReader br) {
        this.br = br;
        this.id =id;
    }

    public void run(){

            while(true){
                try {
                    String msg = br.readLine();
                    System.out.println(msg);
                    SocketManager.diffuserMessage(id,msg);

            }

         catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
}
