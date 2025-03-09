package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitElixirOdolnosti extends Command {
    @Override
    public String execute() {
        Army army = new Army();
        Inventory inventory = new Inventory();
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