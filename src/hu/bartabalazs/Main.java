package hu.bartabalazs;

import javax.xml.stream.util.StreamReaderDelegate;
import java.io.*;
import java.util.*;

public class Main {

    static List<Bejegyzes> bejegyzesLista = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

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

        for (Bejegyzes value : bejegyzesLista) {
            System.out.println(value+"\n");
        }


        //3. feladat
        //A
        System.out.println("\nA feladat");
        int legNepszerubbBejegyzesLikeokSzama = bejegyzesLista.get(0).getLikeok();

        for (int i = 1; i < bejegyzesLista.size(); i++) {
            if(bejegyzesLista.get(i).getLikeok()>legNepszerubbBejegyzesLikeokSzama){
                legNepszerubbBejegyzesLikeokSzama = bejegyzesLista.get(i).getLikeok();

            }
        }
        System.out.println("A legnépszerűbb bejegyzés likeainak a száma: "+legNepszerubbBejegyzesLikeokSzama);



        //B
        System.out.println("\nB feladat");
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



        //C
        System.out.println("\nC feladat");
        int kevesebbMintTizenotDb = 0;
        for (Bejegyzes bejegyzes : bejegyzesLista) {
            if (bejegyzes.getLikeok() < 15) {
                kevesebbMintTizenotDb++;
            }
        }
        System.out.println(kevesebbMintTizenotDb +" db bejegyzés kapott kevesebb mint 15 likeot");


        //D
        System.out.println("\nD feladat");

        Bejegyzes csereBejegyzes = new Bejegyzes("","");
/*
        Arrays.sort(bejegyzesLista, new Comparator<>());
        for (int i = 0; i < bejegyzesLista.size()-1; i++) {
            for (int j = i+1; j < bejegyzesLista.size(); j++) {
                if(bejegyzesLista.get(j).getLikeok()>bejegyzesLista.get(i).getLikeok()){
                    csereBejegyzes = bejegyzesLista.get(j);
                    bejegyzesLista.get(j) = bejegyzesLista.get(i);
                    bejegyzesLista.get(i) = csereBejegyzes;
                }
            }
        }
*/
        FajlKiIras("bejegyzesek_rendezett.txt");
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

    public static void FajlKiIras(String fajlNev) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter(fajlNev, "UTF-8");
        for (Bejegyzes bejegyzes: bejegyzesLista
             ) {
            writer.println(bejegyzes);
        }
        writer.close();
    }

}
