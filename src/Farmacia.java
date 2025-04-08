public class Farmacia {
    private String descrizione;
    private String indirizzo;
    private String comune;

    public Farmacia(String descrizione, String indirizzo, String comune) {
        this.descrizione = descrizione;
        this.indirizzo = indirizzo;
        this.comune = comune;
    }


    public String getDescrizione(){return descrizione;}

    public void setDescrizione(String nome) {
        this.descrizione = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public String getComune() {
        return comune;
    }

    public void setComune(String città) {
        this.comune = città;
    }


    @Override
    public String toString() {
        return "Farmacia{" +
                "descrizione='" + descrizione + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", comune='" + comune + '\'' +
                '}';
    }
}
