package server.src;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Archivio archivioFarmacie = new Archivio();
        archivioFarmacie.importaDati("Anagrafe-delle-farmacie-italiane.csv");
        int scelta;
        do{
            menu();
            scelta = sceltaMenu(archivioFarmacie);
        }while(scelta !=0 );
        */

        ServerTCP s = new ServerTCP();
        s.connessioneServer();

    }

    public static void menu() {
        System.out.println("Benvenuto nell'archivio farmacie italiane: ");
        System.out.println("0. uscire dal programma");
        System.out.println("1. ricerca specifica");
        System.out.println("2. ricerca indirizzo");
        System.out.println("3. ricerca descrizione");
        System.out.println("4. ricerca comune");
        System.out.println("5. stampa archivio");
    }

    public static int sceltaMenu(Archivio archivioFarmacie) {
        Scanner kbd = new Scanner(System.in);
        int selezione = kbd.nextInt();
        kbd.nextLine();
        Farmacia farmacia = new Farmacia();
        switch (selezione) {
            case 1:
                System.out.println("Inserisci indirizzo: ");
                farmacia.setIndirizzo(kbd.nextLine());
                System.out.println("Inserisci descrizione: ");
                farmacia.setDescrizione(kbd.nextLine());
                System.out.println("Inserisci comune: ");
                farmacia.setComune(kbd.nextLine());
                System.out.println(archivioFarmacie.ricercaSpecifica(farmacia));
                break;
            case 2:
                System.out.println("Inserisci indirizzo: ");
                farmacia.setIndirizzo(kbd.nextLine());
                System.out.println(archivioFarmacie.ricercaIndirizzo(farmacia.getIndirizzo()));
                break;
            case 3:
                System.out.println("Inserisci descrizione: ");
                farmacia.setDescrizione(kbd.nextLine());
                System.out.println(archivioFarmacie.ricercaDescrizione(farmacia.getDescrizione()));
                break;
            case 4:
                System.out.println("Inserisci comune: ");
                farmacia.setComune(kbd.nextLine());
                System.out.println(archivioFarmacie.ricercaComune(farmacia.getComune()));
                break;
            case 5:
                archivioFarmacie.stampaDati();
                break;

            case 0:
                System.out.println("ARRIVEDERCI");
                break;

        }

        return selezione;
    }
}