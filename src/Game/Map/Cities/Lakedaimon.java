package Game.Map.Cities;

import Game.Map.City;

import java.util.ArrayList;

public class Lakedaimon extends City {
    public Lakedaimon(String name, int strenght, int health,boolean isTaken, ArrayList<String> legalCities) {
        super(name, strenght,health, isTaken, legalCities);
    }
}
