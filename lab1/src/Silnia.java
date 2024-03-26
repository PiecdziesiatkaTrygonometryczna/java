import java.util.Scanner;

public class Silnia {
    static long silnia(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.print("Witaj w programie liczącym silnię! ");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Podaj liczbę naturalną n (proszę wpisać exit, aby wyjść z programu): ");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                System.out.println("Żegnamy!");
                flag = false;
            } else {
                System.out.println(input + " silnia to: " + silnia(Integer.parseInt(input)));
            }
        }
    }
}