package Animals;

public class Predator extends AnimalAbstract {
    public Predator() {
        name = "Хищник";
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }
}
