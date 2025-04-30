package server.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    ServerSocket server = null;
    Socket socketClient = null;
    final static int portaServer = 2025;

    public Socket connessioneServer(){
        try {
            server = new ServerSocket(portaServer); // avvia il server
            System.out.println("server inizializzato...");

            socketClient = server.accept(); // in ascolto sulla porta
            System.out.println("In ascolto sulla porta " + portaServer +" ...");

            server.close();

            DataInputStream in = new DataInputStream(socketClient.getInputStream()); // dove il client scrive
            DataOutputStream out = new DataOutputStream(socketClient.getOutputStream()); // dove il client legge

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return socketClient;


    }

    public void azioniServer(Socket socket){

    }
}
