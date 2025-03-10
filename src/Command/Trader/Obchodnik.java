package Command.Trader;

import Command.Command;
import Game.Game;
import Game.Trader;

public class Obchodnik extends Command {
    private static Trader trader;
    private static Game game;

    public Obchodnik(Trader trader, Game game) {
        this.trader = trader;
        this.game = game;
    }

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            trader.setTalking(true);
            System.out.println("Vítej u obchodníka, zde můžeš vydět jeho nabídku: " + trader.toString());
        } else {
            System.out.println("Tuto možnost nelze provést. Město není obdazeno.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
