import java.time.LocalTime;

sealed abstract class Wydarzenie permits Spotkanie, Zadanie{
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    protected static final LocalTime MIN_GODZINA = LocalTime.of(8, 0);

    public Wydarzenie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
    }

    public Wydarzenie() {}

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public LocalTime getCzasPoczatku() {
        return czasPoczatku;
    }

    public void setCzasPoczatku(LocalTime czasPoczatku) {
        this.czasPoczatku = czasPoczatku;
    }

    public LocalTime getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public void setCzasZakonczenia(LocalTime czasZakonczenia) {
        this.czasZakonczenia = czasZakonczenia;
    }

    @Override
    public String toString() {
        return "Wydarzenie{" +
                "opis='" + opis + '\'' +
                ", czasPoczatku=" + czasPoczatku +
                ", czasZakonczenia=" + czasZakonczenia +
                '}';
    }
}
