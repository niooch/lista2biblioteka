package pl.biblioteka.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.biblioteka.model.Czytelnik;

import static org.junit.jupiter.api.Assertions.*;

class ArchiwumCzytelnikRepoTest {

    private ArchiwumCzytelnikRepo czytelnikRepo;

    @BeforeEach
    void setUp() {
        czytelnikRepo = new ArchiwumCzytelnikRepo();
    }

    @Test
    void testDodajCzytelnika() {
        Czytelnik czytelnik = new Czytelnik(1, "Autor1", "Nazwisko1");
        czytelnikRepo.dodajCzytelnika(czytelnik);
        assertEquals(czytelnik, czytelnikRepo.znajdzCzytelnika(1));
    }

    @Test
    void testGetAllCzytelnicy() {
        Czytelnik czytelnik1 = new Czytelnik(1, "Autor2", "Nazwisko1");
        Czytelnik czytelnik2 = new Czytelnik(2, "Autor1", "Nazwisko2");
        czytelnikRepo.dodajCzytelnika(czytelnik1);
        czytelnikRepo.dodajCzytelnika(czytelnik2);
        assertEquals(2, czytelnikRepo.getAllCzytelnicy().size());
    }

    @Test
    void testZnajdzCzytelnikaNieZnalezniono() {
        assertNull(czytelnikRepo.znajdzCzytelnika(99));
    }
}
