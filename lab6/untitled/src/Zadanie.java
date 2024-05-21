import java.time.LocalTime;

final class Zadanie extends Wydarzenie {
    private int status;

    public Zadanie(String opis, LocalTime czasPoczatku, LocalTime czasZakonczenia, int status) {
        super(opis, czasPoczatku, czasZakonczenia);
        this.status = status;
    }

    public Zadanie() {}

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String statusOpis = switch (getStatus()) {
            case 1 -> "Planowane";
            case 2 -> "Potwierdzone";
            case 3 -> "Realizowane";
            case 4 -> "Wykonane";
            default -> "Nieprawidłowy";
        };

        return "Zadanie{" +
                "opis='" + getOpis() + '\'' +
                ", czasPoczatku=" + getCzasPoczatku() +
                ", czasZakonczenia=" + getCzasZakonczenia() +
                ", status=" + statusOpis +
                '}';
    }
}
