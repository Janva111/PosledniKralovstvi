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
        if (game.getCurrentCity().isTaken() == true) {
            do {
                if (game == null || loadMap == null) {
                    return "Hra nebyla správně inicializována!";
                }

                Scanner scanner = new Scanner(System.in);
                System.out.println("Právě si ve městě: " + game.getCurrentCity().getName());
                System.out.println("Počet životů nepřátelské armády: " + game.getCurrentCity().getHealth());
                System.out.println("Síla nepřátelské armády" + game.getCurrentCity().getStrenght());
                game.showAvailableMovements();

                System.out.print("Kam si přeješ dále pokračovat? (napiš název lokace): ");
                String input = scanner.nextLine().trim().toLowerCase();

                City toGo = loadMap.findCity(input);
                if (toGo == null) {
                    return "Tato lokace neexistuje!";
                }

                if (game.move(toGo) == true) {
                    firstMove = false;
                    System.out.println("Právě ses vypravil do města " + toGo.getName());
                    System.out.println("Uspěšně si dorazil do města " + toGo.getName());
                } else {
                    return "Touto cestou nelze jít";
                }

            } while (firstMove);
        }else {
            System.out.println("Tuto možnost nelze provést. Město není obsazeno.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
