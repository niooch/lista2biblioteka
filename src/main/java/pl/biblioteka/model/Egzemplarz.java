package pl.biblioteka.model;
/**
* @Class Egzemplarz
* Klasa przechowuje informacje o egzemplarzu
* Egzemplarz posiada id, informacje o tym czy jest wypozyczony oraz informacje o aktualnym czytelniku
*/
public class Egzemplarz {
    /**
    * id - identyfikator egzemplarzu
    * wypozyczony - informacja o tym czy egzemplarz jest wypozyczony
    * aktualnyCzytelnik - informacja o aktualnym czytelniku
    */
    private int id;
    private boolean wypozyczony;
    private Czytelnik aktualnyCzytelnik;
    /**
    * Konstruktor klasy Egzemplarz
    * @param id - identyfikator egzemplarzu
    */
    public Egzemplarz(int id) {
        this.id = id;
        this.wypozyczony = false;
        this.aktualnyCzytelnik = null;
    }
    /**
    * Metoda zwraca identyfikator egzemplarzu
    * @return id - identyfikator egzemplarzu
    */
    public int getId() {
        return this.id;
    }
    public boolean isWypozyczony() {
        return this.wypozyczony;
    }
    public Czytelnik getAktualnyCzytelnik() {
        return this.aktualnyCzytelnik;
    }
    public void setWypozyczony(boolean wypozyczony) {
        this.wypozyczony = wypozyczony;
    }
    public void setAktualnyCzytelnik(Czytelnik aktualnyCzytelnik) {
        this.aktualnyCzytelnik = aktualnyCzytelnik;
    }
}
