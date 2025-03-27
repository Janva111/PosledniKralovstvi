package Command.Trader;

import Command.Command;
import Game.Game;
import Game.Trader;

/**
 * Command to initiate a conversation with the trader.
 * This command allows the player to talk to the trader if the current city is occupied.
 * It generates items for sale and displays the trader's offer.
 */
public class MluvitSObchodnikem extends Command {
    private Trader trader;
    private Game game;

    public MluvitSObchodnikem(Trader trader, Game game) {
        this.trader = trader;
        this.game = game;
    }

    /**
     * Executes the command to start the conversation with the trader.
     * If the current city is occupied, the trader will be ready to talk, and their items will be generated.
     * The trader's offer will be displayed.
     *
     * @return A message indicating the completion of the action.
     */

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            trader.setTalking(true);
            trader.generateItems();
            System.out.println("Vítej u obchodníka, zde můžeš vydět jeho nabídku: " + trader.toString());
        } else {
            System.out.println("Tuto možnost nelze provést. Město není obsazeno.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
