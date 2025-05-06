package server.src;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
    static Archivio archivioFarmacie = new Archivio();
    ServerSocket server = null;
    Socket socketClient = null;
    DataInputStream in ;
    DataOutputStream out;
    final static int portaServer = 2025;

    public ServerTCP() throws IOException {
    }

    public Socket connessioneServer(){
        try {
            System.out.println("inizializazione server...");
            server = new ServerSocket(portaServer); // avvia il server

            System.out.println("Carico i dati...");
            archivioFarmacie.importaDati("Anagrafe-delle-farmacie-italiane.csv");

            System.out.println("In ascolto sulla porta " + portaServer +" ...");
            socketClient = server.accept(); // in ascolto sulla porta

            System.out.println("connesso col client...");
            server.close();

             in = new DataInputStream(socketClient.getInputStream()); // dove il client scrive
             out = new DataOutputStream(socketClient.getOutputStream()); // dove il client legge


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return socketClient;


    }


        public void Messaggi() {
            try {
                while (true) {
                    // Invia il menu al client
                    menu();
        
                    // Riceve la scelta del client
                    int scelta = in.readInt();
                    Farmacia farmacia = new Farmacia();
        
                    switch (scelta) {
                        case 1: // Ricerca specifica
                            out.writeUTF("Inserisci indirizzo: ");
                            farmacia.setIndirizzo(in.readUTF());
                            out.writeUTF("Inserisci descrizione: ");
                            farmacia.setDescrizione(in.readUTF());
                            out.writeUTF("Inserisci comune: ");
                            farmacia.setComune(in.readUTF());
                            out.writeUTF(archivioFarmacie.ricercaSpecifica(farmacia));
                            break;
        
                        case 2: // Ricerca indirizzo
                            out.writeUTF("Inserisci indirizzo: ");
                            farmacia.setIndirizzo(in.readUTF());
                            out.writeUTF(archivioFarmacie.ricercaIndirizzo(farmacia.getIndirizzo()));
                            break;
        
                        case 3: // Ricerca descrizione
                            out.writeUTF("Inserisci descrizione: ");
                            farmacia.setDescrizione(in.readUTF());
                            out.writeUTF(archivioFarmacie.ricercaDescrizione(farmacia.getDescrizione()));
                            break;
        
                        case 4: // Ricerca comune
                            out.writeUTF("Inserisci comune: ");
                            farmacia.setComune(in.readUTF());
                            out.writeUTF(archivioFarmacie.ricercaComune(farmacia.getComune()));
                            break;
        
                        case 5: // Stampa archivio
                            out.writeUTF(archivioFarmacie.stampaDati());
                            break;
        
                        case 0: // Uscita
                            out.writeUTF("ARRIVEDERCI");
                            return;
        
                        default: // Scelta non valida
                            out.writeUTF("Scelta non valida.");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    


    public void menu() throws IOException {
        out.writeUTF("Benvenuto nell'archivio farmacie italiane: " + "\n" +
                "0. uscire dal programma" +"\n"+
                "1. ricerca specifica" +"\n"+
                "2. ricerca indirizzo" +"\n"+
                "3. ricerca descrizione" +"\n"+
                "4. ricerca comune" +"\n"+
                "5. stampa archivio"+"\n"
                + "inserisci la tua scelta: ");
    }
}
