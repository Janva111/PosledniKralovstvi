package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;
import Game.Map.LoadMap;

public class Bojovat extends Command {

    private static Army army;
    private static Game game;
    private static LoadMap loadMap;

    public Bojovat(Army army, Game game, LoadMap loadMap) {
        this.army = army;
        this.game = game;
        this.loadMap = loadMap;
    }

    /* commads to use

    - army.controlHealt
    - loadMap.controlWin
    controlovat tyto dve veci po kazdem boji

     */

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken()==false){


        }else{
            System.out.println("Není pořeba bojovat ve městě, které jsi již osvobodil.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
