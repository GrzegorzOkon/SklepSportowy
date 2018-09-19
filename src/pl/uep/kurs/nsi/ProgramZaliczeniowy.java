package pl.uep.kurs.nsi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ProgramZaliczeniowy {
    public static void main(String[] args) {
        try {
            ProgramZaliczeniowy program = new ProgramZaliczeniowy();

            String[] dostepneProdukty = new String[]{"narty", "rowery"};
            String[] dostepneAkcje = new String[]{"wyswietl", "dodaj", "usun", "wczytaj", "policz", "wroc"};

            HashMap<String, IObiektBazodanowy> obiektybazodanowe = new HashMap<String, IObiektBazodanowy>() {{
                put("narty", new TabelaNarty());
                put("rowery", new TabelaRowery());
            }};

            Scanner skaner = new Scanner(System.in);

            System.out.println("Witamy w wirtualnym sklepie sportowym. Dostepne produkty:");
            for (String dzial : dostepneProdukty) {
                System.out.println(dzial);
            }

            System.out.println("\nDostepne akcje:");
            for (String akcja : dostepneAkcje) {
                System.out.println(akcja);
            }

            while (true) {
                System.out.println("\nCo Ciebie interesuje?");
                String produktUzytkownika = skaner.nextLine();

                while (true) {
                    if (Arrays.asList(dostepneProdukty).contains(produktUzytkownika)) {
                        System.out.println("Co chcesz zrobić?");
                        String akcjaUzytkownika = skaner.nextLine();

                        if (Arrays.asList(dostepneAkcje).contains(akcjaUzytkownika)) {
                            if (akcjaUzytkownika.equals("wyswietl")) {
                                System.out.println("Wywietlam...");
                            } else if (akcjaUzytkownika.equals("dodaj")) {
                                System.out.println("Dodaje...");
                            } else if (akcjaUzytkownika.equals("usun")) {
                                System.out.println("Usuwam...");
                            } else if (akcjaUzytkownika.equals("wczytaj")) {
                                program.wylistujProdukty(obiektybazodanowe.get(produktUzytkownika));
                            } else if (akcjaUzytkownika.equals("policz")) {
                                System.out.println("Licze...");
                            } else if (akcjaUzytkownika.equals("wroc")) {
                                break;
                            }
                        } else {
                            System.out.println(akcjaUzytkownika);
                            if (!akcjaUzytkownika.equals("")) {
                                System.out.println("Akcja niedozwolona, sproboj jeszcze raz.");
                            }
                        }
                    } else {
                        System.out.println(produktUzytkownika);
                        if (!produktUzytkownika.equals("")) {
                            System.out.println("Dzial nie wystepuje, sproboj jeszcze raz.");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void wylistujProdukty(IObiektBazodanowy obiektBazodanowy) {
        ArrayList<Object> produkty = (ArrayList)obiektBazodanowy.wczytajZBazy();

        for(Object produkt : produkty) {
            System.out.println(produkt.toString());
        }
    }
}

        /*for(Object produkt : produkty) {
            if (produkt instanceof Narty) {
                System.out.println(produkt.toString());
            } else if (produkt instanceof Rower) {

            }
        }*/