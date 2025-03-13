package Game.Map;

import Game.Map.Cities.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class LoadMap {

    public ArrayList<City> map = new ArrayList<>();
    private HashMap<String, City> cities;


    public LoadMap() {
        cities = new HashMap<>();
    }

    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cities.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                // nacte zakladni info
                String cityName = split[0];
                int strenght = Integer.parseInt(split[1]);
                int health = Integer.parseInt(split[2]);
                boolean isTaken = Boolean.parseBoolean(split[3]);
                ArrayList<String> legalCities = new ArrayList<>();

                for (int i = 4; i < split.length; i++) { // sousedy
                    legalCities.add(split[i].trim());
                }

                City city = createCity(cityName, strenght, health, isTaken, legalCities);
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

    private City createCity(String cityName, int strength, int health, boolean isTaken, ArrayList<String> legalCities) {
        switch (cityName.toLowerCase()) {
            case "hellas":
                return new Hellas(cityName, strength, health, isTaken, legalCities);
            case "argolis":
                return new Argolis(cityName, strength, health, isTaken, legalCities);
            case "delos":
                return new Delos(cityName, strength, health, isTaken, legalCities);
            case "lakedaimon":
                return new Lakedaimon(cityName, strength, health, isTaken, legalCities);
            case "miradell":
                return new Miradell(cityName, strength, health, isTaken, legalCities);
            case "nythrador":
                return new Nythrador(cityName, strength, health, isTaken, legalCities);
            case "solmora":
                return new Solmora(cityName, strength, health, isTaken, legalCities);
            case "sylvaria":
                return new Sylvaria(cityName, strength, health, isTaken, legalCities);
            default:
                return null;
        }
    }

    public City findCity(String cityName) {
        for (City city : map) {
            if (city.name.equalsIgnoreCase(cityName)) {
                return city;
            }
        }
        return null;
    }

    public HashMap<String, City> getCities() {
        return cities;
    }

    public void setCities(HashMap<String, City> cities) {
        this.cities = cities;
    }
}
