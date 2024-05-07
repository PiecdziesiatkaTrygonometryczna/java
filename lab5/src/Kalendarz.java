import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private ArrayList<ArrayList<Spotkanie>> dni = new ArrayList<>();

    public Kalendarz() {
        for (int i = 0; i < 7; i++) {
            dni.add(new ArrayList<>());
        }
    }

    public void dodajSpotkanie(int dzien, Spotkanie spotkanie) {
        dni.get(dzien - 1).add(spotkanie);
    }

    public void usunSpotkanie(int dzien, Spotkanie spotkanie) {
        dni.get(dzien - 1).remove(spotkanie);
    }

    public ArrayList<Spotkanie> getDzien(int dzien) {
        return dni.get(dzien - 1);
    }

    public ArrayList<Spotkanie> filtrujSpotkania(int dzien, Predicate<Spotkanie> warunek) {
        ArrayList<Spotkanie> spotkania = new ArrayList<>();
        dni.get(dzien - 1).forEach(spotkanie -> {
            if (warunek.test(spotkanie)) {
                spotkania.add(spotkanie);
            }
        });
        return spotkania;
    }
}
