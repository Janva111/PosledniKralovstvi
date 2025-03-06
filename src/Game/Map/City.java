package Game.Map;

import java.util.ArrayList;

public class City {

    protected String name;
    protected ArrayList<String> legalCities;
    protected int strenght;
    protected int health;

    public City(String name, int health, int strenght, ArrayList<String> legalCities) {
        this.name = name;
        this.legalCities = legalCities;
        this.strenght = strenght;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getLegalCities() {
        return legalCities;
    }

    public int getStrenght() {
        return strenght;
    }

    public int getHealth() {
        return health;
    }
}

