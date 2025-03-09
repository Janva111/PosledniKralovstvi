package Command.Trader;

import Command.Command;
import Game.Trader;

public class Obchodnik extends Command {
    @Override
    public String execute() {
        Trader trader = new Trader();
        trader.setTalking(true);
        System.out.println("Vítej u obchodníka, zde můžeš vydět jeho nabídku: " + trader.toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
