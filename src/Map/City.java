package Map;

import java.util.ArrayList;

public class City {

    protected String name;
    protected ArrayList<String> legalCities = new ArrayList<>();
    protected int strenght;
    protected int health;

    public City(String name, int strenght, int health, ArrayList<String> legalCities) {
        this.name = name;
        this.legalCities = legalCities;
        this.strenght = strenght;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getLegalCities() {
        return legalCities;
    }

    public void setLegalCities(ArrayList<String> legalCities) {
        this.legalCities = legalCities;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
