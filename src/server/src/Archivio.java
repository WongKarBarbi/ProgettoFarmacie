package server.src;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivio {

    //private int lunghezza;
    private ArrayList <Farmacia> farmacie = new ArrayList<>();

    public Archivio() {
    }


    //metoodo di importo
    public void importaDati(String fileName) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String riga;
            while((riga = br.readLine()) != null){
                String [] info = riga.split(";");
                if(info[0].equalsIgnoreCase("")){

                    String indirizzo = "non disponibile";
                    String descrizione = info[1].trim();
                    String comune = info[2].trim();

                    Farmacia farmacia = new Farmacia(descrizione,indirizzo,comune);
                    farmacie.add(farmacia);
                    //lunghezza++;
                }else{
                    String indirizzo = info[0].trim();
                    String descrizione = info[1].trim();
                    String comune = info[2].trim();

                    Farmacia farmacia = new Farmacia(descrizione,indirizzo,comune);
                    farmacie.add(farmacia);
                    //lunghezza++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //metodo di ricerca
    public String ricercaSpecifica(Farmacia farmacia){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f == farmacia){ elencoFarmacie += f.toString()+ "\n";}
        }
        return elencoFarmacie;
    }
    public String ricercaIndirizzo(String indirizzo){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getIndirizzo().equalsIgnoreCase(indirizzo)){ elencoFarmacie+=f.toString()+ "\n";}
        }
        return elencoFarmacie;
    }

    public String ricercaDescrizione(String descrizione){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getDescrizione().equalsIgnoreCase(descrizione)){ elencoFarmacie+=f.toString() + "\n";}
        }
        return elencoFarmacie;
    }

    public String ricercaComune(String comune){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getComune().equalsIgnoreCase(comune)){ elencoFarmacie+=f.toString()+ "\n";}
        }
        return elencoFarmacie;
    }


    //metodo di stampa
    public String stampaDati(){
        String stampaFarmacie = "";
        for(int i = 0; i<farmacie.size();i++){
            stampaFarmacie += farmacie.get(i).toString() +"\n";
        }
        return stampaFarmacie;
    }

    /*
    public void stampaLunghezza(){
        System.out.println(lunghezza);
    }

     */
}
