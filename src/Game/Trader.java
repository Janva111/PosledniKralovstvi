package Game;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a trader who possesses and sells various items.
 */

public class Trader {
    private ArrayList<Items> items = new ArrayList<>(4);
    private static Items item;
    private boolean talking = false;
    private Random rand = new Random();
    public Trader(Items item) {
        this.item = item;
    }

    /**
     * Generates a random set of 4 items for the trader shop.
     */

    public void generateItems() {
        for (int i = 0; i < 4; i++) {
            int generate = rand.nextInt(8) + 1;
            switch (generate) {
                case 1:
                    items.add(item.getItems().get("mec"));
                    break;
                case 2:
                    items.add(item.getItems().get("kopi"));
                    break;
                case 3:
                    items.add(item.getItems().get("stit"));
                    break;
                case 4:
                    items.add(item.getItems().get("brneni"));
                    break;
                case 5:
                    items.add(item.getItems().get("katapult"));
                    break;
                case 6:
                    items.add(item.getItems().get("ozivovacitotem"));
                    break;
                case 7:
                    items.add(item.getItems().get("lektvarrozzureni"));
                    break;
                case 8:
                    items.add(item.getItems().get("elixirodolnosti"));
                    break;
                default:
                    break;
            }
        }
    }


    /**
     * Searches for an item by its name.
     *
     * @param itemName The name of the item to search for.
     * @return The found item, or null if the item is not found.
     */
    public Items findItem(String itemName) {
        for (Items items : items) {
            if (items.getNameOfItem().equalsIgnoreCase(itemName)) {
                return items;
            }
        }
        return null;
    }


    public void setItems(ArrayList<Items> items) {
        this.items = items;
    }


    public ArrayList<Items> getItems() {
        return items;
    }


    public boolean isTalking() {
        return talking;
    }


    public void setTalking(boolean talking) {
        this.talking = talking;
    }

    @Override
    public String toString() {
        return "Nabidka:" +
                items;
    }
}
