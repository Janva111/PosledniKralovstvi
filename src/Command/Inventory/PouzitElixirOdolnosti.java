package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

/**
 * Command to use a durability elixir to increase the army's defense.
 * This command applies a defense bonus to the player's army and removes the elixir from the inventory.
 */
public class PouzitElixirOdolnosti extends Command {
    private Army army;
    private Inventory inventory;

    public PouzitElixirOdolnosti(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }


    /**
     * Executes the command to use a durability elixir on the army.
     * The elixir grants a 20% increase in the army's defense and removes the elixir from the inventory.
     *
     * @return A string indicating the completion of the action.
     */
    @Override
    public String execute() {
        army.bonusDefense(1.20);
        Items delete = inventory.findItem("elixirodolnosti");
        System.out.println("Elixir Odolnosti byl pouzit");
        inventory.getItemsOwned().remove(delete);
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}