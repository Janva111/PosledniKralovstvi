package Test;

import Game.Game;
import Game.Items;
import Game.Trader;
import Game.Inventory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TraderTest {

    private Trader trader;
    private Game game;
    private Items items;
    private Inventory inventory;
    private Random rd;

    @BeforeEach
    void setUp() {
        game = new Game();
        items = new Items();
        items.loadItems();
        inventory = new Inventory();
        trader = new Trader(items);
        rd = new Random();
    }

    @Test
    void generateItems() {
        boolean items = trader.generateItems();

        assertNotNull(items);
        assertEquals(true, items);
    }

    @Test
    void testFindItems_Success() {
        for (int i = 0; i< items.getItemsList().size(); i++) {
            inventory.getItemsOwned().add(items.getItemsList().get(i));
        }

        Items foundItem = inventory.findItem("mec");

        assertNotNull(foundItem);
        assertEquals("mec", foundItem.getNameOfItem());
    }

    @Test
    void testFindItems_Failure() {
        Items foundItem = inventory.findItem("nonexistent");

        assertNull(foundItem);
    }
}