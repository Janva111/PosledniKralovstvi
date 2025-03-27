package Test;

import Game.Items;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemsTest {


    private Items items;

    @Test
    void loadItems() {
        Items items = new Items();
        boolean item = items.loadItems();

        assertNotNull(item);
        assertEquals(true, item);
    }

    @Test
    void testFindItems_Success() {
        items = new Items();
        items.loadItems();
        Items foundItem = items.findItem("mec");
        assertNotNull(foundItem);
        assertEquals("mec", foundItem.getNameOfItem());
    }

    @Test
    void testFindItems_Failure() {
        items = new Items();
        items.loadItems();
        Items foundItem = items.findItem("NonExistentItem");
        assertNull(foundItem);
    }
}