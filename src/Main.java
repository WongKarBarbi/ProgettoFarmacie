import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Archivio archivioFarmacie = new Archivio();
        archivioFarmacie.importaDati("Anagrafe-delle-farmacie-italiane.csv");
        archivioFarmacie.stampaDati();
    }
}