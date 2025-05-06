package client.src;

import server.src.Farmacia;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Client {
    Socket server = null;
    final static int portaServer = 2025;
    DataInputStream in;
    DataOutputStream out;

    public Socket connettiClient(){
        try {
            System.out.println("tentativo di connessione...");
            server = new Socket(InetAddress.getLocalHost(),portaServer);
            System.out.println("connesso...");
            in = new DataInputStream(server.getInputStream());
            out = new DataOutputStream(server.getOutputStream());

        } catch (IOException e) {
            System.err.println("Il server risulta spento o non raggiungibile");
        }

        return server;

    }

    public void Messaggi() {
        Scanner kbd = new Scanner(System.in);
        try {
            // Riceve il menu dal server
            String menu = in.readUTF();
            System.out.println(menu);
    
            // Legge la scelta dell'utente
            int risposta = kbd.nextInt();
            out.writeInt(risposta); // Invia la scelta al server

            String risultato = "";

            String messaggio ="";

    
            // Gestisce le opzioni del menu
            switch (risposta) {
                case 1: // Opzione 1: Ricerca specifica
                    kbd.nextLine(); // Consuma la newline
                    System.out.print("Inserisci indirizzo: ");
                    out.writeUTF(kbd.nextLine());
                    System.out.print("Inserisci descrizione: ");
                    out.writeUTF(kbd.nextLine());
                    System.out.print("Inserisci comune: ");
                    out.writeUTF(kbd.nextLine());
                    risultato = in.readUTF(); // Riceve il risultato dal server
                    System.out.println("Risultato: " + risultato);
                    break;
    
                case 2: // Opzione 2: Ricerca per indirizzo
                    kbd.nextLine(); // Consuma la newline
                    messaggio = in.readUTF();
                    System.out.println(messaggio);
                    out.writeUTF(kbd.nextLine());
                    risultato = in.readUTF(); // Riceve il risultato dal server
                    System.out.println("Risultato: " + risultato);
                    break;
    
                case 3: // Opzione 3: ricerca per descrizione
                    kbd.nextLine(); // Consuma la newline
                    messaggio = in.readUTF();
                    System.out.println(messaggio);
                    out.writeUTF(kbd.nextLine());
                    risultato = in.readUTF(); // Riceve il risultato dal server
                    System.out.println("Risultato: " + risultato);
                    break;
    
                case 4: // Opzione 4: ricerca per comune
                    kbd.nextLine(); // Consuma la newline
                    messaggio = in.readUTF();
                    System.out.println(messaggio);
                    out.writeUTF(kbd.nextLine());
                    risultato = in.readUTF(); // Riceve il risultato dal server
                    System.out.println("Risultato: " + risultato);
                    break;
                case 5: // Opzione 5: stampa elenco farmacie
                    System.out.println("ELENCO GENERALE FARMACIE:");
                    risultato = in.readUTF(); // Riceve il risultato dal server
                    System.out.println("Risultato: " + risultato);
                    break;

                default: // Opzione non valida
                    System.out.println("Scelta non valida.");
                    return;
            }
    
            // Riceve il risultato dal server

    
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
