# Progetto Farmacie


**Il progetto consiste nell'ideare un programma che gestisca un archivio delle farmacie registrate sul territorio italiano, con la possibilità di compiere ricerche in base a indirizzo, descrizione e comune della farmacia.**


**STRUTTURA PROGETTO**

Al fine di far comunicare due sezioni del programma come client e server, il progetto è stato suddiviso in due package.


    src
    |
    |----client.src
    |
    |----server.src


**PACKAGE CLIENT**

Le classi implementate dal package client sono: Client (a cui è affidata la connessione e lo scambio di messaggio col server ) e il main che esegue i metodi di Client.

    client.src
    |
    |----Client.java
    |
    |----Main.java

**Client.java**

    public void connettiClient(){} //gestisce la connessione iniziale al server
    public void messaggi(){} //gestisce lo scambio di messaggi con il server


**PACKAGE SERVER**

Le classi implementate dal package server sono: Archivio,Farmacia,Main e ServerTCP.


    server.src
    |
    |----Archivio.java
    |
    |----Farmacia.java
    |
    |----Main.java
    |
    |----ServerTCP.java


**Archivio.java**

Archivio opera nella gestione diretta dei dati, andando a eseguire i metodi di importo,ricerca e stampa.

    Attributi:

    private ArrayList <Farmacia> farmacie = new ArrayList<>();


    Metodi:    

    public void importaDati(String fileName){} //importa i dati relativi alle farmacie dal file csv

    public String ricercaSpecifica(Farmacia farmacia){} //esegue una ricerca basata sull'oggetto farmacia

    public String ricercaIndirizzo(String indirizzo){} //esegue una ricerca basata sull'indirizzo richiesto dal client

    public String ricercaDescrizione(String descrizione){} //esegue una ricerca basata sulla descrizione richiesta dal client

    public String ricercaComune(String comune){} //esegue una ricerca basata sul comune richiesto dal client

    public void stampaDati(){} // stampa l'elenco delle farmacie


**Farmacia.java**


    Attributi:

    private String descrizione;

    private String indirizzo;

    private String comune;
    
    Metodi:
    
    getter and setter

    toString

**ServerTCP.java**


    Attributi:
    
    static Archivio archivioFarmacie = new Archivio();

    ServerSocket server = null;

    Socket socketClient = null;

    DataInputStream in ;

    DataOutputStream out;

    final static int portaServer = 2025;

    Metodi:

    public Socket connessioneServer(){}

    public void Messaggi(){}

    public static void sceltaMenu(int scelta){}

    public 
    
