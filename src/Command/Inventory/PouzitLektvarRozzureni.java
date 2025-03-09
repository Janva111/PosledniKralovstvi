package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitLektvarRozzureni extends Command {
    private Army army;
    private Inventory inventory;

    public PouzitLektvarRozzureni(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        if (inventory.getItemsOwned().contains("LektvarRozzureni")) {
            army.bonusStrenght(1.10);
            inventory.removeItem("LektvarRozzureni");
            System.out.println("Lektvar Rozzureni byl pouzit");
        }else {
            System.out.println("Lektvar Rozzureni neni v tvem inventari");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
