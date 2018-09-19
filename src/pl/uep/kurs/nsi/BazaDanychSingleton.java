package pl.uep.kurs.nsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BazaDanychSingleton {
    private static Connection polaczenie;

    private static String bazaDanych = "produkty";
    private static String uzytkownik = "root";
    private static String haslo = "root";
    private static String url = "jdbc:mysql://localhost:3306/" + bazaDanych + "?useSSL=false&serverTimezone=UTC&verifyServerCertificate=false&allowPublicKeyRetrieval=true";

    public static Connection polaczenie() throws SQLException {
        if (polaczenie != null) {
            return polaczenie;
        }
        polaczenie = DriverManager.getConnection(url, uzytkownik, haslo);

        return polaczenie;
    }

}
