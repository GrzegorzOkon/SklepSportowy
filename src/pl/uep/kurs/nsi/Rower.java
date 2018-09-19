package pl.uep.kurs.nsi;

public class Rower {
    private int id;
    private String nazwa;
    private float cena;

    public Rower(int id) {
        this.id = id;
    }

    public Rower(String nazwa, float cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Rower(int id, String nazwa, float cena) {
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
