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
    private ArrayList<String> legalCities = new ArrayList<>();
    private ArrayList<City> cityList = new ArrayList<>();

    public boolean loadMap(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Map.txt"));
            String line;
            while((line = br.readLine()) != null){
                String[] split = line.split(";");
                for (int i = 3; i < split.length; i++){
                    legalCities.add(split[i]);
                }
                switch (split[0]){
                    case "Hellas":
                        Hellas hellas = new Hellas(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(hellas);
                    case "Argolis":
                        Argolis argolis = new Argolis(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(argolis);
                    case "Lakedaimon":
                        Lakedaimon lakedaimon = new Lakedaimon(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(lakedaimon);
                    case "Miradell":
                        Miradell miradell = new Miradell(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(miradell);
                    case "Nythrador":
                        Nythrador nythrador = new Nythrador(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(nythrador);
                    case "Solmora":
                        Solmora solmora = new Solmora(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
                        cityList.add(solmora);
                    case "Sylvaria":
                        Sylvaria sylvaria = new Sylvaria(split[0],Integer.parseInt(split[1]), Integer.parseInt(split[2]),legalCities);
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
