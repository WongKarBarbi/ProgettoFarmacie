package server.src;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ServerTCP s = new ServerTCP();
        s.connessioneServer();
        s.Messaggi();

    }




}