package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

/**
 * Command to use a potion of rage to increase the army's strength.
 * This command applies a strength bonus to the player's army and removes the potion from the inventory.
 */
public class PouzitLektvarRozzureni extends Command {
    private Army army;
    private Inventory inventory;

    public PouzitLektvarRozzureni(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }

    /**
     * Executes the command to use a potion of rage on the army.
     * The potion grants a 10% increase in the army's strength and removes the potion from the inventory.
     *
     * @return A string indicating the completion of the action.
     */    @Override
    public String execute() {
            army.bonusStrenght(1.50);
            Items delete = inventory.findItem("lektvarrozzureni");
            System.out.println("Lektvar Rozzureni byl pouzit");
            inventory.getItemsOwned().remove(delete);

        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
