import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dodajSpotkanieDoKalendarza(Kalendarz kalendarz) {
        Spotkanie noweSpotkanie = utworzSpotkanie();
        if (noweSpotkanie.getCzasPoczatku().isBefore(Spotkanie.MIN_GODZINA)) {
            System.out.println("Spotkanie nie może zaczynać się wcześniej niż " + Spotkanie.MIN_GODZINA);
            return;
        }
        int day = wybierzDzien();
        kalendarz.dodajSpotkanie(day, noweSpotkanie);
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
        ArrayList<Spotkanie> spotkania = kalendarz.getDzien(day);

        if (spotkania.isEmpty()) {
            System.out.println("Brak spotkań do usunięcia w tym dniu.");
            return;
        }

        wyswietlSpotkaniaDoUsuniecia(spotkania);

        int index = pobierzIndexSpotkania();
        if (index >= 0 && index < spotkania.size()) {
            kalendarz.usunSpotkanie(day, spotkania.get(index));
            System.out.println("Spotkanie zostało usunięte.");
        } else {
            System.out.println("Nieprawidłowy indeks spotkania.");
        }
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



    public static void wyswietlSpotkanie(Spotkanie spotkanie) {
        System.out.println(spotkanie);
    }

    public static void wyswietlSpotkania(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        ArrayList<Spotkanie> spotkania = kalendarz.getDzien(dzien);

        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania w tym dniu:");
            spotkania.forEach(Main::wyswietlSpotkanie);
        } else {
            System.out.println("Brak spotkań w tym dniu.");
        }
    }
    public static void wyswietlSpotkaniaDlaDniaZPriorytetem(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        int priorytet = pobierzPriorytet();

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkanie -> spotkanie.getPriorytet() == priorytet);

        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania o priorytecie " + priorytet + " w tym dniu:");
            spotkania.forEach(Main::wyswietlSpotkanie);
        } else {
            System.out.println("Brak spotkań o priorytecie " + priorytet + " w tym dniu.");
        }
    }

    public static void wyswietlSpotkaniaOdDanejGodziny(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia spotkań (w formacie HH:mm):");

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien, spotkanie -> spotkanie.getCzasPoczatku().isAfter(startTime) || spotkanie.getCzasPoczatku().equals(startTime));

        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania rozpoczynające się nie wcześniej niż o " + startTime + " w tym dniu:");
            spotkania.forEach(Main::wyswietlSpotkanie);
        } else {
            System.out.println("Brak spotkań rozpoczynających się nie wcześniej niż o " + startTime + " w tym dniu.");
        }
    }

    public static void wyswietlSpotkaniaMiędzyGodzinami(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        LocalTime startTime = pobierzGodzine("Podaj godzinę początkową (w formacie HH:mm):");
        LocalTime endTime = pobierzGodzine("Podaj godzinę końcową (w formacie HH:mm):");

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien,
                spotkanie -> (spotkanie.getCzasPoczatku().equals(startTime) || spotkanie.getCzasPoczatku().isAfter(startTime))
                        && (spotkanie.getCzasZakonczenia().equals(endTime) || spotkanie.getCzasZakonczenia().isBefore(endTime)));

        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania odbywające się między " + startTime + " a " + endTime + " w tym dniu:");
            spotkania.forEach(Main::wyswietlSpotkanie);
        } else {
            System.out.println("Brak spotkań odbywających się między " + startTime + " a " + endTime + " w tym dniu.");
        }
    }

    public static void wyswietlSpotkaniaPrioOrazCzas(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia spotkań (w formacie HH:mm):");
        int priorytet = pobierzPriorytet();

        ArrayList<Spotkanie> spotkania = kalendarz.filtrujSpotkania(dzien,
                spotkanie -> (spotkanie.getCzasPoczatku().isAfter(startTime) || spotkanie.getCzasPoczatku().equals(startTime))
                        && spotkanie.getPriorytet() == priorytet);


        if (!spotkania.isEmpty()) {
            System.out.println("Spotkania o priorytecie " + priorytet + " rozpoczynające się nie wcześniej niż o " + startTime + " w tym dniu:");
            spotkania.forEach(Main::wyswietlSpotkanie);
        } else {
            System.out.println("Brak spotkań o priorytecie " + priorytet + " rozpoczynających się nie wcześniej niż o " + startTime + " w tym dniu.");
        }
    }




    public static void displayGreeing() {
        System.out.println("\n\nDodaj spotkanie - wpisz 1\nUsuń spotkanie - wpisz 2\nWyświetl spotkania - wpisz 3\n" +
                "Wyświetl spotkania z danym priorytetem - wpisz 4\nWyświetl spotkania " +
                "zaczynajace się od danej godziny - wpisz 5\nAby wyświetlić spotkania pomiędzy godzinami - wpisz 6" +
                        "\nWyświetl spotkania od danej godziny oraz o danym priorytecie - wpisz 7" +
                "\nAby wyjść - wpisz 8");
    }

    public static void makeTestMeetings(Kalendarz kalendarz) {
        Spotkanie spotkanie1 = new Spotkanie("laby z javy", LocalTime.of(8, 30), LocalTime.of(12, 30), 3);
        Spotkanie spotkanie2 = new Spotkanie("laby z io", LocalTime.of(9, 30), LocalTime.of(13, 00), 2);
        Spotkanie spotkanie3 = new Spotkanie("laby z dockera", LocalTime.of(9, 00), LocalTime.of(12, 00), 1);
        Spotkanie spotkanie4 = new Spotkanie("laby z numerycznych", LocalTime.of(8, 30), LocalTime.of(12, 30), 1);
        Spotkanie spotkanie5 = new Spotkanie("laby z go", LocalTime.of(8, 00), LocalTime.of(12, 45), 1);
        Spotkanie spotkanie6 = new Spotkanie("wyklad z dockera", LocalTime.of(7, 30), LocalTime.of(18, 00), 2);
        Spotkanie spotkanie7 = new Spotkanie("wyklad z javy", LocalTime.of(7, 00), LocalTime.of(10, 00), 3);
        kalendarz.dodajSpotkanie(1, spotkanie1);
        kalendarz.dodajSpotkanie(1, spotkanie2);
        kalendarz.dodajSpotkanie(1, spotkanie3);
        kalendarz.dodajSpotkanie(1, spotkanie4);
        kalendarz.dodajSpotkanie(1, spotkanie5);
        kalendarz.dodajSpotkanie(1, spotkanie6);
        kalendarz.dodajSpotkanie(1, spotkanie7);
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
                case 6 -> wyswietlSpotkaniaMiędzyGodzinami(kalendarz);
                case 7 -> wyswietlSpotkaniaPrioOrazCzas(kalendarz);
                case 8 -> flag = false;
            }
        }
    }
}