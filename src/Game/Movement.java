package Game;

import Game.Map.City;
import Game.Map.LoadMap;

import java.util.Scanner;

public class Movement {
    private Game game;
    private LoadMap loadMap;

    public Movement(Game game, LoadMap loadMap) {
        this.game = game;
        this.loadMap = loadMap;
    }

    public void startMovement() {
        Scanner scan = new Scanner(System.in);
        boolean flag = true;

        do {
            System.out.println("Jsi v meste: " + game.getCurrentCity().getName());
            System.out.println(game.getCurrentCity().getStrenght());
            System.out.println(game.getCurrentCity().getHealth());
            showAvailableMovements();

            // legal movement
            System.out.println("Kam máš namířeno? (Napiš pouze jmeno města)");
            String input = scan.nextLine().toLowerCase().trim();

            City toGo = loadMap.findCity(input);
            if (toGo == null) {
                System.out.println("Jdes nekam co neexistuje :(");
            }else {
                move(toGo);
            }
        }while (flag);

    }

    public boolean move(City toGo) {
        if (game.getCurrentCity().getLegalCities().contains(toGo)) {
            game.setCurrentCity(toGo);
            return true;
        }else {
            System.out.println("Jdes nekam co neexistuje :(");
            return false;
        }
    }

    public void showAvailableMovements() {
        System.out.println("Muzes jit:");
        for (String legalCities : game.getCurrentCity().getLegalCities()){
            System.out.println("- "+ legalCities);
        }
    }
}
