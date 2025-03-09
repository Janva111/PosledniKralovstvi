package Command.Trader;

import Command.Command;
import Game.Inventory;
import Game.Trader;

public class KoupitPredmet extends Command {
    Trader trader;
    Inventory inventory;

    public KoupitPredmet(Trader trader, Inventory inventory) {
        this.trader = trader;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
