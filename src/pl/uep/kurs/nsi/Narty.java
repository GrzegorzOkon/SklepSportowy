package pl.uep.kurs.nsi;

public class Narty {
    private int id;
    private String nazwa;
    private float cena;

    public Narty(int id) {
        this.id = id;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
}
