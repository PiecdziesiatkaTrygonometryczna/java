import java.time.LocalTime;

final class Spotkanie extends Wydarzenie {
    private int priorytet;

    public Spotkanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, int priorytet) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.priorytet = priorytet;
    }

    public Spotkanie() {}

    public int getPriorytet() {
        return priorytet;
    }

    public void setPriorytet(int priorytet) {
        this.priorytet = priorytet;
    }

    @Override
    public String toString() {
        return "Spotkanie{" +
                "opis='" + getOpis() + '\'' +
                ", czasPoczatku=" + getCzasPoczatku() +
                ", czasZakonczenia=" + getCzasZakonczenia() +
                ", priorytet=" + priorytet +
                '}';
    }
}
