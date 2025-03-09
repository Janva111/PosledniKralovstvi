package Command.Inventory;

import Command.Command;

public class Inventar extends Command {
    @Override
    public String execute() {
        System.out.println("Toto je tvuj inventar: " + toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
