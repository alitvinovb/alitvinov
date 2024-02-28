package Animals;

public class Pet extends AnimalAbstract {

    public Pet()
    {
        name = "Домащние";
    }
    public String getBreed()
    {
        return breed;
    }
    public String getName()
    {
        return name;
    }
    public Double getCost()
    {
        return cost;
    }
    public String getCharacter()
    {
        return character;
    }
}
