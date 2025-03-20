package Game.Map.Cities;

import Game.Map.City;

import java.util.ArrayList;
/**
 * Represents the city of Argolis, which is a specific type of city in the game.
 * This class extends atributes from class city
 */
public class Argolis extends City {
    public Argolis(String name, int strenght, int health, boolean isTaken, ArrayList<String> legalCities) {
        super(name, strenght, health, isTaken, legalCities);
    }
}
