package Animals;

public class Pet extends AnimalAbstract {

    public Pet() {
        name = "Домашние";
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
