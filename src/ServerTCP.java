import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    final static int portaServer = 2025;

    public void avviaServer(){
        try(ServerSocket server = new ServerSocket(portaServer)){
            System.out.format("Server in ascolto su: ",server.getLocalSocketAddress());



            while (true) {

                try(Socket client = server.accept()){
                   String indirizzoCliente = client.getRemoteSocketAddress().toString();
                    System.out.format("Client : ",indirizzoCliente);
                    azioniServer(client);

                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void azioniServer(Socket socket){

    }
}
