package SocketServer;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class SocketManager {
    public static ArrayList<CustomSocket> list_of_sockets = new ArrayList<>();

    public static void diffuserMessage(String id, String msg){
        for (int i = 0; i<list_of_sockets.size(); i++){
            Socket s=list_of_sockets.get(i).s;
            try {
                PrintWriter pw=new PrintWriter(s.getOutputStream());
                pw.println(id+" send :"+msg+"\n at"+new Date().toLocaleString());
                pw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
