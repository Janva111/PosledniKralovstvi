package Command.Others;

import Command.Command;
import Game.Game;
import Game.Map.City;
import Game.Map.LoadMap;

import java.util.Scanner;

/**
 * Command to handle player movement between cities on the map.
 * This command allows the player to move to another city if it is accessible.
 * It checks if the game is properly initialized, displays the current city's information,
 * shows available movement options, and lets the player choose the next destination.
 */
public class Pohyb extends Command {

    private static Game game;
    private static LoadMap loadMap;
    private boolean firstMove = true;

    public Pohyb(Game game, LoadMap loadMap) {
        this.game = game;
        this.loadMap = loadMap;
    }

    /**
     * Executes the move command, allowing the player to select a destination city.
     * It checks whether the game and map are initialized properly, displays the current city
     * and enemy army strength, lists available movements, and processes the player's choice.
     * If the player moves to a valid city, the movement is executed. If the city is not accessible,
     * the player is informed that no path exists.
     *
     * @return A string indicating the end of the movement operation and the result.
     */
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
