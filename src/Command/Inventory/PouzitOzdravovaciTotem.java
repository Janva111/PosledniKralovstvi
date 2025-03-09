package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitOzdravovaciTotem extends Command {
    private Army army;
    private Inventory inventory;

    public PouzitOzdravovaciTotem(Army army, Inventory inventory) {
        this.army = army;
        this.inventory = inventory;
    }
    @Override
    public String execute() {
        if (inventory.getItemsOwned().contains("ozdravovaciTotem")) {
            army.healing(500);
            inventory.removeItem("ozdravovaciTotem");
            System.out.println("Ozdravovaci Totem byl pouzit");
        }else {
            System.out.println("Ozdravovaci Totem neni v tvem inventari");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
