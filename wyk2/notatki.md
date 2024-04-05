pakiety
klasy od wielkiej litery (camelcase)

import java.util.Random; - importuje pojedynczą klasę random
import java.util.* - importuje wszystkie klasy pakietu util



tworzenie pakietu i importowanie klasy do innego pakietu (obydwie klasy)
^ obydwie klasy muszą być publiczne

package packageA;

public class ClassA {
}


package packageB;

import packageA.ClassA;

public class ClassB {
    public static void main(String[] args) {
        ClassA a; // na razie tu sie nie tworzy nowy obiekt - nie ma slowa new
        System.out.println("Got it");
}
}

PIC - w takiej kolejności

element required
package no
import  no
class   yes
field   no
method  no

jesli nie ustalę poziomu dostępu to package domyslnie jest private

zmienne, konstruktory, metody < w takiej kolejnosci

jezeli wiecej niz jedna klasa jest w jednym pliku, to maksymalnie jedna klasa moze być public

podstawowe typy danych:
boolean - true or false
byte - 8 bit integer value
short - 16 bit
int - 32 bit
long - 64 bit
float - 32 bit floating  - 123.45f
double - 64 bit floating - 123.456
char - 16 bit unicode

byte - 256 > -128 do 127
short - 65 536
int - 2 ^ 32
long - 2 ^ 64

deklaracja zmiennych:

java.util.Date today; < typ data
String greeting; < typ string

today = new java.util.Date();

greeting = new String("How are you?");

do zmiennej referencyjnej możemy przypisać wartość null

konwencja nazewnictwa


!!!
CamelCase for class names, e.g. MyClass,
lowerCamelCase for variable, mathod, package names, e.g., myVariable
snake_case with uppercaseletters for constants (static final) e.g., THIS_IS_A_CONSTANT,
snake_case with uppercase letters for enum values, e.g., Color.RED, Color.DARK_GRAY
!!!


this odwoluje sie do obiektu danej klasy
super odwolujemy sie do obiektow klasy, ale mozemy wskazac elementy ktore odziedziczylismy po klasie nadrzędnej

switch - proszę poczytać o instrukcji 
abstract - klasy i metody abstrakcyjne 
interface - konstrukcje ktore nie dostarczaja implementacji
implements - implementujemy klasy
extends - dziedziczymy, rozszerzamy klasy

zmienne są domyślnie inicjowane:
boolean                                   false
byte, short, int, long                    0
float, double                             0.0
char '\u0000'                             (NUL)
All object references (everything else)   null


jezeli uzyjemy var to nalezy zainicjować zmienną od razu

garbage collector