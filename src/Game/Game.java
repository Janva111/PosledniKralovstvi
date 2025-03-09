package Game;

import Command.Console.Console;
import Game.Map.City;
import Game.Map.LoadMap;

public class Game {

    private City currentCity;

    private LoadMap loadMap = new LoadMap();
    private Army army;
    private Inventory inventory;
    private Trader trader;
    private Items items;
    private Fight fight;
    private Movement movement;
    private Game game;

    public Game(){

    }

    public Game(City startingCity){
        this.currentCity = startingCity;
    }

    public void startGame(){
        this.loadMap = new LoadMap();
        this.inventory = new Inventory();
        this.army = new Army();
        this.items = new Items();
        this.fight = new Fight();
        this.trader = new Trader(items);
        this.game = new Game(loadMap.findCity("hellas"));
        this.movement = new Movement(game,loadMap);


        if (!loadMap.loadMap()){
            System.out.println("Load map failed");
            return;
        }

        Console console = new Console();
        console.start(army, inventory, trader, items, fight);

    }

    public void showAvailableMovements(){
        System.out.println("Muzes jit:");
        for (String legalCities : currentCity.getLegalCities()){
            System.out.println("- "+ legalCities);
        }
    }

    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public City getCurrentCity() {
        return currentCity;
    }
}
