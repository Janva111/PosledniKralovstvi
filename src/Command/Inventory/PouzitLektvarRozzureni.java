package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitLektvarRozzureni extends Command {
    @Override
    public String execute() {
        Army army = new Army();
        Inventory inventory = new Inventory();
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
