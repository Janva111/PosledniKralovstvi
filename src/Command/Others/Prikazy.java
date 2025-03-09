package Command.Others;

import Command.Command;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Prikazy extends Command {
    @Override
    public String execute() {
        System.out.println("Prikazy a vysvetlivky: ");
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
