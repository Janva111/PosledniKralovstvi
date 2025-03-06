package Game;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jsi v meste: " + game.getCurrentCity().getName());
        System.out.println(game.getCurrentCity().getStrenght());
        System.out.println(game.getCurrentCity().getHealth());
        // legal movement



    }

}
