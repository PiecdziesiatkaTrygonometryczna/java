import java.time.LocalTime;

public class Spotkanie {
    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, int priorytet) {
        this.opis = opis;
        this.czasPoczatku = czasPoczatku;
        this.czasZakonczenia = czasZakonczenia;
        this.priorytet = priorytet;
    }

    public Spotkanie() {
    }



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

    public int getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }
    private String opis;
    private LocalTime czasPoczatku;
    private LocalTime czasZakonczenia;
    private int priorytet;
    public static final LocalTime minGodzina = LocalTime.of(8, 0);
}
