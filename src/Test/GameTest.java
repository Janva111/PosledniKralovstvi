package Test;

import Game.Game;
import Game.Map.City;
import Game.Map.LoadMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    private Game game;
    private LoadMap loadMap;

    @BeforeEach
    void setUp() {
        loadMap = new LoadMap();
        loadMap.loadMap();
        City city = loadMap.findCity("Hellas");
        game = new Game(city);
    }

    /**
     *Controls correct startGame
     *Comment line 74 in class Game (console.start(army, inventory, trader, items, game, loadMap);)
     */

    @Test
    void startGame() {
        game.startGame();
        assertTrue(game.startGame());
    }

    @Test
    void move() {
        game.setCurrentCity(loadMap.findCity("Hellas"));
        City cityToGo = loadMap.findCity("Argolis");
        boolean test = game.move(cityToGo);
        assertEquals(test, true);
    }
}