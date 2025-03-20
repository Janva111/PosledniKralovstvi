package Command;

/**
 * An abstract class that represents a command in the game.
 * Each command has a specific action that is executed when the command is invoked.
 * Subclasses of this class should implement specific commands by defining the behavior of execute() and exit() methods.
 */

public abstract class Command {


    protected String prikaz;

    public void setPrikaz(String prikaz) {
        this.prikaz = prikaz;
    }

    /**
     * Executes the action associated with this command.
     * This method should be implemented by subclasses to define the specific behavior of the command.
     *
     * @return The result or message of the command execution.
     */
    public abstract String execute();

    /**
     * Determines whether the command should cause the game to exit or not.
     * Subclasses should implement the specific condition for when the command should terminate the game.
     *
     * @return true if the game should exit, false otherwise.
     */
    public abstract boolean exit();

}
