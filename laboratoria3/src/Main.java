import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void displayMenu() {
        System.out.println("Witaj w programie do liczenia Ocen studenta! Komendy:");
        System.out.println("/add - Dodaj ocenę");
        System.out.println("/avg - Policz średnią");
        System.out.println("/max - Znajdź największą ocenę");
        System.out.println("/min - Znajdź najmniejszą ocenę");
        System.out.println("/exit - Wyjdź z programu");
    }

    public static void handleAddGrade(GradeList gradeList) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;
        while (continueInput) {
            System.out.print("Podaj ocenę: ");
            try {
                float grade = scanner.nextFloat();
                if (grade > 0) {
                    gradeList.addGrade(grade);
                    continueInput = false;
                } else {
                    System.out.println("Ocena musi być większa od zera.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Podaj prawidłową liczbę.");
                scanner.nextLine();
            }
        }
    }

    public static void handleCalcAvg(GradeList gradeList) {
        double avg = gradeList.calculateAverage();
        System.out.println(avg == -1 ? "Brak ocen" : STR."Twoja średnia: \{avg}");
    }

    public static void handleMaxGrade(GradeList gradeList) {
        double max = gradeList.findMaxGrade();
        System.out.println(max == -1 ? "Brak ocen" : STR."Twoja najwyższa ocena: \{max}");
    }

    public static void handleMinGrade(GradeList gradeList) {
        double min = gradeList.findMinGrade();
        System.out.println(min == -1 ? "Brak ocen" : STR."Twoja najniższa ocena: \{min}");

    }

    public static void main(String[] args) {
        GradeList myGradeList = new GradeList();
        displayMenu();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String option = scanner.nextLine().toLowerCase();
            switch (option) {
                case "/add" -> handleAddGrade(myGradeList);
                case "/avg" -> handleCalcAvg(myGradeList);
                case "/max" -> handleMaxGrade(myGradeList);
                case "/min" -> handleMinGrade(myGradeList);
                case "/exit" -> {
                    flag = false;
                    System.out.println("Żegnamy!");
                }
            }
        }
    }
}