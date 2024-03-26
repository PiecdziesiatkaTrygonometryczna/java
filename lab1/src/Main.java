import java.util.Scanner;

public class Main {


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
                case "f":
                    System.out.print("Podaj n, aby policzyć silnię: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(n + "! = " + Calculations.silnia((n)));
                    break;
                case "s":
                    System.out.print("Podaj a: ");
                    int a = scanner.nextInt();
                    System.out.print("Podaj b: ");
                    int b = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(Calculations.sum(a, b));
                    break;
                case "exit":
                    flag = false;
                    System.out.println("Żegnamy!");
                    break;
            }
        }
    }
}