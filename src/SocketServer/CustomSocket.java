package SocketServer;

import java.net.Socket;

public class CustomSocket {
    String idClient;
    Socket s;

    public CustomSocket(Socket s, String idClient) {
        this.s = s;
        this.idClient = idClient;
    }
}
