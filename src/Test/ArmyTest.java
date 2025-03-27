package Test;

import Game.Army;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ArmyTest {

    @Test
    void loadArmy() {
        Army army = new Army();
        boolean armyLoaded = army.loadArmy();

        assertNotNull(armyLoaded);
        assertEquals(true, armyLoaded);
    }
}