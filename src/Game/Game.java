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


        if (!loadMap.loadMap()){
            System.out.println("Load map failed");
            return;
        }

        City startLocation = loadMap.findCity("hellas");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return;
        }
        this.game = new Game(startLocation);
        Console console = new Console();
        console.start(army, inventory, trader, items, fight, game,loadMap);

    }

    public void showAvailableMovements(){
        System.out.println("Muzes jit:");
        for (String legalCities : currentCity.getLegalCities()){
            System.out.println("- "+ legalCities);
        }
    }

    public boolean move(City toGo) {
        if (currentCity.canMoveTo(toGo.getName())) {
            currentCity = toGo;
            return true;
        }else {
            System.out.println("Jdes nekam co neexistuje :(");
            return false;
        }
    }




    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public City getCurrentCity() {
        return currentCity;
    }
}
