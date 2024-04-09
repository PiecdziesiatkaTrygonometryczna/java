import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void calculateAreas(Walec walec) {
        System.out.println("Pole powierzchni podstawy: " + walec.calculateBaseArea());
        System.out.println("Pole powierzchni bocznej: " + walec.calculateSideArea());
        System.out.println("Pole powierzchni całkowitej: " + walec.calculateTotalArea());
    }

    public static void displayGreeting() {
        System.out.println("Witaj w programie wykonującym operacje na Bryle geometrycznej - Walcu. Komendy:");
        System.out.println("/get - wyświetl parametry Walca");
        System.out.println("/set - ustaw parametry Walca");
        System.out.println("/area - oblicz wszystkie pola powierzchni Walca");
        System.out.println("/volume - oblicz objętość Walca");
        System.out.println("/exit - wyjdź z programu");
    }

    public static void setCylinder(Walec walec) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;
        while (continueInput) {
            System.out.print("Podaj promień podstawy: ");
            try {
                walec.setBaseRadius(scanner.nextDouble());
                continueInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłową liczbę.");
                scanner.nextLine();
            }
        }
        continueInput = true;
        while (continueInput) {
            System.out.print("Podaj wysokość: ");
            try {
                walec.setHeight(scanner.nextDouble());
                continueInput = false;
            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłową liczbę.");
                scanner.nextLine();
            }
        }
    }

    public static void main(String[] args) {
        Walec walec = new Walec();
        displayGreeting();
        setCylinder(walec);
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "/set": setCylinder(walec); break;
                case "/get": System.out.println("Promień podstawy: " + walec.getBaseRadius().toString() +
                        "\nWysokość: " + walec.getHeight().toString()); break;
                case "/area": calculateAreas(walec); break;
                case "/volume": System.out.println("Objętość: " + walec.calculateVolume()); break;
                case "/exit": flag = false; System.out.println("Żegnamy!"); break;
            }
        }
    }
}