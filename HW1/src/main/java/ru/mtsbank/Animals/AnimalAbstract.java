package Animals;

import Interfaces.IAnimal;

public abstract class AnimalAbstract implements IAnimal  {
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    public abstract String getBreed();
    public abstract String getName();
    public abstract Double getCost();
    public abstract String getCharacter();

}
