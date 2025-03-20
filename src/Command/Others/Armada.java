package Command.Others;


import Command.Command;
import Game.Army;

/**
 * Command to display the current stats of the player's army.
 * This command allows the player to view the details of their army, including its size, strength, and other attributes.
 */
public class Armada extends Command {
    private static Army army;

    public Armada(Army army) {
        this.army = army;
    }

    /**
     * Executes the command to display the current stats of the player's army.
     * It prints out the army's attributes such as size, strength, and any other relevant information.
     *
     * @return A string indicating the completion of the action.
     */
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
