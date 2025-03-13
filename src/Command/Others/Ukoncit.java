package Command.Others;

import Command.Command;

public class Ukoncit extends Command {
    @Override
    public String execute() {
        System.out.println("Hra se ukoncuje");
        System.exit(0);
        return "Hra se ukoncila";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
