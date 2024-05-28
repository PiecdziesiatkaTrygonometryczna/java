import java.time.LocalDate;

final class Dom extends Oferta {
    private double powierzchniaDzialki;

    public Dom(String ulica, int numerDomu, String miejscowosc, String kodPocztowy, double powierzchnia,
               int cena, double powierzchniaDzialki, LocalDate dataObowiazywaniaOferty) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.powierzchniaDzialki = powierzchniaDzialki;
    }

    @Override
    public String toString() {
        return "Dom: " + super.toString() + ", Powierzchnia działki: " + powierzchniaDzialki + "m²";
    }
}