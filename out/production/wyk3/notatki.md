operatory i ich kolejnosc w javie - poczytać
zwłaszcza +, -, !, ~ (type) -- operator rzutowania
tak samo instance of oraz ternary operators i operator potrójny, --y oraz y--

jezeli mamy zmienną węższego typu, to do zmiennej szerszego typu można ją przypisać
jeżeli szerszego, a jej wartość przypisać do zmiennej typu wężśzego, to musimy jawnie rzutować wartość na węższy typ
słuzy zarowno do ruztowania wartosci w typach podstawowych, ale wartosci w typach referencyjnych

casting primitive values


jezeli dodajemy rozne typy java automatycznie promuje węższy do szerszego, doda i wynik zwroci jako szerszy typ

2 liczby typu short - promocja na int i zwraca inta

value = booleanExpression ? expression1 : expresion2;

for each in java
```
for (datatype instance : collection) {
// body
}
```

```
int[][] myConplexArray = {{5,2,1,3},{3,9}};
for(int[] mySimpleArray : myComplexArray) {
    for (int i : mySimpleArray) {
        sout(i + "\t");
        }
    sout();
}
```

`String name = new String("Grupa 2151C");` - można i tak

jezeli tworzymy obiekt piszac lancuch znakow, java sprawdzi czy ma taki obiekt w puli, jezeli ma, to
przypisze tylko referencje - jezeli nie - to utworzy obiekt.
chyba ze jawnie utworzymy , to wtedy utworzy obiekt

jezeli dodamy 2 stringi "1" + "2" to zwroci "12"

```
sout(1 + 2 + "c"); // 3c
sout("c" + 1 + 2); // c12

int three = 3;
String four = "4"
sout(1 + 2 + three + four);;
// output: "64"
```

obiekty klasy string są niezmienialne
```
s += "2" to samo co s = s + "2"

String s = "1";
s += "2";
s += 3;
sout(s); // 123
```
^ za kazdym razem powstaje nowy obiekt

,

powstanie obiekt 123 ale nie bedzie zadnej referencji do niego
```
String s1 = "1";
String s2 = s1.concat("2");
s2.concat("3";
sout(s2);
```


zestaw metod  klasa String
```
length() -- zwraca ilosc characterów w stringu
charAt(int index) -- zwraca character w danym
indexOf(char ourChar)
String substring(int beginIndex)
toLowerCase()
toUpperCase()
equals() oraz equealsIgnoreCase()
startsWith() oraz endsWith()
replace()
contains()
trim()
strip()
stripLeading() oraz stripTrailing()
intern()
```
przykład
```
String start = "AniMaL       ";
String trimmed = start.trim(); // "AniMaL"
String lowercase = trimmed.toLowerCase(); // "animal"
String result = lowercase.replace('a', 'A'); // "Animal"
```
ale można i tak:
```
String result = "AniMaL   ".trim().toLowerCase().replace('a','A');
sout(result);
```

Jest klasa StringBuilder w której można wykonywać przeróżne działania na obiektach. Warto później dać `.toString()`

nie uzywac x == y dla stringów
```
String x = "Hello World";
String y = " Hello World".trim();
sout(x == y); // false - nie zadziała. uzywamy x.equals(y) lub equalsIgnoreCsse
```

metoda toString()