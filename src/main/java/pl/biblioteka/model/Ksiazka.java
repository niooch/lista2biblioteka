package pl.biblioteka.model;

import java.util.ArrayList;
import java.util.List;
/**
* @Class Ksiazka
* Klasa przechowuje informacje o ksiazce
* Ksiazka posiada tytul, autora oraz liste egzemplarzy
*/
public class Ksiazka {
    /**
    * tytul - tytul ksiazki
    * autor - autor ksiazki
    * egzemplarze - lista egzemplarzy ksiazki
    */
    private String tytul;
    private String autor;
    private List<Egzemplarz> egzemplarze;
    /**
    * Konstruktor klasy Ksiazka
    * @param tytul - tytul ksiazki
    * @param autor - autor ksiazki
    */
    public Ksiazka(String tytul, String autor) {
        this.tytul = tytul;
        this.autor = autor;
        this.egzemplarze = new ArrayList<>();
    }
    /**
    * Metoda zwraca tytul ksiazki
    * @return tytul - tytul ksiazki
    */
    public String getTytul() {
        return tytul;
    }
    public String getAutor() {
        return autor;
    }
    public List<Egzemplarz> getEgzemplarze() {
        return egzemplarze;
    }
    /**
    * Metoda dodaje egzemplarz do listy egzemplarzy ksiazki
    * @param egzemplarz - egzemplarz do dodania
    */
    public void dodajEgzemplarz(Egzemplarz egzemplarz) {
        egzemplarze.add(egzemplarz);
    }
}
