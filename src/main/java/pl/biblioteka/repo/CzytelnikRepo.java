package pl.biblioteka.repo;

import pl.biblioteka.model.*;
import java.util.List;
/**
* @Interface CzytelnikRepo
* Interfejs przechowuje informacje o czytelnikach
* CzytelnikRepo posiada metody dodajCzytelnika, znajdzCzytelnika oraz getAllCzytelnicy
*/
public interface CzytelnikRepo {
    void dodajCzytelnika(Czytelnik czytelnik);
    Czytelnik znajdzCzytelnika(int id);
    List<Czytelnik> getAllCzytelnicy();
}
