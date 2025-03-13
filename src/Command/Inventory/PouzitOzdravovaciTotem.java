package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

public class PouzitOzdravovaciTotem extends Command {
    private static Army army;
    private static Inventory inventory;

    public PouzitOzdravovaciTotem(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }

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
