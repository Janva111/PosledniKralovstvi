package Game.Map.Cities;

import Game.Map.City;

import java.util.ArrayList;

public class Hellas extends City {
    public Hellas(String name, int strenght, int health, boolean isTaken, ArrayList<String> legalCities) {
        super(name, strenght, health, isTaken, legalCities);
    }
}
