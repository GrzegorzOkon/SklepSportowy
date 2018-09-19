package pl.uep.kurs.nsi;

public class Narty {
    private int id;
    private String nazwa;
    private float cena;



    public Narty(String nazwa, float cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Narty(int id, String nazwa, float cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", nazwa: " + nazwa + ", cena: " + cena;
    }
}
