package Command.Others;

import Command.Command;
import Game.Army;
import Game.Game;

import java.util.Random;

public class Osvobodit extends Command {

    private static Game game;
    private static Army army;

    public Osvobodit(Game game, Army army) {
        this.game = game;
        this.army = army;
    }

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            Random rand = new Random();
            int size = rand.nextInt(100) + 100;
            army.biggerSize(size);
            army.setDefense();
            army.setHealth();
            army.setStrenght();
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
