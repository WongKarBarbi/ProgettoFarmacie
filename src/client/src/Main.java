package client.src;

import java.net.Socket;

public class Main {
    public static void main(String[] args){
        Client s = new Client();
        s.connettiClient();
        s.Messaggi();
    }
}
