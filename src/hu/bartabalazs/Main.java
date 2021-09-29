package hu.bartabalazs;

import javax.xml.stream.util.StreamReaderDelegate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void main(String[] args) {



        Bejegyzes b1 = new Bejegyzes("Barta Balázs", "tartalom");
        Bejegyzes b2 = new Bejegyzes("Beviz Elek", "Még több tartalom");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);
        Scanner sc = new Scanner(System.in);

        System.out.println("adj meg egy darabszámot!");
        int darabSzam= sc.nextInt();
        for (int i = 0; i < darabSzam; i++) {
            System.out.println("Add meg a(z) "+(i+1) + " bejegyzés szerzőjét!");
            String szerzo = sc.next();
            System.out.println("Add meg a(z)" +(i+1) + " bejegyzés tartalmát!");
            String tartalom = sc.next();
            Bejegyzes bekertBejegyzes = new Bejegyzes(szerzo, tartalom);
            bejegyzesLista.add(bekertBejegyzes);
        }

    }
    public static void FajlBeOlvas(String fajlNev){
        try {
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null){
                String[] adatok = sor.split(";");
                Bejegyzes faljBejegyzes = new Bejegyzes(adatok[0],adatok[1]);
                bejegyzesLista.add(faljBejegyzes);
                sor = br.readLine();
            }
            fr.close();
            br.close();

        } catch (IOException io){
            System.out.println(io.getMessage());
        }
    }
}
