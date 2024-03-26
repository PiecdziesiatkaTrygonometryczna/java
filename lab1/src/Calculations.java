public class Calculations {

    public static long silnia(int n) {
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static long sum(int liczbaOd, int liczbaDo) {
        long sum = 0;
        for (int i = liczbaOd; i <= liczbaDo; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

