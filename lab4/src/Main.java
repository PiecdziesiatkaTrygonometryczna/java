import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static void dodajSpotkanieDoKalendarza(Kalendarz kalendarz) {
    Spotkanie noweSpotkanie = utworzSpotkanie();
    Scanner scanner = new Scanner(System.in);
    System.out.println("""
                        Wybierz dzień (wpisz cyfrę):
                        Poniedziałek - 1
                        Wtorek - 2
                        Środa - 3
                        Czwartek - 4
                        Piątek - 5
                        Sobota = 6
                        Niedziela - 7""");
    int day = scanner.nextInt();
    switch (day) {
        case 1 -> kalendarz.dodajSpotkanie(kalendarz.getPoniedzialek(), noweSpotkanie);
        case 2 -> kalendarz.dodajSpotkanie(kalendarz.getWtorek(),noweSpotkanie);
        case 3 -> kalendarz.dodajSpotkanie(kalendarz.getSroda(), noweSpotkanie);
        case 4 -> kalendarz.dodajSpotkanie(kalendarz.getCzwartek(), noweSpotkanie);
        case 5 -> kalendarz.dodajSpotkanie(kalendarz.getPiatek(), noweSpotkanie);
        case 6 -> kalendarz.dodajSpotkanie(kalendarz.getSobota(), noweSpotkanie);
        case 7 -> kalendarz.dodajSpotkanie(kalendarz.getNiedziela(), noweSpotkanie);
    }
}
    public static Spotkanie utworzSpotkanie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj opis spotkania:");
        String opis = scanner.nextLine();

        System.out.println("Podaj godzinę rozpoczęcia spotkania (w formacie HH:mm):");
        String startTimeString = scanner.nextLine();
        LocalTime startTime = LocalTime.parse(startTimeString);

        System.out.println("Podaj godzinę zakończenia spotkania (w formacie HH:mm):");
        String endTimeString = scanner.nextLine();
        LocalTime endTime = LocalTime.parse(endTimeString);

        System.out.println("Podaj priorytet spotkania (w zakresie 1-3):");
        int priorytet = scanner.nextInt();
        scanner.nextLine();
        return new Spotkanie(opis, startTime, endTime, priorytet);
    }

    public static void usunSpotkanieZKalendarza(Kalendarz kalendarz, Spotkanie spotkanie) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                        Wybierz dzień (wpisz cyfrę):
                        Poniedziałek - 1
                        Wtorek - 2
                        Środa - 3
                        Czwartek - 4
                        Piątek - 5
                        Sobota = 6
                        Niedziela - 7""");
        int day = scanner.nextInt();
        switch (day) {
            case 1 -> kalendarz.usunSpotkanie(kalendarz.getPoniedzialek(), spotkanie);
            case 2 -> kalendarz.usunSpotkanie(kalendarz.getWtorek(),spotkanie);
            case 3 -> kalendarz.usunSpotkanie(kalendarz.getSroda(), spotkanie);
            case 4 -> kalendarz.usunSpotkanie(kalendarz.getCzwartek(), spotkanie);
            case 5 -> kalendarz.usunSpotkanie(kalendarz.getPiatek(), spotkanie);
            case 6 -> kalendarz.usunSpotkanie(kalendarz.getSobota(), spotkanie);
            case 7 -> kalendarz.usunSpotkanie(kalendarz.getNiedziela(), spotkanie);
        }
    }

public static void wyswietlSpotkania(Kalendarz kalendarz) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("""
                        Wybierz dzień (wpisz cyfrę):
                        Poniedziałek - 1
                        Wtorek - 2
                        Środa - 3
                        Czwartek - 4
                        Piątek - 5
                        Sobota = 6
                        Niedziela - 7""");
    int day = scanner.nextInt();
    switch (day) {
        case 1 -> kalendarz.getPoniedzialek().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 2 -> kalendarz.getWtorek().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 3 -> kalendarz.getSroda().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 4 -> kalendarz.getCzwartek().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 5 -> kalendarz.getPiatek().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 6 -> kalendarz.getSobota().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
        case 7 -> kalendarz.getNiedziela().forEach(n -> System.out.println(n.getOpis() + " " + n.getCzasPoczatku() + " " + n.getCzasZakonczenia() + " " + n.getPriorytet()));
    }
}

    public static void main(String[] args) {
    Spotkanie spotkanie1 = new Spotkanie("laby z javy", LocalTime.of(8, 30), LocalTime.of(12, 00), 3);
        Spotkanie spotkanie2 = new Spotkanie("laby z io", LocalTime.of(8, 30), LocalTime.of(12, 00), 3);
        Spotkanie spotkanie3 = new Spotkanie("laby z xd", LocalTime.of(8, 30), LocalTime.of(12, 00), 3);
        Kalendarz kalendarz = new Kalendarz();
        kalendarz.getPoniedzialek().add(spotkanie1);
        kalendarz.getPoniedzialek().add(spotkanie2);
        kalendarz.getPoniedzialek().add(spotkanie3);

        System.out.println("Witaj w kalendarzu");
        System.out.println("Dodaj spotkanie - wpisz 1\nUsuń spotkanie - wpisz 2\nWyświetl spotkania - wpisz 3\n" +
                "Wyświetl spotkania z danym priorytetem - wpisz 4\nWyświetl spotkania " +
                "zaczynajace się od danej godziny - wpisz 5");
        Scanner scanner = new Scanner(System.in);
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        switch (userChoice) {
            case 1 -> dodajSpotkanieDoKalendarza(kalendarz);
            case 3 -> wyswietlSpotkania(kalendarz);
        }
    }
}