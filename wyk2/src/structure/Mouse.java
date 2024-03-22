package structure;

public class Mouse {
    static int maxLength = 5; // zmienna klasy
    private int length; // zmienna instancji
    public void grow (int inches) {
        if (length < maxLength) {
            int newSize = length + inches;  // newsize istnieje tylko w bloku if
            length = newSize;
        }
    }
}
