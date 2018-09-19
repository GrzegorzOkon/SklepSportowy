package pl.uep.kurs.nsi;

public interface IObiektBazodanowy {

    /**
     * Wyświetlanie obiektu w linii komend / konsoli
     */
    public void wyswietl();

    /**
     * Dodanie nowego obiektu do bazy danych i podanie nowej liczby obiektów
     * @return
     */
    public int dodajDoBazy();

    /**
     * Usunięcie elementu z bazy danych i podanie liczby pozostałych elementów
     * @return
     */
    public int usunZBazy();

    /**
     * Wczytanie listy obiektów z bazy danych. Metoda moze zwrocic
     * dowolna kolekcje, ktora implementuje interfejs Iterable
     * taka jak ArrayList czy LinkedList
     * @return
     */
    public Iterable wczytajZBazy();

    /**
     *
     * @return liczba obiektów w bazie danych
     */
    public int policzWBazie();
}
