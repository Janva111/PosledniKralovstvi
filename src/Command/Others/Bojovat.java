package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;
import Game.Map.LoadMap;
import Game.Inventory;
import java.util.Random;

public class Bojovat extends Command {

    private static Army army;
    private static Game game;
    private static LoadMap loadMap;

    private static Inventory inventory;
    private Random random = new Random();


    public Bojovat(Army army, Game game, LoadMap loadMap, Inventory inventory) {
        this.army = army;
        this.game = game;
        this.loadMap = loadMap;
        this.inventory = inventory;
    }

    /* commads to use

    - army.controlHealt
    - loadMap.controlWin
    controlovat tyto dve veci po kazdem boji

     */

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken()==false){
            if(army.getStrenght() > game.getCurrentCity().getStrenght()){
                game.getCurrentCity().setTaken(true);
                game.getCurrentCity().setStrenght(0);
                loadMap.controlWin();
                System.out.println("Podařilo se ti úspěšně dobýt město " + game.getCurrentCity().getName()+ ".\n" +
                        "Dobrá práce, jen tak dál, už jsi o krok blíže k svému úspěchu.");
                int lost = random.nextInt(4)+11;
                army.changeSize(-1*(army.getSize()/lost));
                army.setStrenght();
                army.setMaxHealth();
                inventory.useItems(army);
                army.changeLostHealth(lost*10);
                army.controlHealt();
            }else{
                System.out.println("Nepodařilo se ti to a tvá armáda utrpěla velké ztráty. Doporučuji se stáhnout a lépe se připravit.");
                int lost = random.nextInt(3)+4;
                army.changeSize(-1*(army.getSize()/lost));
                army.setStrenght();
                army.setMaxHealth();
                inventory.useItems(army);
                army.changeLostHealth(lost*10);
                army.controlHealt();
            }
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
