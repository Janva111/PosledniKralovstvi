package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

import java.util.Random;

/**
 * Command to use a healing totem on the player's army.
 * This command allows the player to use a healing totem to restore health to their army.
 */
public class PouzitOzdravovaciTotem extends Command {
    private Army army;
    private Inventory inventory;
    private Random rand = new Random();

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
        int health = rand.nextInt(200)+500;
        army.healing(health);
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
