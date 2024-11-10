package pl.biblioteka.repo;

import pl.biblioteka.model.*;
import java.util.List;
/**
* @Interface KsiazkaRepo
* Interfejs przechowuje informacje o ksiazkach
* KsiazkaRepo posiada metody getAllKsiazki, znajdzKsiazke oraz dodajKsiazke
*/
public interface KsiazkaRepo {
    List<Ksiazka> getAllKsiazki();
    Ksiazka znajdzKsiazke(String tytul);
    void dodajKsiazke(String tytul, Ksiazka ksiazka);
}
