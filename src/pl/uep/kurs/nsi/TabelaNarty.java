package pl.uep.kurs.nsi;

import java.util.ArrayList;

public class TabelaNarty implements IObiektBazodanowy {

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

        Narty produkt1 = new Narty(1, "Nazwa1", 30.46f);
        Narty produkt2 = new Narty(2, "Nazwa2", 40.15f);
        produkty.add(produkt1);
        produkty.add(produkt2);

        return produkty;
    }

    @Override
    public int policzWBazie() {
        return 0;
    }
}
