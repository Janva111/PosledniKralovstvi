package Game;

import Command.Console.Console;
import Command.Others.Prikazy;
import Game.Map.City;
import Game.Map.LoadMap;

public class Game {

    private City currentCity;

    private LoadMap loadMap = new LoadMap();
    private Army army;
    private Inventory inventory;
    private Trader trader;
    private Items items;
    private Game game;

    public Game() {

    }

    public Game(City startingCity) {
        this.currentCity = startingCity;
    }

    /**
     * Starts the game by initializing the game world, inventory, army, and trader.
     * Print the starting text and commands for game.
     * Loads the map and check if it was succesfull
     * Sets the starting city.
     * Invoke the console interface.
     */

    public void startGame() {
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
            return;
        }

        // create starting location
        City startLocation = loadMap.findCity("hellas");
        if (startLocation == null) {
            System.out.println("Startovní lokace nebyla nalezena!");
            return;
        }
        this.game = new Game(startLocation);
        Console console = new Console();
        console.start(army, inventory, trader, items, game, loadMap);
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
        } else {
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
