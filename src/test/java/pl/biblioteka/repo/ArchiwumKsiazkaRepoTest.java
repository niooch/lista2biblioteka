package pl.biblioteka.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.biblioteka.model.Ksiazka;

import static org.junit.jupiter.api.Assertions.*;

class ArchiwumKsiazkaRepoTest {

    private ArchiwumKsiazkaRepo ksiazkaRepo;

    @BeforeEach
    void setUp() {
        ksiazkaRepo = new ArchiwumKsiazkaRepo();
    }

    @Test
    void testDodajKsiazke() {
        Ksiazka ksiazka = new Ksiazka("Ksiazka1", "Autor1");
        ksiazkaRepo.dodajKsiazke("Ksiazka1", ksiazka);
        assertEquals(ksiazka, ksiazkaRepo.znajdzKsiazke("Ksiazka1"));
    }

    @Test
    void testGetAllKsiazki() {
        Ksiazka ksiazka1 = new Ksiazka("Ksiazka2", "Autor2");
        Ksiazka ksiazka2 = new Ksiazka("Ksiazka3", "Autor3");
        ksiazkaRepo.dodajKsiazke("Ksiazka2", ksiazka1);
        ksiazkaRepo.dodajKsiazke("Ksiazka3", ksiazka2);
        assertEquals(2, ksiazkaRepo.getAllKsiazki().size());
    }

    @Test
    void testZnajdzKsiazke_NotFound() {
        assertNull(ksiazkaRepo.znajdzKsiazke("NieistniejacaKsiazka"));
    }
}
