package Command.Others;


import Command.Command;
import Game.Army;

public class Armada extends Command {
    @Override
    public String execute() {
        Army army = new Army();
        return "Tvoje armada ma tyto staty: " + army.toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
