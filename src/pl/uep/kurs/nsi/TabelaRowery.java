package pl.uep.kurs.nsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TabelaRowery implements IObiektBazodanowy {
    private Connection polaczenie;
    private Rower biezacyProdukt = null;

    public TabelaRowery() throws SQLException {
        polaczenie = BazaDanychSingleton.polaczenie();
    }

    @Override
    public void wyswietl() {
        try {
            String sql = "SELECT id, nazwa, cena FROM rowery WHERE id = ?";
            PreparedStatement zapytanie = polaczenie.prepareStatement(sql);
            zapytanie.setInt(1, biezacyProdukt.getId());

            ResultSet wynik = zapytanie.executeQuery();

            biezacyProdukt = null;

            while (wynik.next()) {
                int id = wynik.getInt("id");
                String nazwa = wynik.getString("nazwa");
                float cena = wynik.getFloat("cena");

                biezacyProdukt = new Rower(id, nazwa, cena);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int dodajDoBazy() {
        try {
            String sql = "INSERT INTO rowery (nazwa, cena) VALUES (?, ?);";
            PreparedStatement wsad = polaczenie.prepareStatement(sql);
            wsad.setString(1, biezacyProdukt.getNazwa());
            wsad.setFloat(2, biezacyProdukt.getCena());

            if (wsad.executeUpdate() == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public int usunZBazy() {
        try {
            String sql = "DELETE FROM rowery WHERE id = ?";
            PreparedStatement wsad = polaczenie.prepareStatement(sql);
            wsad.setInt(1, biezacyProdukt.getId());

            if (wsad.executeUpdate() == 1) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    @Override
    public Iterable wczytajZBazy() {
        ArrayList<Rower> produkty = new ArrayList<>();

        try {
            String sql = "SELECT id, nazwa, cena FROM rowery;";
            PreparedStatement zapytanie = polaczenie.prepareStatement(sql);

            ResultSet wynik = zapytanie.executeQuery();

            while (wynik.next()) {
                int id = wynik.getInt("id");
                String nazwa = wynik.getString("nazwa");
                float cena = wynik.getFloat("cena");

                produkty.add(new Rower(id, nazwa, cena));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produkty;
    }

    @Override
    public int policzWBazie() {
        try {
            String sql = "SELECT count(*) FROM rowery;";
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

    public void ustawBiezacyProdukt(int id) {
        biezacyProdukt = new Rower(id);
    }

    public void ustawBiezacyProdukt(String nazwa, float cena) {
        biezacyProdukt = new Rower(nazwa, cena);
    }

    public Rower pobierzProdukt() {
        return biezacyProdukt;
    }
}
