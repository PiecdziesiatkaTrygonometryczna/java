private - protected

final - nikt nie będzie mógł dziedziczyć
sealed classes - klasy zapieczętowane - jeżeli chcemy dopuścić dziedziczenie,
musimy jasno określić, jakim klasom pozwalamy na to

```
sealed class BigCat permits Panthera {
    protected double size;
}
public final class Panthera extends BigCat {
    public Panthera(double size){ this.size = size; }
    public void printDetails(){ System.out.println(size); }
}
```
non-sealed - z tej klasy moze sie rozszerzc


Deklaracje klasy animal
```dtd
public class Animal {}

public class Animal extends java.lang.Object {}
```
this() - wywolanie konstruktora w tej samej klasie
super() - wywolanie konstruktora z nadklasy  
pierwsza niezakomentowana linia powinna to byc

```dtd
public class Donkey {
}
public class Donkey {
    public Donkey() {
    }
}
```
```dtd
public class Donkey {
    public Donkey() {
    super();
    }
}
```

przesłanianie metod
```java
public class Predator {
    public double getAverageWeight() {
        return 50; }
    }

public class Wolf extends Predator {
    public double getAverageWeight() {
        return super.getAverageWeight() + 20;
    }
}
public static void main(String[] args) {
    System.out.println(new Predator().getAverageWeight());
    System.out.println(new Wolf().getAverageWeight());
}
```

Reguły dla przesłaniania  
0. Musi to być metoda, która nie jest prywatna
1. Musi mieć taką samą sygnaturę - ta sama nazwa, ta sama lista parametrów
2. Musi być przynajmniej tak samo dostępna
3. Nie może zwracać nowego wyjątku checked exception albo szerszego.
4. Dokładnie ten sam typ zwracany, lub podklasa tego typu. - kowariantne typy danych.

Oprócz przesłaniania metod, możemy je też redeklarować
Dotyczy tylko metod, ktore maja modyfikator dostępu private

hiding static methods - dotyczy metod statycznych


```java
class Marsupial {
    public boolean isBiped() {
        return false;
    }
    public void getMarsupialDescription() {
        System.out.println("Marsupial walks on two legs: " + isBiped());
    }
}
public class Kangaroo extends Marsupial {
    public boolean isBiped() {
        return true;
    }
    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: "+isBiped());
    }
    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: "+isBiped());
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        joey.getMarsupialDescription();
        joey.getKangarooDescription();
    }
}
```

Zostanie wypisane 2 razy `true`

POLIMORFIZM

- Jeżeli mamy zmienną typu string to możmey przypisać łancuch znakow do tej zmiennej,
bo typ jest pasujący
-  Referencja może być określona jako zmienna typu nadklasy
- referencja może być typu interfejsu, który ta klasa implementuje bezpośrednio,
lub poprzez nadklasę

```java
public class Primate {
    public boolean hasHair() { return true;}
}
public interface HasTail {
    public boolean isTailStriped();
}
public class Lemur extends Primate implements HasTail {
    private int age = 10;
    public int getAge() {return age;}
    public boolean isTailStriped() { return true;}
}
```

Trzeba zastosować operacje rzutowania - pod warunkiem że pod tym jest odopowiedni
obiekt

Jeśli mamy zmienną typu referencyjnego chleb, tylko i wyłącznie obiekt klasy

Pieczywo nowaZmienna = ?
!! nowaZmienna = new Pieczywo();
nowaZmienna = new Chleb();
nowaZmienna = new Tost();