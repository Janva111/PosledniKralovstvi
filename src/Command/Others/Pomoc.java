package Command.Others;

import Command.Command;
import Game.Game;

/**
 * Command to provide help or guidance to the player during the game.
 * This command offers information on available actions and tips depending on the current state of the game,
 * such as whether the player controls the current city.
 */
public class Pomoc extends Command {
    private Game game;

    public Pomoc(Game game) {
        this.game = game;
    }

    /**
     * Executes the help command, providing guidance to the player.
     * It offers different hints depending on whether the player controls the current city.
     * If the player controls the city, available movements and actions are displayed.
     * If the player does not control the city, suggestions for battles and army upgrades are provided.
     *
     * @return A string indicating the end of the help output.
     */
    @Override
    public String execute() {
        System.out.println("Zdá se že si nevíš rady co bys mohl dělat. Zde jsou tvé nápovědy: ");
        if (game.getCurrentCity().isTaken() == true) {
            System.out.println("Jelikož toto město už kontroluješ můžeš dělat následovné věci: ");
            game.showAvailableMovements();
            System.out.println("Zajít k obchodníkovy a koupit nejaké nové vybavení, či prodat to staré." + "\n"
                    + "Osvobodit zajatce a narukovat je do své armády." + "\n"
                    + "ukPoužít itemy, aby tvá armáda byla vyzbrojena.");
        } else if (game.getCurrentCity().isTaken() == false) {
            System.out.println("Jak tak vidím ještě si neopsadil toto město, tudíž pokud si připraven, ukaž co je v tobě a bojuj." + "\n"
                    + "Také se můžeš vrátit do předešlích měst a vylepšit svou armádu.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
