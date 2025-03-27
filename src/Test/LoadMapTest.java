package Test;

import Game.Map.LoadMap;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LoadMapTest {
    private LoadMap loadMap;

    /**
     * Control of loading map
     */
        @Test
        void testLoadMap() {
            LoadMap loadMap = new LoadMap();
            boolean map = loadMap.loadMap();

            assertNotNull(map);
            assertEquals(true, map);
        }
    }