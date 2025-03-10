package Command.Others;

import Command.Command;
import Game.Game;

public class Pomoc extends Command {
    private static Game game;

    public Pomoc(Game game) {
        this.game = game;
    }

    @Override
    public String execute() {
        System.out.println("Zdá se že si nevíš rady co bys mohl dělat. Zde jsou tvé nápovědy: ");
        if (game.getCurrentCity().isTaken() == true) {
            System.out.println("Jelikož toto město už kontroluješ můžeš dělat následovné věci: ");
            game.showAvailableMovements();
            System.out.println("Zajít k obchodníkovy a koupit nejaké nové vybavení, či prodat to staré." + "\n" + "Osvobodit zajatce a narukovat je do své armády." + "\n" + "ukPoužít itemy, aby tvá armáda byla vyzbrojena.");
        } else if (game.getCurrentCity().isTaken() == false) {
            System.out.println("Jak tak vidím ještě si neopsadil toto město, tudíž pokud si připraven, ukaž co je v tobě a bojuj.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
