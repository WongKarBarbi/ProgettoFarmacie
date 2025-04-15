import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivio {

    private int lunghezza;
    private ArrayList <Farmacia> farmacie = new ArrayList<>();

    public Archivio() {
    }


    //metoodo di importo
    public void importaDati(String fileName) throws FileNotFoundException {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String riga;
            while((riga = br.readLine()) != null){
                String [] info = riga.split(";");
                if(info[0] == ""){

                    String indirizzo = "non disponibile";
                    String descrizione = info[1].trim();
                    String comune = info[2].trim();

                    Farmacia farmacia = new Farmacia(descrizione,indirizzo,comune);
                    farmacie.add(farmacia);
                    lunghezza++;
                }else{
                    String indirizzo = info[0].trim();
                    String descrizione = info[1].trim();
                    String comune = info[2].trim();

                    Farmacia farmacia = new Farmacia(descrizione,indirizzo,comune);
                    farmacie.add(farmacia);
                    lunghezza++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sceltaRicerca(int selezione,Farmacia farmacia){
        switch(selezione){
            case 1:
                ricercaSpecifica(farmacia);
                break;
            case 2:
                ricercaIndirizzo(farmacia.getIndirizzo());
                break;
            case 3:
                ricercaNome(farmacia.getDescrizione());
                break;
            case 4:
                ricercaCittà(farmacia.getComune());
                break;
        }
    }


    //metodo di ricerca
    public String ricercaSpecifica(Farmacia farmacia){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f == farmacia){ elencoFarmacie += f.toString();}
        }
        return elencoFarmacie;

    }
    public String ricercaIndirizzo(String indirizzo){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getIndirizzo().equals(indirizzo)){ elencoFarmacie+=f.toString();}
        }
        return elencoFarmacie;
    }

    public String ricercaNome(String nome){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getIndirizzo().equals(nome)){ elencoFarmacie+=f.toString();}
        }
        return elencoFarmacie;
    }

    public String ricercaCittà(String città){
        String elencoFarmacie ="";
        for(Farmacia f : farmacie){
            if(f.getIndirizzo().equals(città)){ elencoFarmacie+=f.toString();}
        }
        return elencoFarmacie;

    }


    //metodo di stampa

    public void stampaDati(){

        for(int i = 0; i<farmacie.size();i++){
            System.out.println(farmacie.get(i).toString());
        }
    }

    public void stampaLunghezza(){
        System.out.println(lunghezza);
    }
}
