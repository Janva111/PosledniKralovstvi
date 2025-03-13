package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;
import Game.Items;

public class PouzitElixirOdolnosti extends Command {
    private static Army army;
    private static Inventory inventory;

    public PouzitElixirOdolnosti(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }

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