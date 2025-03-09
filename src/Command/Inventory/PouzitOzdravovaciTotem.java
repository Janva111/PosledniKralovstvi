package Command.Inventory;

import Command.Command;
import Game.Army;
import Game.Inventory;

public class PouzitOzdravovaciTotem extends Command {
    @Override
    public String execute() {
        Army army = new Army();
        Inventory inventory = new Inventory();
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
