import java.util.Scanner;

public class Main {

    private static void policzSilnie() {
        System.out.print("Podaj n, aby policzyć silnię: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        System.out.println(n + "! = " + Calculations.silnia((n)));
    }

    private static void policzSume() {
        System.out.print("Podaj a: ");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.print("Podaj b: ");
        int b = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Suma liczb od liczby" + a + " do " + "b: " + (Calculations.sum(a, b)));
    }

    public static void main(String[] args) {
        System.out.println("Witaj w programie liczącym różne operacje matematyczne! ");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Wpisz \"f\", aby policzyć silnię.\n" +
                    "Wpisz \"s\", aby policzyć sumę od liczby a do liczby b.\n" +
                    "Wpisz \"exit\", aby wyjść z programu.");
            String input = scanner.nextLine().toLowerCase();
            switch(input) {
                case "f": policzSilnie(); break;
                case "s": policzSume(); break;
                case "exit":
                    flag = false;
                    System.out.println("Żegnamy!");
                    break;
            }
        }
    }
}