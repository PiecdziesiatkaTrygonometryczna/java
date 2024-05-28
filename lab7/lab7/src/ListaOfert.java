import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class ListaOfert {
    private ArrayList<Oferta> oferty;

    public ListaOfert() {
        oferty = new ArrayList<>();
    }

    public void dodajOferte(Oferta oferta) {
        oferty.add(oferta);
    }

    public ArrayList<Oferta> filtrujOferty(Predicate<Oferta> predykat) {
        return oferty.stream().filter(predykat).collect(Collectors.toCollection(ArrayList::new));
    }

    public void dodajPrzykladoweOferty() {
        dodajOferte(new Dom("Bażyńskiego", 10, "Gdańsk", "00-001", 120.0, 500000, 300.0, LocalDate.of(2025, 1, 1)));
        dodajOferte(new Dom("Kowalskiego", 20, "Gdańsk", "00-001", 150.0, 600000, 400.0, LocalDate.of(2024, 6, 1)));
        dodajOferte(new Dom("Mickiewicza", 30, "Warszawa", "00-002", 100.0, 450000, 250.0, LocalDate.of(2023, 12, 31)));
        dodajOferte(new Dom("Piłsudskiego", 40, "Warszawa", "00-002", 200.0, 750000, 500.0, LocalDate.of(2024, 5, 1)));
        dodajOferte(new Dom("Jana Pawła II", 50, "Warszawa", "00-002", 180.0, 700000, 350.0, LocalDate.of(2024, 10, 1)));

        dodajOferte(new Mieszkanie("Bażyńskiego", 60, 1, "Gdańsk", "00-001", 60.0, 2, 300000, LocalDate.of(2025, 1, 1)));
        dodajOferte(new Mieszkanie("Kowalskiego", 70, 2, "Gdańsk", "00-001", 45.0, 3, 250000, LocalDate.of(2024, 6, 1)));
        dodajOferte(new Mieszkanie("Warszawska", 80, 3, "Gdańsk", "00-001", 50.0, 4, 270000, LocalDate.of(2023, 12, 31)));
        dodajOferte(new Mieszkanie("Mickiewicza", 90, 4, "Warszawa", "00-002", 55.0, 5, 320000, LocalDate.of(2024, 5, 1)));
        dodajOferte(new Mieszkanie("Piłsudskiego", 100, 5, "Warszawa", "00-002", 40.0, 6, 200000, LocalDate.of(2024, 10, 1)));
        dodajOferte(new Mieszkanie("Jana Pawła II", 110, 6, "Warszawa", "00-002", 70.0, 7, 350000, LocalDate.of(2024, 7, 1)));
        dodajOferte(new Mieszkanie("Gdańska", 120, 7, "Warszawa", "00-002", 80.0, 8, 400000, LocalDate.of(2024, 3, 1)));
    }
}