import java.time.LocalDate;

abstract class Oferta {
    private String ulica;
    private int numerDomu;
    private String miejscowosc;
    private String kodPocztowy;
    private double powierzchnia;
    private int cena;
    private LocalDate dataObowiazywaniaOferty;

    public Oferta(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia,
                  int cena, LocalDate dataObowiazywaniaOferty) {
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miejscowosc = miejscowosc;
        this.kodPocztowy = kodPocztowy;
        this.powierzchnia = powierzchnia;
        this.cena = cena;
        this.dataObowiazywaniaOferty = dataObowiazywaniaOferty;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public double getCena() {
        return cena;
    }

    public LocalDate getDataObowiazywaniaOferty() {
        return dataObowiazywaniaOferty;
    }

    @Override
    public String toString() {
        return "Ulica: " + ulica + ", Numer domu: " + numerDomu + ", Miejscowość: " + miejscowosc + ", Kod pocztowy: "
                + kodPocztowy + ", Powierzchnia: " + powierzchnia + "m², Cena: " + cena + " PLN, Data obowiązywania oferty: " + dataObowiazywaniaOferty;
    }
}