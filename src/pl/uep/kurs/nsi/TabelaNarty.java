package pl.uep.kurs.nsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TabelaNarty implements IObiektBazodanowy {
    private Connection polaczenie;
    private int biezaceId = 0;
    private Narty biezacyProdukt = null;

    public TabelaNarty() throws SQLException {
        polaczenie = BazaDanychSingleton.polaczenie();
    }

    @Override
    public void wyswietl() {
        try {
            String sql = "SELECT id, nazwa, cena FROM narty WHERE id = ?";
            PreparedStatement zapytanie = polaczenie.prepareStatement(sql);
            zapytanie.setInt(1, biezaceId);

            ResultSet wynik = zapytanie.executeQuery();

            biezacyProdukt = null;

            while (wynik.next()) {
                int id = wynik.getInt("id");
                String nazwa = wynik.getString("nazwa");
                float cena = wynik.getFloat("cena");

                biezacyProdukt = new Narty(id, nazwa, cena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int dodajDoBazy() {
        return 0;
    }

    @Override
    public int usunZBazy() {
        return 0;
    }

    @Override
    public Iterable wczytajZBazy() {
        ArrayList<Narty> produkty = new ArrayList<>();

        try {
            String sql = "SELECT id, nazwa, cena FROM narty;";
            PreparedStatement zapytanie = polaczenie.prepareStatement(sql);

            ResultSet wynik = zapytanie.executeQuery();

            while (wynik.next()) {
                int id = wynik.getInt("id");
                String nazwa = wynik.getString("nazwa");
                float cena = wynik.getFloat("cena");

                produkty.add(new Narty(id, nazwa, cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkty;
    }

    @Override
    public int policzWBazie() {
        try {
            String sql = "SELECT count(*) FROM narty;";
            PreparedStatement zapytanie = polaczenie.prepareStatement(sql);

            ResultSet wynik = zapytanie.executeQuery();

            while (wynik.next()) {
                int ilosc = wynik.getInt(1);

                return ilosc;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return -1;
    }

    public void ustawBiezaceId(int id) {
        biezaceId = id;
    }

    public Narty pobierzProdukt() {
        return biezacyProdukt;
    }
}