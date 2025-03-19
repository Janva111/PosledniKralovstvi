package Command.Others;

import Command.Command;
import Game.Game;
import Game.Map.City;
import Game.Map.LoadMap;

import java.util.Scanner;

public class Pohyb extends Command {

    private static Game game;
    private static LoadMap loadMap;
    private boolean firstMove = true;

    public Pohyb(Game game, LoadMap loadMap) {
        this.game = game;
        this.loadMap = loadMap;
    }

    @Override
    public String execute() {
                if (game == null || loadMap == null) {
                    return "Hra nebyla správně inicializována!";
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Právě si ve městě: " + game.getCurrentCity().getName());
                if (game.getCurrentCity().getStrenght() != 0) {
                    System.out.println("Síla nepřátelské armády: " + game.getCurrentCity().getStrenght());
                }
                game.showAvailableMovements();

                System.out.print("Kam si přeješ dále pokračovat? (napiš název lokace): ");
                String input = scanner.nextLine().trim().toLowerCase();

                City toGo = new City();
                if (loadMap.findCity(input) != null) {
                    toGo = loadMap.findCity(input);
                }

                if (game.move(toGo) == true) {
                    firstMove = false;
                    System.out.println("Právě ses vypravil do města " + toGo.getName());
                    System.out.println("Uspěšně si dorazil do města " + toGo.getName());
                } else {
                    System.out.println("K tomuto místu žádná cesta nevede");
                }

        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
