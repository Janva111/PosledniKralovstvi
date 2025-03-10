package Game.Map;

import java.util.ArrayList;

public class City {

    protected String name;
    protected ArrayList<String> legalCities;
    protected boolean isTaken;
    protected int strenght;
    protected int health;

    public City(String name, int health, int strenght, boolean isTaken, ArrayList<String> legalCities) {
        this.name = name;
        this.legalCities = legalCities;
        this.strenght = strenght;
        this.isTaken = isTaken;
        this.health = health;
    }

    public boolean canMoveTo(String goTo){
        return legalCities.contains(goTo);
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

    public boolean isTaken() {
        return isTaken;
    }


}

