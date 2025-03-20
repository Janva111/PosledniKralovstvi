package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;
import Game.Inventory;

import java.util.Random;

/**
 * Command to liberate citizens and recruit them into the player's army.
 * This command can only be executed if the current city is taken (controlled).
 * It recruits a random number of citizens, updates the player's army, and applies any available items.
 */
public class Osvobodit extends Command {

    private static Game game;
    private static Army army;
    private static Inventory inventory;

    public Osvobodit(Game game, Army army, Inventory inventory) {
        this.game = game;
        this.army = army;
        this.inventory = inventory;
    }

    /**
     * Executes the liberation command. If the current city is taken, it recruits a random number of citizens,
     * updates the army size, strength, defense, and health accordingly, and applies items from the inventory
     * to improve the army. The player is notified of the number of citizens recruited.
     *
     * @return A string indicating the end of the operation and the number of citizens liberated.
     */
    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            Random rand = new Random();
            int size = rand.nextInt(100) + 100;
            army.changeSize(size);
            army.setDefense();
            army.setMaxHealth();
            army.setStrenght();
            inventory.useItems(army);
            System.out.println("Osvobodil si " + size + " zajatých občanů země Valtheris.");
        } else {
            System.out.println("Tuto možnost nelze provést. Město není obsazeno.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
