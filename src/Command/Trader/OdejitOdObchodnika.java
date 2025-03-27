package Command.Trader;

import Command.Command;
import Game.Trader;

import java.util.ArrayList;

/**
 * Command to leave the trader after interacting with them.
 * This command ends the conversation with the trader, clears their items,
 * and updates the state to reflect that the player is no longer talking to the trader.
 */
public class OdejitOdObchodnika extends Command {
    private Trader trader;

    public OdejitOdObchodnika (Trader trader){
        this.trader = trader;
    }

    /**
     * Executes the command to leave the trader.
     * If the player is currently talking to the trader, the conversation is ended.
     * The trader's items are cleared, and the player is no longer in a conversation with the trader.
     * The trader's items are cleared, and the player is no longer in a conversation with the trader.
     *
     * @return A message indicating the completion of the action.
     */
    @Override
    public String execute() {
        if (trader.isTalking()){
            trader.setTalking(false);
            trader.deleteItem();
            System.out.println("Odešel jsi od obchodníka.");
        }else {
            System.out.println("Nelze odejit od obchodnika, když s ním nemluvíš.");
        }
        return "--------------------------------------------------------";
    }


    @Override
    public boolean exit() {
        return false;
    }
}
