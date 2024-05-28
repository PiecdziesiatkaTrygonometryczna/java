import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void wyswietlOferty(String opis, List<Oferta> oferty) {
        System.out.println(opis);
        oferty.forEach(System.out::println);
        System.out.println();
    }

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Dodaj ofertę sprzedaży domu");
        System.out.println("2. Dodaj ofertę sprzedaży mieszkania");
        System.out.println("3. Wyświetl aktualne oferty sprzedaży domów");
        System.out.println("4. Wyświetl aktualne oferty sprzedaży mieszkań");
        System.out.println("5. Wyświetl aktualne oferty sprzedaży domów w podanej miejscowości i o podanej powierzchni");
        System.out.println("6. Wyświetl aktualne oferty sprzedaży mieszkań w podanej miejscowości, nie droższych niż podana wartość i od podanego piętra wzwyż");
        System.out.println("7. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    public static void dodajOferteDomu(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj ulicę: ");
        String ulica = scanner.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj miejscowosć: ");
        String miejscowosc = scanner.nextLine();
        System.out.print("Podaj kod pocztowy (w formacie xx-xxx): ");
        String kodPocztowy = scanner.nextLine();
        System.out.print("Podaj powierzchnię: ");
        double powierzchnia = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Podaj powierzchnię działki: ");
        double powierzchniaDzialki = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Podaj cenę: ");
        int cena = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj datę obowiązywania oferty (YYYY-MM-DD): ");
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(scanner.nextLine());
        Dom nowyDom = new Dom(ulica, numerDomu, miejscowosc, kodPocztowy, powierzchnia, cena, powierzchniaDzialki, dataObowiazywaniaOferty);
        listaOfert.dodajOferte(nowyDom);

        System.out.println("Oferta domu została dodana.");
    }

    public static void dodajOferteMieszkania(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj ulicę: ");
        String ulica = scanner.nextLine();
        System.out.print("Podaj numer domu: ");
        int numerDomu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj numer mieszkania: ");
        int numerMieszkania = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj miejscowosć: ");
        String miejscowosc = scanner.nextLine();
        System.out.print("Podaj kod pocztowy (w formacie xx-xxx): ");
        String kodPocztowy = scanner.nextLine();
        System.out.print("Podaj powierzchnię: ");
        double powierzchnia = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Podaj numer piętra: ");
        int numerPietra = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj cenę: ");
        int cena = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Podaj datę obowiązywania oferty (YYYY-MM-DD): ");
        LocalDate dataObowiazywaniaOferty = LocalDate.parse(scanner.nextLine());

        Mieszkanie noweMieszkanie = new Mieszkanie(ulica, numerDomu, numerMieszkania, miejscowosc, kodPocztowy, powierzchnia, numerPietra, cena, dataObowiazywaniaOferty);
        listaOfert.dodajOferte(noweMieszkanie);

        System.out.println("Oferta mieszkania została dodana.");
    }

    public static void wyswietlAktualneOfertyDomow(ListaOfert listaOfert) {
        List<Oferta> ofertyDomow = listaOfert.filtrujOferty(oferta -> oferta instanceof Dom && oferta.getDataObowiazywaniaOferty().isAfter(LocalDate.now()) || oferta.getDataObowiazywaniaOferty().isEqual(LocalDate.now()));
        wyswietlOferty("Wszystkie aktualne oferty sprzedaży domów:", ofertyDomow);
    }

    public static void wyswietlAktualneOfertyMieszkan(ListaOfert listaOfert) {
        List<Oferta> ofertyMieszkan = listaOfert.filtrujOferty(oferta -> oferta instanceof Mieszkanie && oferta.getDataObowiazywaniaOferty().isAfter(LocalDate.now()) || oferta.getDataObowiazywaniaOferty().isEqual(LocalDate.now()));
        wyswietlOferty("Wszystkie aktualne oferty sprzedaży mieszkań:", ofertyMieszkan);
    }

    public static void wyswietlAktualneOfertyDomowWgMiejscowosciIPowierzchni(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.print("Podaj minimalną powierzchnię: ");
        double powierzchnia = scanner.nextDouble();
        scanner.nextLine();

        List<Oferta> ofertyDomow = listaOfert.filtrujOferty(oferta -> oferta instanceof Dom && oferta.getMiejscowosc().equals(miejscowosc) && oferta.getPowierzchnia() >= powierzchnia && oferta.getDataObowiazywaniaOferty().isAfter(LocalDate.now()) || oferta.getDataObowiazywaniaOferty().isEqual(LocalDate.now()));
        wyswietlOferty("Wszystkie aktualne oferty sprzedaży domów w miejscowości '" + miejscowosc + "' o powierzchni nie mniejszej niż " + powierzchnia + "m²:", ofertyDomow);
    }

    public static void wyswietlAktualneOfertyMieszkanWgMiejscowosciCenyIPietra(Scanner scanner, ListaOfert listaOfert) {
        System.out.print("Podaj miejscowość: ");
        String miejscowosc = scanner.nextLine();
        System.out.print("Podaj maksymalną cenę: ");
        double cena = scanner.nextDouble();
        System.out.print("Podaj minimalny numer piętra: ");
        int numerPietra = scanner.nextInt();
        scanner.nextLine();

        List<Oferta> ofertyMieszkan = listaOfert.filtrujOferty(oferta -> oferta instanceof Mieszkanie && oferta.getMiejscowosc().equals(miejscowosc) && oferta.getCena() <= cena && ((Mieszkanie) oferta).getNumerPietra() >= numerPietra && oferta.getDataObowiazywaniaOferty().isAfter(LocalDate.now()) || oferta.getDataObowiazywaniaOferty().isEqual(LocalDate.now()));
        wyswietlOferty("Wszystkie aktualne oferty sprzedaży mieszkań w miejscowości '" + miejscowosc + "' nie droższych niż " + cena + " PLN i od piętra " + numerPietra + " wzwyż:", ofertyMieszkan);
    }

    public static void main(String[] args) {
        ListaOfert listaOfert = new ListaOfert();
        listaOfert.dodajPrzykladoweOferty();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            displayMenu();
            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> dodajOferteDomu(scanner, listaOfert);
                case 2 -> dodajOferteMieszkania(scanner, listaOfert);
                case 3 -> wyswietlAktualneOfertyDomow(listaOfert);
                case 4 -> wyswietlAktualneOfertyMieszkan(listaOfert);
                case 5 -> wyswietlAktualneOfertyDomowWgMiejscowosciIPowierzchni(scanner, listaOfert);
                case 6 -> wyswietlAktualneOfertyMieszkanWgMiejscowosciCenyIPietra(scanner, listaOfert);
                case 7 -> {
                    flag = false;
                    System.out.println("Żegnamy!");
                }
                default -> System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            }
            }
        }
    }
}