package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitItemy extends Command {
    private static Inventory inventory;
    private static Army army;

    public PouzitItemy(Inventory inventory, Army army) {
        this.inventory = inventory;
        this.army = army;
    }

    @Override
    public String execute() {
        inventory.useItems(army);
        System.out.println("Vyzbrojil jsi svou armádu, dobrá práce. :)");
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
