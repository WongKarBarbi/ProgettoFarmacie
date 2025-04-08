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


    //metodo di filtraggio
    public void filtraIndirizzo(){}

    public void filtraNome(){}

    public void filtraCittà(){}



    //metodo di ricerca
    public void ricercaIndirizzo(){}

    public void ricercaNome(){}

    public void ricercaCittà(){}


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
