package Command.Trader;

import Command.Command;
import Game.Trader;

public class Obchodnik extends Command {
    Trader trader;
    public Obchodnik(Trader trader) {
        this.trader = trader;
    }
    @Override
    public String execute() {
        trader.setTalking(true);
        System.out.println("Vítej u obchodníka, zde můžeš vydět jeho nabídku: " + trader.toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
