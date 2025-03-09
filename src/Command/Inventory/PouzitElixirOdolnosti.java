package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitElixirOdolnosti extends Command {
    private Army army;
    private Inventory inventory;

    public PouzitElixirOdolnosti(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }
    @Override
    public String execute() {
        if (inventory.getItemsOwned().contains("ElixirOdolnosti")) {
            army.bonusDefense(1.10);
            inventory.removeItem("ElixirOdolnosti");
            System.out.println("Elixir Odolnosti byl pouzit");
        }else {
            System.out.println("Elixir Odolnosti neni v tvem inventari");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}