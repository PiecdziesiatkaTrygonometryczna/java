import java.util.ArrayList;

public class Kalendarz {
    public Kalendarz() {
    }

    public Kalendarz(ArrayList<Spotkanie> poniedzialek, ArrayList<Spotkanie> wtorek, ArrayList<Spotkanie> sroda,
                     ArrayList<Spotkanie> czwartek, ArrayList<Spotkanie> piatek, ArrayList<Spotkanie> sobota,
                     ArrayList<Spotkanie> niedziela) {
        this.poniedzialek = poniedzialek;
        this.wtorek = wtorek;
        this.sroda = sroda;
        this.czwartek = czwartek;
        this.piatek = piatek;
        this.sobota = sobota;
        this.niedziela = niedziela;
    }

    public ArrayList<Spotkanie> spotkaniaZPriorytetem(ArrayList<Spotkanie> dzien, int priorytet) {
        ArrayList<Spotkanie> spotkania = new ArrayList<>();

        for (Spotkanie spotkanie : dzien) {
            if (spotkanie.getPriorytet() == priorytet) {
                spotkania.add(spotkanie);
            }
        }

        return spotkania;
    }

    private ArrayList<Spotkanie> poniedzialek = new ArrayList<>();
    private ArrayList<Spotkanie> wtorek = new ArrayList<>();
    private ArrayList<Spotkanie> sroda = new ArrayList<>();
    private ArrayList<Spotkanie> czwartek = new ArrayList<>();
    private ArrayList<Spotkanie> piatek = new ArrayList<>();
    private ArrayList<Spotkanie> sobota = new ArrayList<>();
    private ArrayList<Spotkanie> niedziela = new ArrayList<>();

    public ArrayList<Spotkanie> getPoniedzialek() {
        return poniedzialek;
    }

    public void setPoniedzialek(ArrayList<Spotkanie> poniedzialek) {
        this.poniedzialek = poniedzialek;
    }

    public ArrayList<Spotkanie> getWtorek() {
        return wtorek;
    }

    public void setWtorek(ArrayList<Spotkanie> wtorek) {
        this.wtorek = wtorek;
    }

    public ArrayList<Spotkanie> getSroda() {
        return sroda;
    }

    public void setSroda(ArrayList<Spotkanie> sroda) {
        this.sroda = sroda;
    }

    public ArrayList<Spotkanie> getCzwartek() {
        return czwartek;
    }

    public void setCzwartek(ArrayList<Spotkanie> czwartek) {
        this.czwartek = czwartek;
    }

    public ArrayList<Spotkanie> getPiatek() {
        return piatek;
    }

    public void setPiatek(ArrayList<Spotkanie> piatek) {
        this.piatek = piatek;
    }

    public ArrayList<Spotkanie> getSobota() {
        return sobota;
    }

    public void setSobota(ArrayList<Spotkanie> sobota) {
        this.sobota = sobota;
    }

    public ArrayList<Spotkanie> getNiedziela() {
        return niedziela;
    }

    public void setNiedziela(ArrayList<Spotkanie> niedziela) {
        this.niedziela = niedziela;
    }

    public void dodajSpotkanie(ArrayList<Spotkanie> dzien, Spotkanie spotkanie) {
        dzien.add(spotkanie);
    }
    public void usunSpotkanie(ArrayList<Spotkanie> dzien, Spotkanie spotkanie) {
        dzien.remove(spotkanie);
    }

}
