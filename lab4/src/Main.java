import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dodajSpotkanieDoKalendarza(Kalendarz kalendarz) {
        Spotkanie noweSpotkanie = utworzSpotkanie();
        int day = wybierzDzien();
        dodajSpotkanie(kalendarz, noweSpotkanie, day);
    }

    public static Spotkanie utworzSpotkanie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj opis spotkania:");
        String opis = scanner.nextLine();

        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia spotkania (w formacie HH:mm):");
        LocalTime endTime = pobierzGodzine("Podaj godzinę zakończenia spotkania (w formacie HH:mm):");

        int priorytet = pobierzPriorytet();

        return new Spotkanie(opis, startTime, endTime, priorytet);
    }

    public static void usunSpotkanie(Kalendarz kalendarz) {
        int day = wybierzDzien();
        ArrayList<Spotkanie> spotkania = pobierzSpotkaniaDlaDnia(kalendarz, day);

        if (spotkania.isEmpty()) {
            System.out.println("Brak spotkań do usunięcia w tym dniu.");
            return;
        }

        wyswietlSpotkaniaDoUsuniecia(spotkania);

        int index = pobierzIndexSpotkania();
        if (index >= 0 && index < spotkania.size()) {
            kalendarz.usunSpotkanie(spotkania, spotkania.get(index));
            System.out.println("Spotkanie zostało usunięte.");
        } else {
            System.out.println("Nieprawidłowy indeks spotkania.");
        }
    }

    public static ArrayList<Spotkanie> pobierzSpotkaniaDlaDnia(Kalendarz kalendarz, int day) {
        return switch (day) {
            case 1 -> kalendarz.getPoniedzialek();
            case 2 -> kalendarz.getWtorek();
            case 3 -> kalendarz.getSroda();
            case 4 -> kalendarz.getCzwartek();
            case 5 -> kalendarz.getPiatek();
            case 6 -> kalendarz.getSobota();
            case 7 -> kalendarz.getNiedziela();
            default -> new ArrayList<>();
        };
    }

    public static void wyswietlSpotkaniaDoUsuniecia(ArrayList<Spotkanie> spotkania) {
        System.out.println("Spotkania w tym dniu:");

        for (int i = 0; i < spotkania.size(); i++) {
            System.out.print(i + ": ");
            wyswietlSpotkanie(spotkania.get(i));
        }
    }

    public static int pobierzIndexSpotkania() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj indeks spotkania:");
        return scanner.nextInt();
    }



    public static int wybierzDzien() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Wybierz dzień (wpisz cyfrę):
                Poniedziałek - 1
                Wtorek - 2
                Środa - 3
                Czwartek - 4
                Piątek - 5
                Sobota - 6
                Niedziela - 7""");
        return scanner.nextInt();
    }

    public static LocalTime pobierzGodzine(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return LocalTime.parse(scanner.nextLine());
    }

    public static int pobierzPriorytet() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj priorytet spotkania (w zakresie 1-3):");
        return scanner.nextInt();
    }

    public static void dodajSpotkanie(Kalendarz kalendarz, Spotkanie spotkanie, int day) {
        switch (day) {
            case 1 -> kalendarz.dodajSpotkanie(kalendarz.getPoniedzialek(), spotkanie);
            case 2 -> kalendarz.dodajSpotkanie(kalendarz.getWtorek(), spotkanie);
            case 3 -> kalendarz.dodajSpotkanie(kalendarz.getSroda(), spotkanie);
            case 4 -> kalendarz.dodajSpotkanie(kalendarz.getCzwartek(), spotkanie);
            case 5 -> kalendarz.dodajSpotkanie(kalendarz.getPiatek(), spotkanie);
            case 6 -> kalendarz.dodajSpotkanie(kalendarz.getSobota(), spotkanie);
            case 7 -> kalendarz.dodajSpotkanie(kalendarz.getNiedziela(), spotkanie);
        }
    }

    public static void wyswietlSpotkania(Kalendarz kalendarz) {
        int day = wybierzDzien();
        wyswietlSpotkaniaDlaDnia(kalendarz, day);
    }

    public static void wyswietlSpotkaniaDlaDnia(Kalendarz kalendarz, int day) {
        switch (day) {
            case 1 -> kalendarz.getPoniedzialek().forEach(n -> wyswietlSpotkanie(n));
            case 2 -> kalendarz.getWtorek().forEach(n -> wyswietlSpotkanie(n));
            case 3 -> kalendarz.getSroda().forEach(n -> wyswietlSpotkanie(n));
            case 4 -> kalendarz.getCzwartek().forEach(n -> wyswietlSpotkanie(n));
            case 5 -> kalendarz.getPiatek().forEach(n -> wyswietlSpotkanie(n));
            case 6 -> kalendarz.getSobota().forEach(n -> wyswietlSpotkanie(n));
            case 7 -> kalendarz.getNiedziela().forEach(n -> wyswietlSpotkanie(n));
        }
    }

    public static void wyswietlSpotkaniaDlaDniaZPriorytetem(Kalendarz kalendarz) {
    int day = wybierzDzien();
    int priorytet = pobierzPriorytet();

        ArrayList<Spotkanie> spotkania = new ArrayList<>();

        switch (day) {
            case 1 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getPoniedzialek(), priorytet);
            case 2 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getWtorek(), priorytet);
            case 3 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getSroda(), priorytet);
            case 4 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getCzwartek(), priorytet);
            case 5 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getPiatek(), priorytet);
            case 6 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getSobota(), priorytet);
            case 7 -> spotkania = kalendarz.spotkaniaZPriorytetem(kalendarz.getNiedziela(), priorytet);
        }

        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania o priorytecie " + priorytet + " :");
            for (Spotkanie spotkanie : spotkania) {
                wyswietlSpotkanie(spotkanie);
            }
        } else {
            System.out.println("Brak spotkań o priorytecie " + priorytet + " :");
        }
    }

    public static void wyswietlSpotkaniaOdDanejGodziny(Kalendarz kalendarz) {
        int day = wybierzDzien();
        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia spotkań (w formacie HH:mm):");

        ArrayList<Spotkanie> spotkania = new ArrayList<>();

        switch (day) {
            case 1 -> spotkania = kalendarz.getPoniedzialek();
            case 2 -> spotkania = kalendarz.getWtorek();
            case 3 -> spotkania = kalendarz.getSroda();
            case 4 -> spotkania = kalendarz.getCzwartek();
            case 5 -> spotkania = kalendarz.getPiatek();
            case 6 -> spotkania = kalendarz.getSobota();
            case 7 -> spotkania = kalendarz.getNiedziela();
        }

        System.out.println("Spotkania rozpoczynające się nie wcześniej niż o " + startTime + " :");

        for (Spotkanie spotkanie : spotkania) {
            if (spotkanie.getCzasPoczatku().isAfter(startTime) || spotkanie.getCzasPoczatku().equals(startTime)) {
                wyswietlSpotkanie(spotkanie);
            }
        }
    }


    public static void wyswietlSpotkanie(Spotkanie spotkanie) {
        System.out.println(spotkanie.getOpis() + " " + spotkanie.getCzasPoczatku() + " " +
                spotkanie.getCzasZakonczenia() + " " + spotkanie.getPriorytet());
    }

    public static void displayGreeing() {
        System.out.println("\n\nDodaj spotkanie - wpisz 1\nUsuń spotkanie - wpisz 2\nWyświetl spotkania - wpisz 3\n" +
                "Wyświetl spotkania z danym priorytetem - wpisz 4\nWyświetl spotkania " +
                "zaczynajace się od danej godziny - wpisz 5\nAby wyjść - wpisz 6");
    }

    public static void makeTestMeetings(Kalendarz kalendarz) {
        Spotkanie spotkanie1 = new Spotkanie("laby z javy", LocalTime.of(8, 30), LocalTime.of(12, 30), 3);
        Spotkanie spotkanie2 = new Spotkanie("laby z io", LocalTime.of(9, 30), LocalTime.of(13, 00), 2);
        Spotkanie spotkanie3 = new Spotkanie("laby z dockera", LocalTime.of(9, 00), LocalTime.of(12, 00), 2);
        Spotkanie spotkanie4 = new Spotkanie("laby z numerycznych", LocalTime.of(8, 30), LocalTime.of(12, 30), 3);
        Spotkanie spotkanie5 = new Spotkanie("laby z go", LocalTime.of(8, 00), LocalTime.of(12, 45), 1);
        Spotkanie spotkanie6 = new Spotkanie("wyklad z dockera", LocalTime.of(7, 30), LocalTime.of(18, 00), 2);
        Spotkanie spotkanie7 = new Spotkanie("wyklad z javy", LocalTime.of(7, 00), LocalTime.of(10, 00), 1);
        kalendarz.getPoniedzialek().add(spotkanie1);
        kalendarz.getPoniedzialek().add(spotkanie2);
        kalendarz.getPoniedzialek().add(spotkanie3);
        kalendarz.getPoniedzialek().add(spotkanie4);
        kalendarz.getPoniedzialek().add(spotkanie5);
        kalendarz.getPoniedzialek().add(spotkanie6);
        kalendarz.getPoniedzialek().add(spotkanie7);
    }
    public static void main(String[] args) {
        Kalendarz kalendarz = new Kalendarz();
        makeTestMeetings(kalendarz);
        System.out.println("Witaj w kalendarzu");
        boolean flag = true;
        while (flag) {
        displayGreeing();
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice) {
                case 1 -> dodajSpotkanieDoKalendarza(kalendarz);
                case 2 -> usunSpotkanie(kalendarz);
                case 3 -> wyswietlSpotkania(kalendarz);
                case 4 -> wyswietlSpotkaniaDlaDniaZPriorytetem(kalendarz);
                case 5 -> wyswietlSpotkaniaOdDanejGodziny(kalendarz);
                case 6 -> flag = false;
        }
        }
    }
}
