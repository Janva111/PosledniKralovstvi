package Command.Trader;

import Command.Command;
import Game.Trader;

public class OdejitOdObchodnika extends Command {
    private static Trader trader;

    public OdejitOdObchodnika (Trader trader){
        this.trader = trader;
    }

    @Override
    public String execute() {
        if (trader.isTalking()){
            trader.setTalking(false);
            trader.removeItems();
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
