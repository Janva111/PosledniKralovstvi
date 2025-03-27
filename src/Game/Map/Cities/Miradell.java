package Game.Map.Cities;

import Game.Map.City;

import java.util.ArrayList;

/**
 * Represents the city of Mirradel, which is a specific type of city in the game.
 * This class extends atributes from class city
 */
public class Miradell extends City {
    public Miradell(String name, int strenght, boolean isTaken, ArrayList<String> legalCities) {
        super(name, strenght, isTaken, legalCities);
    }

}
