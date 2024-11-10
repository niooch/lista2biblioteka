package pl.biblioteka.serwis;

import pl.biblioteka.model.*;
import pl.biblioteka.repo.*;
import java.util.List;
/**
* @Class BibliotekaSerwis
* Klasa przechowuje informacje o ksiazkach, czytelnikach oraz egzemplarzach
* BibliotekaSerwis posiada metody dodajKsiazke, dodajCzytelnika, dodajEgzemplarz, wypozyczEgzemplarz, getAllKsiazki, getAllCzytelnicy oraz getCzytelnikById
*/
public class BibliotekaSerwis {
    /**
    * @param ksiazkaRepo - repozytorium ksiazek
    * @param czytelnikRepo - repozytorium czytelnikow
    */
    private final KsiazkaRepo ksiazkaRepo;
    private final CzytelnikRepo czytelnikRepo;
    /**
    * Konstruktor BibliotekaSerwis
    * Tworzy nowe repozytorium ksiazek oraz czytelnikow
    */
    public BibliotekaSerwis() {
        this.ksiazkaRepo = new ArchiwumKsiazkaRepo();
        this.czytelnikRepo = new ArchiwumCzytelnikRepo();
    }
    /**
    * Metoda dodajKsiazke
    * Dodaje ksiazke do repozytorium ksiazek
    * @param tytul - tytul ksiazki
    * @param autor - autor ksiazki
    */
    public void dodajKsiazke(String tytul, String autor) {
        Ksiazka ksiazka = new Ksiazka(tytul, autor);
        ksiazkaRepo.dodajKsiazke(tytul, ksiazka);
    }
    /**
    * Metoda dodajCzytelnika
    * Dodaje czytelnika do repozytorium czytelnikow
    * @param imie - imie czytelnika
    * @param nazwisko - nazwisko czytelnika
    * @param id - identyfikator czytelnika
    */
    public void dodajCzytelnika(String imie, String nazwisko, int id) {
        Czytelnik czytelnik = new Czytelnik(id, imie, nazwisko);
        czytelnikRepo.dodajCzytelnika(czytelnik);
    }
    /**
    * Metoda dodajEgzemplarz
    * Dodaje egzemplarz do ksiazki
    * @param tytul - tytul ksiazki
    * @param id - identyfikator egzemplarza
    */
    public void dodajEgzemplarz(String tytul, int id) {
        Ksiazka ksiazka = ksiazkaRepo.znajdzKsiazke(tytul);
        if (ksiazka != null) {
            Egzemplarz egzemplarz = new Egzemplarz(id);
            ksiazka.dodajEgzemplarz(egzemplarz);
        }
        else {
            System.out.println("Nie ma takiej ksiazki");
        }
    }
    /**
    * Metoda wypozyczEgzemplarz
    * Wypozycza egzemplarz czytelnikowi
    * @param tytul - tytul ksiazki
    * @param idEgzemplarza - identyfikator egzemplarza
    * @param idCzytelnika - identyfikator czytelnika
    */
    public void wypozyczEgzemplarz(String tytul, int idEgzemplarza, int idCzytelnika) {
        Ksiazka ksiazka = ksiazkaRepo.znajdzKsiazke(tytul);
        Czytelnik czytelnik = czytelnikRepo.znajdzCzytelnika(idCzytelnika);

        if (ksiazka != null && czytelnik != null) {
            for (Egzemplarz egzemplarz : ksiazka.getEgzemplarze()) {
                if (egzemplarz.getId() == idEgzemplarza && !egzemplarz.isWypozyczony()) {
                    egzemplarz.setWypozyczony(true);
                    egzemplarz.setAktualnyCzytelnik(czytelnik);
                    czytelnik.wypozyczEgzemplarz(egzemplarz);
                    System.out.println("Wypozyczono egzemplarz");
                    return;
                }
                else {
                    System.out.println("Nie ma takiego egzemplarza");
                }
            }
        }
        else {
            System.out.println("Ksiazka lub egzemplarz nie istnieje");
        }
    }
    /**
    * Metoda getAllKsiazki
    * Zwraca liste ksiazek
    * @return lista ksiazek
    */
    public List<Ksiazka> getAllKsiazki() {
        return ksiazkaRepo.getAllKsiazki();
    }
    /**
    * Metoda getAllCzytelnicy.
    * Zwraca liste czytelnikow
    * @return lista czytelnikow
    */
    public List<Czytelnik> getAllCzytelnicy() {
        return czytelnikRepo.getAllCzytelnicy();
    }
    /**
    * Metoda getCzytelnikById.
    * Zwraca czytelnika o podanym identyfikatorze
    * @param id - identyfikator czytelnika
    * @return czytelnik
    */
    public Czytelnik getCzytelnikById(int id) {
        return czytelnikRepo.znajdzCzytelnika(id);
    }
}
