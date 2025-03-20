package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

/**
 * Command to use a healing totem on the player's army.
 * This command allows the player to use a healing totem to restore health to their army.
 */
public class PouzitOzdravovaciTotem extends Command {
    private static Army army;
    private static Inventory inventory;

    public PouzitOzdravovaciTotem(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }


    /**
     * Executes the command to use a healing totem on the army.
     * It restores 500 health to the army and removes the healing totem from the inventory.
     *
     * @return A string indicating the completion of the action.
     */
    @Override
    public String execute() {
        army.healing(500);
        Items delete = inventory.findItem("ozdravovacitotem");
        System.out.println("Ozdravovací Totem byl pouzit");
        inventory.getItemsOwned().remove(delete);
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
