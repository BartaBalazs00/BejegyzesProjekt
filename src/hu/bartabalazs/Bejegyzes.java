package hu.bartabalazs;

import java.time.LocalDate;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDate letrejott;
    private LocalDate szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        letrejott = LocalDate.now();
        szerkesztve = LocalDate.now();
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.szerkesztve = LocalDate.now();
        this.tartalom = tartalom;
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDate getLetrejott() {
        return letrejott;
    }

    public LocalDate getSzerkesztve() {
        return szerkesztve;
    }

    public void like(){
        this.likeok++;
    }
}
