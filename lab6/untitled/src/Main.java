import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void dodajWydarzenieDoKalendarza(Kalendarz kalendarz) {
        Wydarzenie noweWydarzenie = utworzWydarzenie();

        if (noweWydarzenie.getCzasPoczatku().isBefore(Wydarzenie.MIN_GODZINA)) {
            System.out.println("Wydarzenie nie może zaczynać się wcześniej niż " + Wydarzenie.MIN_GODZINA);
            return;
        }

        int day = wybierzDzien();
        kalendarz.dodajWydarzenie(day, noweWydarzenie);
    }

    public static Wydarzenie utworzWydarzenie() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Czy chcesz dodać Spotkanie (1) czy Zadanie (2)?");
        int wybor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Podaj opis wydarzenia:");
        String opis = scanner.nextLine();

        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia wydarzenia (w formacie HH:mm):");
        LocalTime endTime = pobierzGodzine("Podaj godzinę zakończenia wydarzenia (w formacie HH:mm):");

        if (startTime.isAfter(endTime)) {
            System.out.println("Godzina rozpoczęcia nie może być po godzinie zakończenia.");
            return utworzWydarzenie();
        }

        if (wybor == 1) {
            int priorytet = pobierzPriorytet();
            return new Spotkanie(opis, startTime, endTime, priorytet);
        } else if (wybor == 2) {
            System.out.println("Podaj status zadania: Planowane (1), Potwierdzone (2), Realizowane (3), Wykonane (4)");
            int status = scanner.nextInt();
            return new Zadanie(opis, startTime, endTime, status);
        } else {
            System.out.println("Nieprawidłowy wybór.");
            return utworzWydarzenie();
        }
    }



    public static void usunWydarzenie(Kalendarz kalendarz) {
        int day = wybierzDzien();
        ArrayList<Wydarzenie> wydarzenia = kalendarz.getDzien(day);

        if (wydarzenia.isEmpty()) {
            System.out.println("Brak wydarzeń do usunięcia w tym dniu.");
            return;
        }

        wyswietlWydarzeniaDoUsuniecia(wydarzenia);

        int index = pobierzIndexSpotkania();
        if (index >= 0 && index < wydarzenia.size()) {
            kalendarz.usunWydarzenie(day, wydarzenia.get(index));
            System.out.println("Wydarzenie zostało usunięte.");
        } else {
            System.out.println("Nieprawidłowy indeks Wydarzenia.");
        }
    }

    public static void wyswietlWydarzeniaDoUsuniecia(ArrayList<Wydarzenie> wydarzenia) {
        System.out.println("Wydarzenia w tym dniu:");

        for (int i = 0; i < wydarzenia.size(); i++) {
            System.out.print(i + ": ");
            wyswietlWydarzenie(wydarzenia.get(i));
        }
    }

    public static int pobierzIndexSpotkania() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj indeks wydarzenia:");
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


    public static void wyswietlWydarzenie(Wydarzenie wydarzenie) {
        System.out.println(wydarzenie);
    }

    public static void wyswietlSpotkaniaDlaDniaZPriorytetem(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        int priorytet = pobierzPriorytet();
        ArrayList<Wydarzenie> wydarzenia = kalendarz.filtrujWydarzenia(dzien, wydarzenie -> wydarzenie instanceof Spotkanie && ((Spotkanie) wydarzenie).getPriorytet() == priorytet);

        if (!wydarzenia.isEmpty()) {
            System.out.println("Spotkania o priorytecie " + priorytet + " w tym dniu:");
            wydarzenia.forEach(wydarzenie -> {
                if (wydarzenie instanceof Spotkanie) {
                    wyswietlWydarzenie(wydarzenie);
                }
            });
        } else {
            System.out.println("Brak spotkań o priorytecie " + priorytet + " w tym dniu.");
        }
    }

    public static void wyswietlSpotkaniaPrioOrazCzas(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        LocalTime startTime = pobierzGodzine("Podaj godzinę rozpoczęcia spotkań (w formacie HH:mm):");
        int priorytet = pobierzPriorytet();

        ArrayList<Wydarzenie> wydarzenia = kalendarz.filtrujWydarzenia(dzien, wydarzenie -> {
            if (wydarzenie instanceof Spotkanie) {
                Spotkanie spotkanie = (Spotkanie) wydarzenie;
                return (spotkanie.getCzasPoczatku().isAfter(startTime) || spotkanie.getCzasPoczatku().equals(startTime))
                        && spotkanie.getPriorytet() == priorytet;
            }
            return false;
        });

        if (!wydarzenia.isEmpty()) {
            System.out.println("Spotkania o priorytecie " + priorytet + " rozpoczynające się nie wcześniej niż o " + startTime + " w tym dniu:");
            wydarzenia.forEach(Main::wyswietlWydarzenie);
        } else {
            System.out.println("Brak spotkań o priorytecie " + priorytet + " rozpoczynających się nie wcześniej niż o " + startTime + " w tym dniu.");
        }
    }

    public static int pobierzStatus() {
        System.out.println("Podaj status zadania: Planowane (1), Potwierdzone (2), Realizowane (3), Wykonane (4)");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void wyswietlZadaniaOStatusie(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        int status = pobierzStatus();

        ArrayList<Wydarzenie> wydarzenia = kalendarz.filtrujWydarzenia(dzien, wydarzenie -> {
            if (wydarzenie instanceof Zadanie) {
                Zadanie zadanie = (Zadanie) wydarzenie;
                return zadanie.getStatus() == status;
            }
            return false;
        });

        if (!wydarzenia.isEmpty()) {
            System.out.println("Zadania o statusie " + status + " w tym dniu:");
            wydarzenia.forEach(Main::wyswietlWydarzenie);
        } else {
            System.out.println("Brak zadań o statusie " + status + " w tym dniu.");
        }
    }


    public static void wyswietlSpotkaniaWDniu(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        ArrayList<Wydarzenie> wydarzenia = kalendarz.getDzien(dzien);

        if (!wydarzenia.isEmpty()) {
            System.out.println("Spotkania w wybranym dniu:");
            for (Wydarzenie wydarzenie : wydarzenia) {
                if (wydarzenie instanceof Spotkanie) {
                    wyswietlWydarzenie(wydarzenie);
                }
            }
        } else {
            System.out.println("Brak spotkań w wybranym dniu.");
        }
    }

    public static void wyswietlZadaniaWDniu(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        ArrayList<Wydarzenie> wydarzenia = kalendarz.getDzien(dzien);

        if (!wydarzenia.isEmpty()) {
            System.out.println("Zadania w wybranym dniu:");
            for (Wydarzenie wydarzenie : wydarzenia) {
                if (wydarzenie instanceof Zadanie) {
                    wyswietlWydarzenie(wydarzenie);
                }
            }
        } else {
            System.out.println("Brak zadań w wybranym dniu.");
        }
    }

    public static void zadaniaStatusGodzina(Kalendarz kalendarz) {
        int dzien = wybierzDzien();
        int status = pobierzStatus();
        LocalTime endTime = pobierzGodzine("Podaj godzinę maksymalnego zakończenia zadań (w formacie HH:mm):");

        ArrayList<Wydarzenie> wydarzenia = kalendarz.getDzien(dzien);

        if (!wydarzenia.isEmpty()) {
            System.out.println("Zadania w wybranym dniu o wybranym statusie i kończące się nie później niż " + endTime + ":");
            for (Wydarzenie wydarzenie : wydarzenia) {
                if (wydarzenie instanceof Zadanie) {
                    Zadanie zadanie = (Zadanie) wydarzenie;
                    if (zadanie.getStatus() == status && (zadanie.getCzasZakonczenia().isBefore(endTime) || zadanie.getCzasZakonczenia().equals(endTime))) {
                        wyswietlWydarzenie(wydarzenie);
                    }
                }
            }
        } else {
            System.out.println("Brak zadań w wybranym dniu.");
        }
    }



    public static void displayGreeing() {
        System.out.println("\n\nDodaj wydarzenie - wpisz 1\nUsuń wydarzenie - wpisz 2\nWyświetl spotkania - wpisz 3\n" +
                "Wyświetl zadania - wpisz 4\nWyświetl spotkania o danym priorytecie - wpisz 5\n" +
                "Wyświetl zadania o danym statusie - wpisz 6" +
                "\nWyświetl spotkania od danej godziny oraz o danym priorytecie - wpisz 7" +
                "\nWyświetl zadanie do danej godziny oraz o danym statusie - wpisz 8\nAby wyjść - wpisz 9");
    }

    public static void makeTestMeetings(Kalendarz kalendarz) {
        Spotkanie spotkanie1 = new Spotkanie("laby z javy", LocalTime.of(8, 30), LocalTime.of(12, 30), 3);
        Spotkanie spotkanie2 = new Spotkanie("laby z io", LocalTime.of(9, 30), LocalTime.of(13, 00), 2);
        Spotkanie spotkanie3 = new Spotkanie("laby z dockera", LocalTime.of(9, 00), LocalTime.of(12, 00), 1);
        Spotkanie spotkanie4 = new Spotkanie("laby z numerycznych", LocalTime.of(8, 30), LocalTime.of(12, 30), 1);
        Zadanie zadanie4 = new Zadanie("projekt z numerycznych", LocalTime.of(8, 00), LocalTime.of(12, 45), 3);
        Zadanie zadanie3 = new Zadanie("projekt z dockera", LocalTime.of(7, 30), LocalTime.of(18, 00), 1);
        Zadanie zadanie2 = new Zadanie("projekt z javy", LocalTime.of(7, 00), LocalTime.of(10, 00), 2);
        Zadanie zadanie1 = new Zadanie("projekt z IO", LocalTime.of(12, 00), LocalTime.of(14,00), 3);
        kalendarz.dodajWydarzenie(1, spotkanie1);
        kalendarz.dodajWydarzenie(1, spotkanie2);
        kalendarz.dodajWydarzenie(1, spotkanie3);
        kalendarz.dodajWydarzenie(1, spotkanie4);
        kalendarz.dodajWydarzenie(1, zadanie1);
        kalendarz.dodajWydarzenie(1, zadanie2);
        kalendarz.dodajWydarzenie(1, zadanie3);
        kalendarz.dodajWydarzenie(1, zadanie4);
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
                case 1 -> dodajWydarzenieDoKalendarza(kalendarz);
                case 2 -> usunWydarzenie(kalendarz);
                case 3 -> wyswietlSpotkaniaWDniu(kalendarz);
                case 4 -> wyswietlZadaniaWDniu(kalendarz);
                case 5 -> wyswietlSpotkaniaDlaDniaZPriorytetem(kalendarz);
                case 6 -> wyswietlZadaniaOStatusie(kalendarz);
                case 7 -> wyswietlSpotkaniaPrioOrazCzas(kalendarz);
                case 8 -> zadaniaStatusGodzina(kalendarz);
                case 9 -> flag = false;
            }
        }
    }
}