public class Calculations {

    public static long silnia(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static long sum(int a, int b) {
        long sum = 0;
        for (int i = a; i <= b; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

