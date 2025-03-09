package Command.Others;

import Command.Command;
import Game.Army;
import Game.Fight;

import java.util.Random;

public class Osvobodit extends Command {

    Fight fight;
    Army army;
    public Osvobodit(Fight fight, Army army) {
        this.fight = fight;
        this.army = army;
    }

    @Override
    public String execute() {
        if (fight.fight()){
            Random rand = new Random();
            int size = rand.nextInt(100) + 100;
            army.biggerSize(size);
            army.setDefense();
            army.setHealth();
            army.setStrenght();
            System.out.println("Osvobodil si " + size + " zajatých občanů země Valtheris.");
        }else {
            System.out.println("Tuto možnost nelze provést.");
        }
        //
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
