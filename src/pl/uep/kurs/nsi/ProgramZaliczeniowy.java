package pl.uep.kurs.nsi;

import java.sql.SQLException;
import java.util.*;

public class ProgramZaliczeniowy {
    Scanner skaner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            ProgramZaliczeniowy program = new ProgramZaliczeniowy();

            String[] dostepneProdukty = new String[]{"narty", "rowery", "koniec"};
            String[] dostepneAkcje = new String[]{"wyswietl", "dodaj", "usun", "wczytaj", "policz", "wroc"};

            HashMap<String, IObiektBazodanowy> obiektybazodanowe = new HashMap<String, IObiektBazodanowy>() {{
                put("narty", new TabelaNarty());
                put("rowery", new TabelaRowery());
            }};

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
                String produktUzytkownika = program.skaner.nextLine();

                if (produktUzytkownika.equals("koniec")) {
                    System.out.println("Do widzenia :)");
                    break;
                }

                while (true) {
                    if (Arrays.asList(dostepneProdukty).contains(produktUzytkownika)) {
                        System.out.println("Co chcesz zrobić?");
                        String akcjaUzytkownika = program.skaner.nextLine();

                        if (Arrays.asList(dostepneAkcje).contains(akcjaUzytkownika)) {
                            if (akcjaUzytkownika.equals("wyswietl")) {
                                program.wyswietlProdukt(obiektybazodanowe.get(produktUzytkownika));
                            } else if (akcjaUzytkownika.equals("dodaj")) {
                                program.dodajProdukt(obiektybazodanowe.get(produktUzytkownika));
                            } else if (akcjaUzytkownika.equals("usun")) {
                                System.out.println("Usuwam...");
                            } else if (akcjaUzytkownika.equals("wczytaj")) {
                                program.wylistujProdukty(obiektybazodanowe.get(produktUzytkownika));
                            } else if (akcjaUzytkownika.equals("policz")) {
                                program.zliczProdukty(obiektybazodanowe.get(produktUzytkownika));
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

    private void wyswietlProdukt(IObiektBazodanowy obiektBazodanowy) {
        try {
            System.out.println("Ktory produkt chcesz wyswietlic? Podaj ID");
            int id = skaner.nextInt();
            skaner.nextLine();

            if (obiektBazodanowy instanceof TabelaNarty) {
                ((TabelaNarty)obiektBazodanowy).ustawBiezacyProdukt(id);
                ((TabelaNarty)obiektBazodanowy).wyswietl();
                Narty produkt = ((TabelaNarty)obiektBazodanowy).pobierzProdukt();
                if (produkt != null) {
                    System.out.println(produkt);
                }
            } else if (obiektBazodanowy instanceof TabelaRowery) {

            }
        } catch (InputMismatchException e) {
            System.out.println("Nieprawdlowy parametr. Sprobuj jeszcze raz.");
        }
    }

    private void dodajProdukt(IObiektBazodanowy obiektBazodanowy) {
        try {
            System.out.println("Jak nazywa się nowy produkt:");
            String nazwa = skaner.nextLine();
            System.out.println("Jaką ma mieć cenę:");
            float cena = skaner.nextFloat();
            skaner.nextLine();

            if (obiektBazodanowy instanceof TabelaNarty) {
                ((TabelaNarty)obiektBazodanowy).ustawBiezacyProdukt(nazwa, cena);
                int dodanaIlosc = ((TabelaNarty)obiektBazodanowy).dodajDoBazy();

                System.out.println("Dodana ilość produktów: " + dodanaIlosc);
            } else if (obiektBazodanowy instanceof TabelaRowery) {

            }
        } catch (InputMismatchException e) {
            System.out.println("Nieprawidłowe dane!!!");
        }
    }

    private void wylistujProdukty(IObiektBazodanowy obiektBazodanowy) {
        ArrayList<Object> produkty = (ArrayList)obiektBazodanowy.wczytajZBazy();

        for(Object produkt : produkty) {
            System.out.println(produkt);
        }
    }

    private void zliczProdukty(IObiektBazodanowy obiektBazodanowy) {
        int ilosc = obiektBazodanowy.policzWBazie();

        if (ilosc != -1) {
            System.out.println("Ilość w bazie: " + ilosc);
        }
    }
}