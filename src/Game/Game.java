package Game;

import Command.Console.Console;
import Command.Others.Prikazy;
import Game.Map.City;
import Game.Map.LoadMap;

/**
 * Represents the main game logic, including managing the game world.
 * Handling the player's inventory, army, and interactions within the game.
 * Control loading of map.
 * Contains movement.
 */

public class Game {

    private City currentCity;

    private LoadMap loadMap = new LoadMap();
    private Army army;
    private Inventory inventory;
    private Trader trader;
    private Items items;
    private Game game;
    private boolean isRunning;

    public Game() {

    }

    public Game(City startingCity) {
        this.currentCity = startingCity;
        this.isRunning = false;
    }

    /**
     * Starts the game by initializing the game world, inventory, army, and trader.
     * Print the starting text and commands for game.
     * Loads the map and check if it was succesfull
     * Load items and check if it was successful
     * Load starting army size and check if it was successful
     * Load starting balance and check if it was successful
     * Sets the starting city.
     * Invoke the console interface.
     *
     * @return
     */

    public boolean startGame() {
        this.loadMap = new LoadMap();
        this.inventory = new Inventory();
        this.army = new Army();
        this.items = new Items();
        this.trader = new Trader(items);

        // starting text
        System.out.println("Vítej ve hře POSLEDNÍ KRÁLOVSTVÍ");
        System.out.println("--------------------------------------------------------");
        Prikazy prikazy = new Prikazy();
        prikazy.execute();
        System.out.println("--------------------------------------------------------");

        // Load map and check if it was successful
        if (!loadMap.loadMap()) {
            System.out.println("Load map failed");
            return false;
        }

        // Load items and check if it was successful
        if (!items.loadItems()){
            System.out.println("Load items failed");
            return false;
        }

        // Load starting balance and check if it was successful
        if (!inventory.loadBalance()){
            System.out.println("Load inventory failed");
            return false;
        }

        // create starting location
        City startLocation = loadMap.findCity("Argolis");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return false;
        }

        this.game = new Game(startLocation);
        Console console = new Console();
        console.start(army, inventory, trader, items, game, loadMap);
        return true;
    }


    /**
     * Shows the available movements from the current city.
     */
    public void showAvailableMovements() {
        System.out.println("Muzes jit:");
        for (String legalCities : currentCity.getLegalCities()) {
            System.out.println("- " + legalCities);
        }
    }

    /**
     * Moves the player to a new city if the movement is allowed.
     *
     * @param toGo The city to move to.
     * @return true if the movement was successful, otherwise false.
     */
    public boolean move(City toGo) {
        if ((currentCity.canMoveTo(toGo.getName())&& currentCity.isTaken() == true ) || (currentCity.canMoveTo(toGo.getName()) && toGo.isTaken() == true)) {
            currentCity = toGo;
            return true;
        }
        return false;
    }



    public void setCurrentCity(City currentCity) {
        this.currentCity = currentCity;
    }

    public City getCurrentCity() {
        return currentCity;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public Items getItems() {
        return items;
    }

    public Trader getTrader() {
        return trader;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Army getArmy() {
        return army;
    }

    public LoadMap getLoadMap() {
        return loadMap;
    }
}
