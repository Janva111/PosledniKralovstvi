package Command.Console;

import Command.Command;
import Command.Inventory.*;
import Command.Others.*;
import Command.Trader.KoupitPredmet;
import Command.Trader.MluvitSObchodnikem;
import Command.Trader.OdejitOdObchodnika;
import Command.Trader.ProdatPredmet;
import Game.*;
import Game.Map.LoadMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * The Console class manages the game's user interface in the console, allowing the player to execute commands
 * during gameplay. It acts as the central command dispatcher, mapping user input to specific game actions and
 * displaying results. The class supports a variety of game commands such as moving, interacting with traders,
 * managing inventory, and more.
 */
public class Console {

    private static Army army;
    private static Inventory inventory;
    private static Trader trader;
    private static Items items;
    private static Game game;
    private static LoadMap loadMap;

    private boolean exit = false;
    private HashMap<String, Command> mapOfCommands = new HashMap<>();
    public static String commandList = "commandHistori.txt";

    /**
     * Initializes the command map with the available commands in the game.
     * Each command corresponds to a specific game action, such as moving, using items, or interacting with traders.
     *
     * @param army The player's army.
     * @param inventory The player's inventory.
     * @param trader The trader with the player can interact.
     * @param items The collection of items in the game.
     * @param game The game instance managing the current game state.
     * @param loadMap The map used to navigate between cities.
     */
    public void inicialization(Army army, Inventory inventory, Trader trader, Items items, Game game, LoadMap loadMap) {
        mapOfCommands.put("pohyb", new Pohyb(game, loadMap));
        mapOfCommands.put("armada", new Armada(army));
        mapOfCommands.put("ukoncit", new Ukoncit());
        mapOfCommands.put("prikazy", new Prikazy());
        mapOfCommands.put("inventar", new Inventar(inventory));
        mapOfCommands.put("pouzit elixir odolnosti", new PouzitElixirOdolnosti(army, inventory));
        mapOfCommands.put("pouzit lektvar rozzureni", new PouzitLektvarRozzureni(army, inventory));
        mapOfCommands.put("pouzit ozdravovaci totem", new PouzitOzdravovaciTotem(army, inventory));
        mapOfCommands.put("mluvit s obchodnikem", new MluvitSObchodnikem(trader, game));
        mapOfCommands.put("odejit od obchodnika", new OdejitOdObchodnika(trader));
        mapOfCommands.put("osvobodit", new Osvobodit(game, army,inventory));
        mapOfCommands.put("koupit predmet", new KoupitPredmet(trader, inventory));
        mapOfCommands.put("prodat predmet", new ProdatPredmet(trader, inventory));
        mapOfCommands.put("pomoc", new Pomoc(game));
        mapOfCommands.put("rabovat", new Rabovat(game,inventory,items));
        mapOfCommands.put("bojovat", new Bojovat(army, game, loadMap, inventory));

        // add commands
    }

    private Scanner scanner = new Scanner(System.in);

    /**
     * Reads the user's input, executes the corresponding command, and handles game logic.
     * It saves the command history to a file and checks if the command exists in the map of commands.
     */
    private void make() {
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommad(command);
        if (mapOfCommands.containsKey(command)) {
            System.out.println(">> " + mapOfCommands.get(command).execute());
            exit = mapOfCommands.get(command).exit();
        } else {
            System.out.println(">> Tento příkaz není v této hře." + "\n" + "--------------------------------------------------------");
        }
    }

    /**
     * Starts the game by initializing the necessary objects and running the command loop.
     * The loop continues to prompt for commands until the game exit condition is met.
     *
     * @param army The player's army.
     * @param inventory The player's inventory.
     * @param trader The trader with the player can interact.
     * @param items The collection of items in the game.
     * @param game The game instance managing the current game state.
     * @param loadMap The map used to navigate between cities.
     */
    public void start(Army army, Inventory inventory, Trader trader, Items items, Game game, LoadMap loadMap) {
        inicialization(army, inventory, trader, items, game, loadMap);
        try {
            do {
                make();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Saves the executed command to the command history to file "commandHistorie.txt.
     *
     * @param command The command executed by the player.
     */
    private void saveCommad(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(commandList, true))) {
            bw.write(command);
            bw.newLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
