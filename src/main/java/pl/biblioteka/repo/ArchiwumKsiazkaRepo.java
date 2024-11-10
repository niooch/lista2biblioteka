package pl.biblioteka.repo;

import pl.biblioteka.model.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
* @Class ArchiwumKsiazkaRepo
* Klasa przechowuje informacje o ksiazkach
* ArchiwumKsiazkaRepo posiada liste ksiazek
*/
public class ArchiwumKsiazkaRepo implements KsiazkaRepo {

    private Map<String, Ksiazka> ksiazki = new HashMap<>();

    @Override
    public void dodajKsiazke(String tytul, Ksiazka ksiazka) {
        ksiazki.put(tytul, ksiazka);
    }
    @Override
    public List<Ksiazka> getAllKsiazki() {
        return new ArrayList<>(ksiazki.values());
    }
    @Override
    public Ksiazka znajdzKsiazke(String tytul) {
        return ksiazki.get(tytul);
    }
}
