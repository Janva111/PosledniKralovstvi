package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

public class PouzitLektvarRozzureni extends Command {
    private static Army army;
    private static Inventory inventory;

    public PouzitLektvarRozzureni(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
            army.bonusStrenght(1.10);
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
