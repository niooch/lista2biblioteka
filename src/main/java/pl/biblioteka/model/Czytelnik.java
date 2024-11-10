package pl.biblioteka.model;

import java.util.ArrayList;
import java.util.List;
/**
* @Class Czytelnik
* Klasa przechowuje informacje o czytelniku
* Czytelnik posiada id, imie, nazwisko oraz liste wypozyczonych egzemplarzy
*/
public class Czytelnik {
    /**
    * id - identyfikator czytelnika
    * imie - imie czytelnika
    * nazwisko - nazwisko czytelnika
    * wypozyczoneEgzemplarze - lista wypozyczonych egzemplarzy
    */
    private int id;
    private String imie;
    private String nazwisko;
    private List<Egzemplarz> wypozyczoneEgzemplarze = new ArrayList<Egzemplarz>();
    /**
    * Konstruktor klasy Czytelnik
    * @param id - identyfikator czytelnika
    * @param imie - imie czytelnika
    * @param nazwisko - nazwisko czytelnika
    */
    public Czytelnik(int id, String imie, String nazwisko) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wypozyczoneEgzemplarze = new ArrayList<Egzemplarz>();
    }
    /**
    * Metoda dodaje egzemplarz do listy wypozyczonych egzemplarzy
    * @param egzemplarz - egzemplarz do wypozyczenia
    */
    public void wypozyczEgzemplarz(Egzemplarz egzemplarz) {
        wypozyczoneEgzemplarze.add(egzemplarz);
    }

    public int getId() {
        return id;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public List<Egzemplarz> getWypozyczoneEgzemplarze() {
        return wypozyczoneEgzemplarze;
    }
}
