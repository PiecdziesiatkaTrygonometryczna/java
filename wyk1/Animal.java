public class Animal {
    private String name; // name - jest to zmienna instancji

    public Animal(String name){ // konstruktor - nazwa taka sama jak klasa - jeżeli nie ma zarówno void, jak i typu zmiennej - jest to konstruktor klasy
        this.name = name;
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName(){
        return name;
    }

}