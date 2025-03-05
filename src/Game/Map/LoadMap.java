package Game.Map;

import Game.Map.Citys.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadMap {

    private String start = "Hellas";
    private String currentPosition = start;
    private ArrayList<String> legalCities;
    private ArrayList<City> cityList = new ArrayList<>();

    public boolean loadMap() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Map.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                switch (split[0]) {
                    case "Hellas":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Hellas hellas = new Hellas(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(hellas);
                    case "Argolis":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Argolis argolis = new Argolis(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(argolis);
                    case "Lakedaimon":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Lakedaimon lakedaimon = new Lakedaimon(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(lakedaimon);
                    case "Miradell":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Miradell miradell = new Miradell(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(miradell);
                    case "Nythrador":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Nythrador nythrador = new Nythrador(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(nythrador);
                    case "Solmora":
                        for (int i = 3; i < split.length; i++) {
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Solmora solmora = new Solmora(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(solmora);
                    case "Sylvaria":
                        for (int i = 3; i < split.length; i++){
                            legalCities = new ArrayList<>();
                            legalCities.add(split[i]);
                        }
                        Sylvaria sylvaria = new Sylvaria(split[0], Integer.parseInt(split[1]), Integer.parseInt(split[2]), legalCities);
                        cityList.add(sylvaria);
                    default:
                        System.out.println("Something went wrong with Map file");
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
