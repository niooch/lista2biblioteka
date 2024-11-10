package pl.biblioteka.serwis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.biblioteka.model.Czytelnik;
import pl.biblioteka.model.Egzemplarz;
import pl.biblioteka.model.Ksiazka;

import static org.junit.jupiter.api.Assertions.*;

class BibliotekaSerwisTest {

    private BibliotekaSerwis bibliotekaSerwis;

    @BeforeEach
    void setUp() {
        bibliotekaSerwis = new BibliotekaSerwis();
    }

    @Test
    void testDodajKsiazke() {
        bibliotekaSerwis.dodajKsiazke("Ksiazka1", "Autor1");
        Ksiazka ksiazka = bibliotekaSerwis.getAllKsiazki().stream()
                                          .filter(k -> "Ksiazka1".equals(k.getTytul()))
                                          .findFirst().orElse(null);
        assertNotNull(ksiazka);
        assertEquals("Autor1", ksiazka.getAutor());
    }

    @Test
    void testDodajCzytelnika() {
        bibliotekaSerwis.dodajCzytelnika("Autor1", "Nazwisko1", 1);
        Czytelnik czytelnik = bibliotekaSerwis.getCzytelnikById(1);
        assertNotNull(czytelnik);
        assertEquals("Autor1", czytelnik.getImie());
    }

    @Test
    void testDodajEgzemplarz() {
        bibliotekaSerwis.dodajKsiazke("Ksiazka1", "Autor1");
        bibliotekaSerwis.dodajEgzemplarz("Ksiazka1", 101);
        Ksiazka ksiazka = bibliotekaSerwis.getAllKsiazki().get(0);
        assertEquals(1, ksiazka.getEgzemplarze().size());
        assertEquals(101, ksiazka.getEgzemplarze().get(0).getId());
    }

    @Test
    void testWypozyczEgzemplarz() {
        bibliotekaSerwis.dodajKsiazke("Ksiazka1", "Autor1");
        bibliotekaSerwis.dodajCzytelnika("Autor2", "Nazwisko1", 2);
        bibliotekaSerwis.dodajEgzemplarz("Ksiazka1", 101);

        bibliotekaSerwis.wypozyczEgzemplarz("Ksiazka1", 101, 2);
        Ksiazka ksiazka = bibliotekaSerwis.getAllKsiazki().get(0);
        Egzemplarz egzemplarz = ksiazka.getEgzemplarze().get(0);

        assertTrue(egzemplarz.isWypozyczony());
        assertEquals(2, egzemplarz.getAktualnyCzytelnik().getId());
    }
}
