package hu.bartabalazs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Bejegyzes> bejegyzesLista = new ArrayList<>();

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
}
