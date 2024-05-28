import java.time.LocalDate;
final class Mieszkanie extends Oferta {
    private int numerMieszkania;
    private int numerPietra;

    public int getNumerMieszkania() {
        return numerMieszkania;
    }

    public int getNumerPietra() {
        return numerPietra;
    }

    public Mieszkanie(String ulica, int numerDomu, int numerMieszkania, String miejscowosc, String kodPocztowy, double powierzchnia, int numerPietra, int cena, LocalDate dataObowiazywaniaOferty) {
        super(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, dataObowiazywaniaOferty);
        this.numerMieszkania = numerMieszkania;
        this.numerPietra = numerPietra;
    }

    @Override
    public String toString() {
        return "Mieszkanie: " + super.toString() + ", Numer mieszkania: " + numerMieszkania + ", Numer piętra: " + numerPietra;
    }
}