package pl.uep.kurs.nsi;

import java.util.Arrays;
import java.util.Scanner;

public class ProgramZaliczeniowy {
    public static void main(String[] args) {

        //HashMap<String, IObiektBazodanowy>
        
        String[] dostepneProdukty = new String[]{"narty", "rowery"};
        String[] dostepneAkcje = new String[]{"wyswietl", "dodaj", "usun", "wczytaj", "policz", "wroc"};

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
                    if (produktUzytkownika.equals("narty")) {
                        System.out.println("Co chcesz zrobić?");
                        String akcjaUzytkownika = skaner.nextLine();

                        if (Arrays.asList(dostepneAkcje).contains(akcjaUzytkownika)) {
                            if (akcjaUzytkownika.equals("wyswietl")) {
                                System.out.println("Wywietlam...");
                            }
                            if (akcjaUzytkownika.equals("dodaj")) {
                                System.out.println("Dodaje...");
                            }
                            if (akcjaUzytkownika.equals("usun")) {
                                System.out.println("Usuwam...");
                            }
                            if (akcjaUzytkownika.equals("wczytaj")) {
                                System.out.println("Wczytuje...");
                            }
                            if (akcjaUzytkownika.equals("policz")) {
                                System.out.println("Licze...");
                            }
                            if (akcjaUzytkownika.equals("wroc")) {
                                break;
                            }
                        } else {
                            System.out.println(akcjaUzytkownika);
                            if (!akcjaUzytkownika.equals("")) {
                                System.out.println("Akcja niedozwolona, sproboj jeszcze raz.");
                            }
                        }
                    } else if (produktUzytkownika.equals("rowery")) {

                    }
                } else {
                    System.out.println(produktUzytkownika);
                    if (!produktUzytkownika.equals("")) {
                        System.out.println("Dzial nie wystepuje, sproboj jeszcze raz.");
                    }
                }
            }
        }
    }
}
