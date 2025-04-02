package Command.Inventory;

import Command.Command;
import Game.Inventory;

/**
 * Command to show the player's inventory.
 * This command outputs the current state of the player's inventory to the console.
 */
public class Inventar extends Command {
    private Inventory inventory;

    public Inventar(Inventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Executes the command to display the player's inventory.
     * The current state of the inventory is printed to the console.
     *
     * @return A string indicating the completion of the action.
     */
    @Override
    public String execute() {
        System.out.println("Toto je tvuj inventar: " + inventory.toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
