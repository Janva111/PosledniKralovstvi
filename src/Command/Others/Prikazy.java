package Command.Others;

import Command.Command;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

/**
 * Command to shows all available commands in the game.
 * This command reads from a file and displays each command listed in the file to the player.
 * The commands are shown one by one from the file "allCommands.txt".
 */
public class Prikazy extends Command {
    /**
     * Executes the command to show all available commands.
     * It reads each line from the "allCommands.txt" file and displays it in the console.
     * If there's an issue with reading the file, an error message is shown.
     *
     * @return A string indicating the end of the command output.
     */
    @Override
    public String execute() {
        try (BufferedReader br = new BufferedReader(new FileReader("allCommands.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // Čte řádek po řádku
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Chyba při čtení souboru: " + e.getMessage());
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
