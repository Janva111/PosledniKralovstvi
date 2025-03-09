package Game;

import Command.Console.Console;
import Game.Map.City;
import Game.Map.LoadMap;

public class Game {

    private City currentCity;

    public Game(){

    }

    public Game(City startingCity){
        this.currentCity = startingCity;
    }

    public void startGame(){
        LoadMap loadMap = new LoadMap();
        Army army = new Army();
        Inventory inventory = new Inventory();
        Trader trader = new Trader();
        Items items = new Items();
        Fight fight = new Fight();
       if (!loadMap.loadMap()){
            System.out.println("Load map failed");
            return;
        }
        // startovni lokace
        City startingCity = loadMap.findCity("hellas");
        if (startingCity == null){
            System.out.println("Starting city not found");
            return;
        }
        Game game = new Game(startingCity);

        //Movement movement = new Movement();
        Console console = new Console();
        console.start(army, inventory, trader, items, fight);

    }

    public void showAvailableMovements(){
        System.out.println("Muzes jit:");
        for (String legalCities : currentCity.getLegalCities()){
            System.out.println("- "+ legalCities);
        }
    }

    public City getCurrentCity() {
        return currentCity;
    }
}
