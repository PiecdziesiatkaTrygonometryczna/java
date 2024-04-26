# Klasy abstrakcyjne

```
public abstract class Animal {
    protected int age;
    public void eat() {
        System.out.print.ln("Animal is eating");
    }
    public abstract String getName();
}
public class Swan extends Animal {
    public String getName(){
        return "Swan";
    }
}
```

W javie możemy dziedziczyć z jednej klasy nadrzędnej

# Interfejsy

public or default access modifier
        abstract keyword (assumerd)             interface name
                    interface keyword (required)
public  abstract       interface                   canBurrow {
        public static final int MINIMUM_DEPTH = 2;
        public abstract int getMaximumDepth();
}

        public astract keywords (assumed)       public static final keywords (assumed)


# Implementing interface

                                    implements keyword (required)
                class name                              interface name
public class fieldMouse                 implements       CanBurrow {

    public int getMaximumDepth() {
        return 10;
}

}

signature matches interface method


arraylist vs list


metody domyślne w interfejsach - konkretne metody ktore musimy dostarczyc w interfejsach

```
public abstract interface isWarmBlooded {
    public abstract boolean hasScales();
    public default double getTemperature() {
        return 10.0; }
   }
```


# Wyrażenia lambda

```
private String name;
private double height;
private oduble weight;
private double length;
public double getHeight() { return height; }
public double getWeight() { return weight; }
public double getLength() { return length; }
public String toString(){
    return ""Animal name: " + name + ", height: " + height + ", weight: " + weight + 
    " length: " + length; }
```

```
public class MasaiMara {
    private ArrayList<Animal> natureReserve;
    public MasaIMara() {
        natureReserve = new ArrayList<>();
    }
public void populateReserve(){
    natureReserve.add(new Animal("Lion", 110, 150, 210));
    natureReserve.add(new Animal("Antelope", 140, 80, 160));
    natureReserve.add(new Animal("Hyena", 70, 60, 100));
    natureReserve.add(new Animal("Elephant", 380, 4200, 520));
    natureReserve.add(new Animal("Cheetah", 90, 80, 180));
    natureReserve.add(new Animal("Hippo", 160, 3400, 380));
    natureReserve.add(new Animal("Giraffe", 550, 1900, 450));
```


```
public ArrayList<Animal>getAnimalsHogher(double height){
    ArrayList<Animal> animals = new ArrayList<>();
    for (Animal animal : natureReserve) {
        if (###animal.getHeight() > height###) animals.add(animal);
       }
       return animals;
    }
    
   
```

```
public ArrayList<Animal>getAnimalsHigherAndLonger(double height, double length){
    ArrayList<Animal> animals = new ArrayList<>();
    for (Animal animal : natureReserve) {
        if (###animal.getHeight() > height && animal.getLength() > length###)
            animals.add(animal);
        }
        return animals;
```


Predicate interface


java.util.function
```
public interface Predicate<T> {
    boolean test(T t);
}
```

metoda abstrakcyjna, nie ma zadnego dzialania


```
public class MasaiMara {
    private ArrayList<Animal> natureReserve;
    public MasaiMara() { natureReserve = new ArrayList<>(); }
    public void populateReserve() { // create the same list of animals }
    
    public ArrayList<Animal> getAnimals(Predicate<Animal> check){
        ArrayList<Animal> animals = new ArrayList<>();
        for (Animal animal : natureReserve) {
        if (check.test(aimal)) animals.add(animal);
        }
        return animals;
        }
        }
```

Implementacja dynamiczna metody test w interfejsie predicate
```
case 1 -> printAnimals(reserve.getAnimals(a -> a.getHeight() > 120));
case 2 -> printAnimals(reserve.getAnimals(a -> a.getLength() > length && a.getWeight() < weight));}
case 3-> {
final double length = 120, weight = 100;
printAnimals(reserve.getAnimals(a -> a,getLength() > length && a.getWeight() < weight));}
```


Lambda syntax, including optional parts

    parameter name                   body

(Animal a) -> { return a.getHeight(); }

        arrow       required because in block
optional parameter type




Wersja skrocona


a -> a.getHeight()


LocalDate - contains just a date - no time and no time zone
LocalTime - contains just a time - no date and no time zone
LocalFateTime - contains both a date and time but no time zone

klasa Period

klasa Duration

```
public static void main(String[] args) {
    String ###name#### = "Webby";
    speak(name);
    System.out.println(name);   // Webby
}
public static void speak(String name) {
    name = "Sparky";
}
```

pass by value - przekazywanie przez wartość


# Przeciążanie metod #

public void fly(int numMiles) {}
public void fly(short numFeet) {}
public boolean fly() {return false};

public void fly(int numMiles) {
    System.out.println("int");
}

public void fly(short numFeet) {
    System.out.println("short");}

fly((short) 1); prints short
fly(() 1); prints int


Exact match by type     public String glide(int i, int j) {}
Larger primitive type public String glide (long i, long j) {}
Autoboxed type  public String glide (Integer i, Integer j) {}
Varargs         public String glide(int ...nums) {}

w przypadku typow referencyjnych zawsze mozemy skorzystac z typu wyzszego
w hierarchii dziedziczenia - metoda klasy nadrzednej