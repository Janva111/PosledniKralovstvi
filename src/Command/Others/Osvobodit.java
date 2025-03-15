package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;
import Game.Inventory;

import java.util.Random;

public class Osvobodit extends Command {

    private static Game game;
    private static Army army;
    private static Inventory inventory;

    public Osvobodit(Game game, Army army, Inventory inventory) {
        this.game = game;
        this.army = army;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            Random rand = new Random();
            int size = rand.nextInt(100) + 100;
            army.changeSize(size);
            army.setDefense();
            army.setMaxHealthHealth();
            army.setStrenght();
            inventory.useItems(army);
            System.out.println("Osvobodil si " + size + " zajatých občanů země Valtheris.");
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
