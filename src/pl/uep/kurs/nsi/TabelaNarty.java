package pl.uep.kurs.nsi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TabelaNarty implements IObiektBazodanowy {
    private Connection polaczenie;

    public TabelaNarty() throws SQLException {
        polaczenie = BazaDanychSingleton.polaczenie();
    }

    @Override
    public void wyswietl() {

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
        return 0;
    }
}
