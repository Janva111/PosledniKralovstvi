package Test;

import Game.Army;
import Game.Inventory;
import Game.Items;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    /*
        assertNotEquals() - Zkontroluje, zda 2 hodnoty nejsou stejné.
        assertNotNull() - Zkontroluje, zda hodnota není null.
        assertNotSame() - Zkontroluje, zda 2 reference neukazují na stejný objekt.
        assertFalse() - Zkontroluje, zda je hodnota false.
    */

    private Inventory inventory;
    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        Items item1 = new Items();
        item1 = item1.findItem("kopi");
        Items item2 = new Items();
        item2 = item2.findItem("mec");
        inventory.getItemsOwned().add(item1);
        inventory.getItemsOwned().add(item2);
    }

    @Test
    void loadBalance(){
        boolean result = inventory.loadBalance();

        assertNotNull(result);
        assertEquals(true, result);
    }

    @Test
    void useItems() {
        assertTrue(inventory.useItems(new Army()));
        assertNotNull(inventory.useItems(new Army()));
    }

    @Test
    void testFindItems_Success() {
        Items foundItem = inventory.findItem("mec");
        assertNotNull(foundItem);
        assertEquals("mec", foundItem.getNameOfItem());
    }

    @Test
    void testFindItems_Failure() {
        Items foundItem = inventory.findItem("NonExistentItem");
        assertNull(foundItem); // Item should not be found
    }

}