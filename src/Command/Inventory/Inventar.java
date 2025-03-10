package Command.Inventory;

import Command.Command;
import Game.Inventory;

public class Inventar extends Command {
    private static Inventory inventory;

    public Inventar(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        System.out.println("Toto je tvuj inventar: " + inventory.toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
