package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;
import Game.Map.LoadMap;
import Game.Inventory;
import java.util.Random;

/**
 * Command to engage in battle to conquer the current city.
 * This command is only executed if the current city is not already controlled by the player.
 * The success of the battle depends on the strength of the player's army compared to the city's army strength.
 * If the player wins, the city is conquered, and the player's army size and health are updated accordingly.
 * If the player loses, the army suffers losses.
 */
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

    /**
     * Executes the battle command. If the current city is not taken, the player's army engages in battle with
     * the city's army. If the player's army is stronger, the city is conquered, and the player's army suffers
     * some losses based on a random factor. If the battle is lost, the player's army suffers significant losses
     * and is advised to retreat and prepare better for future battles.
     *
     * If the city is already controlled by the player, a message is displayed indicating that no battle is needed.
     *
     * @return A string indicating the outcome of the battle.
     */
    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken()==false){
            if(army.getStrenght() > game.getCurrentCity().getStrenght()){
                // Success: the city is conquered
                game.getCurrentCity().setTaken(true);
                game.getCurrentCity().setStrenght(0);
                loadMap.controlWin();
                System.out.println("Podařilo se ti úspěšně dobýt město " + game.getCurrentCity().getName()+ ".\n" +
                        "Dobrá práce, jen tak dál, už jsi o krok blíže k svému úspěchu.");
                int lost = random.nextInt(4)+11;
                army.changeSize(-1*(army.getSize()/lost));
                army.setStrenght();
                army.setMaxHealth();
                inventory.useItems(army);// Apply inventory items to the army
                army.changeLostHealth(lost*10);
                army.controlHealtEnding();// Check army health\
            }else{
                // Failure: the army is not strong enough
                System.out.println("Nepodařilo se ti to a tvá armáda utrpěla velké ztráty. Doporučuji se stáhnout a lépe se připravit.");
                int lost = random.nextInt(3)+4;
                army.changeSize(-1*(army.getSize()/lost));
                army.setStrenght();
                army.setMaxHealth();
                inventory.useItems(army);// Apply inventory items to the army
                army.changeLostHealth(lost*10);
                army.controlHealtEnding();// Check army health
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
