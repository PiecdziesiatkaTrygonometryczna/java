import java.util.ArrayList;
import java.util.function.Predicate;

public class Kalendarz {
    private ArrayList<ArrayList<Wydarzenie>> dni;

    public Kalendarz() {
        dni = new ArrayList<>(7);
        for (int i = 0; i < 7; i++) {
            dni.add(new ArrayList<>());
        }
    }

    public void dodajWydarzenie(int dzien, Wydarzenie wydarzenie) {
        dni.get(dzien - 1).add(wydarzenie);
    }

    public void usunWydarzenie(int dzien, Wydarzenie wydarzenie) {
        dni.get(dzien - 1).remove(wydarzenie);
    }

    public ArrayList<Wydarzenie> getDzien(int dzien) {
        return dni.get(dzien - 1);
    }

    public ArrayList<Wydarzenie> filtrujWydarzenia(int dzien, Predicate<Wydarzenie> warunek) {
        ArrayList<Wydarzenie> wydarzenia = new ArrayList<>();
        dni.get(dzien - 1).forEach(wydarzenie -> {
            if (warunek.test(wydarzenie)) {
                wydarzenia.add(wydarzenie);
            }
        });
        return wydarzenia;
    }
}
