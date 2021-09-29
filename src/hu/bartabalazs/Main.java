package hu.bartabalazs;

import javax.xml.stream.util.StreamReaderDelegate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void main(String[] args) {

        Random random = new Random();


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


        FajlBeOlvas("bejegyzesek.txt");

        int likeokKiosztasSzama = bejegyzesLista.size()*20;

        for (int i = 0; i < likeokKiosztasSzama; i++) {
            bejegyzesLista.get(random.nextInt(bejegyzesLista.size())).like();
        }

        System.out.println("módosítsa a 2. bejegyzés tartalmát!");
        System.out.println("Add meg a tartalmat!");
        String tartalom = sc.next();
        bejegyzesLista.get(1).setTartalom(tartalom);

        for (int i = 0; i < bejegyzesLista.size(); i++) {
            System.out.println(bejegyzesLista.get(i));
        }

        //3. feladat
        //A
        int legNepszerubbBejegyzesLikeokSzama = bejegyzesLista.get(0).getLikeok();

        for (int i = 1; i < bejegyzesLista.size(); i++) {
            if(bejegyzesLista.get(i).getLikeok()>legNepszerubbBejegyzesLikeokSzama){
                legNepszerubbBejegyzesLikeokSzama = bejegyzesLista.get(i).getLikeok();

            }
        }
        System.out.println("A legnépszerűbb bejegyzés likeainak a száma: "+legNepszerubbBejegyzesLikeokSzama);


        //B
        boolean vanBenne = false;
        int index = 0;
        while (!vanBenne && (index != bejegyzesLista.size())){
            if(bejegyzesLista.get(index).getLikeok()>35){
                vanBenne = true;
            }
            index++;
        }
        if(vanBenne){
            System.out.println("van benne bejegyzés ami 35 likenál többet kapott!");
        } else {
            System.out.println("Nincs benne bejegyzés ami 35 likenál többet kapott!");
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
