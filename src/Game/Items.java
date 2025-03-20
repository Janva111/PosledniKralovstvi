package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Represents an item with a name, price, type of boost, and boost value.
 * Manages a collection of items loaded from a file.
 * Give boosts for players army.
 */

public class Items {
    private String nameOfItem;
    private int price;
    private String typeOfBoost;
    private int boost;
    private HashMap<String, Items> items = new HashMap<String, Items>();
    private ArrayList<Items> itemsList = new ArrayList<Items>();
    ;
    Random rand = new Random();

    public Items(String nameOfItem, int price, String typeOfBoost, int boost) {
        this.nameOfItem = nameOfItem;
        this.price = price;
        this.typeOfBoost = typeOfBoost;
        this.boost = boost;
    }



    /**
     * Constructor that loads items from a file named "items.txt".
     * Reads the file line by line, parsing item attributes and storing them in collections.
     */
    public Items() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("items.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                // creates items
                nameOfItem = split[0];
                price = Integer.parseInt(split[1]);
                typeOfBoost = split[2];
                boost = Integer.parseInt(split[3]);

                Items loadedItem = new Items(nameOfItem, price, typeOfBoost, boost);
                if (loadedItem!= null) {
                    items.put(nameOfItem, loadedItem);
                    itemsList.add(loadedItem);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Searches for an item by its name.
     *
     * @param itemName The name of the item to search for.
     * @return The found item, or null if no match is found.
     */
    public Items findItem(String itemName) {
            for (Items items : itemsList) {
                if (items.getNameOfItem().equalsIgnoreCase(itemName)) {
                    return items;
                }
            }
            return null;
        }


    public String getNameOfItem() {
        return nameOfItem;
    }

    public void setNameOfItem(String nameOfItem) {
        this.nameOfItem = nameOfItem;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfBoost() {
        return typeOfBoost;
    }

    public void setTypeOfBoost(String typeOfBoost) {
        this.typeOfBoost = typeOfBoost;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public HashMap<String, Items> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Items> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "\n"+"Item{" +
                "Název itemu = '" + nameOfItem + '\'' +
                ", Cena = " + price +
                ", Typ boostu = '" + typeOfBoost + '\'' +
                ", Hodnota boostu = " + boost + "%" +
                "}" ;
    }
}