package Command.Others;

import Command.Command;

/**
 * Command to exit the game.
 * This command terminates the game when executed.
 */
public class Ukoncit extends Command {
    /**
     * Executes the command to terminate the game.
     * This method prints a message indicating the game is ending and returns a message confirming that.
     *
     * @return A message indicating that the game has ended.
     */
    @Override
    public String execute() {
        System.out.println("Hra se ukoncuje");
        return "Hra se ukoncila";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
