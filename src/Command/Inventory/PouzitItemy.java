package Command.Inventory;

import Command.Command;
import Game.Inventory;

public class PouzitItemy extends Command {
    private static Inventory inventory;

    public PouzitItemy(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        inventory.useItems();
        System.out.println("Vyzbrojil jsi svou armádu, dobrá práce. :)");
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
