package Game.Map;

import Game.Map.Cities.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * The LoadMap class is responsible for loading the game map from a file.
 * It creates city objects and establishes connections between them.
 * It controls winnig of the game.
 */

public class LoadMap {

    public ArrayList<City> map = new ArrayList<>();
    private HashMap<String, City> cities;


    public LoadMap() {
        cities = new HashMap<>();
    }

    /**
     * Loads the city data from the "cities.txt" file and initializes the map.
     *
     * @return true if the map was loaded successfully, false otherwise.
     */

    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cities.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                // nacte zakladni info
                String cityName = split[0];
                int strenght = Integer.parseInt(split[1]);
                boolean isTaken = Boolean.parseBoolean(split[2]);
                ArrayList<String> legalCities = new ArrayList<>();

                for (int i = 3; i < split.length; i++) { // sousedy
                    legalCities.add(split[i].trim());
                }

                City city = createCity(cityName, strenght, isTaken, legalCities);
                if (city != null) {
                    cities.put(cityName, city);
                    map.add(city);
                }

            }

            for (City city : map) {
                ArrayList<String> legalCities = city.legalCities; // seznam sousedu
                city.legalCities = new ArrayList<>();// cistit

                for (String cityName : legalCities) {
                    City c = cities.get(cityName);
                    if (c != null) {
                        city.legalCities.add(c.name);// propojeni
                    }
                }

            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a city instance based on its name.
     *
     * @param cityName The name of the city.
     * @param strength The city's strength value.
     * @param isTaken Whether the city is currently taken.
     * @param legalCities A list of cities where the player can go.
     * @return A City object corresponding to the provided name, or null if the name is unknown.
     */
    private City createCity(String cityName, int strength, boolean isTaken, ArrayList<String> legalCities) {
        switch (cityName.toLowerCase()) {
            case "hellas":
                return new Hellas(cityName, strength, isTaken, legalCities);
            case "argolis":
                return new Argolis(cityName, strength, isTaken, legalCities);
            case "delos":
                return new Delos(cityName, strength, isTaken, legalCities);
            case "lakedaimon":
                return new Lakedaimon(cityName, strength, isTaken, legalCities);
            case "miradell":
                return new Miradell(cityName, strength, isTaken, legalCities);
            case "nythrador":
                return new Nythrador(cityName, strength, isTaken, legalCities);
            case "solmora":
                return new Solmora(cityName, strength, isTaken, legalCities);
            case "sylvaria":
                return new Sylvaria(cityName, strength, isTaken, legalCities);
            default:
                return null;
        }
    }

    /**
     * Finds and returns a city by its name.
     *
     * @param cityName The name of the city to find.
     * @return The City object if found, otherwise null.
     */

    public City findCity(String cityName) {
        for (City city : map) {
            if (city.name.equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    /**
     * Checks if the win condition is met (if the city "Miradell" is taken).
     * If the condition is met, the game ends.
     */

    public void controlWin(){
        if (findCity("miradell").isTaken() == true) {
            System.out.println("--------------------------------------------------------" +"\n"+
                    "Uspěšně se ti podařilo sjednotit zemi Valtheris." + "\n" +
                    "Tůj lid je na tebe pišný a celá země slaví." + "\n" +
                    "Dobrá práce, už si jen užij svou slávu.");

            System.exit(0);
        }
    }

    public HashMap<String, City> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, City> cities) {
        this.cities = cities;
    }
}
