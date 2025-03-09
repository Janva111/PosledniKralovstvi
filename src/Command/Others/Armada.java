package Command.Others;


import Command.Command;
import Game.Army;

public class Armada extends Command{
    Army army;
    public Armada(Army army) {
        this.army = army;
    }
    @Override
    public String execute() {
        System.out.println("Tvoje armada ma tyto staty: " + this.army.toString());
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
