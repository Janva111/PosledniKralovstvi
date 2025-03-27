package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents an inventory that holds items and manages a player's balance.
 */

public class Inventory {
    private int balance;
    private ArrayList<Items> itemsOwned;



    public Inventory() {
        itemsOwned = new ArrayList<>();
    }

    /**
     * Loads the starting balance from the "balance.txt" file and initializes the map.
     *
     * @return true if the map was loaded successfully, false otherwise.
     */
    public boolean loadBalance(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("balance.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                balance = Integer.parseInt(line);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    /**
     * Go throw inventory and sort boosts of items.
     * Count boosts of items.
     * Add boosts to army.
     *
     * @param army The army to enhance using item boosts.
     */

    public boolean useItems(Army army) {
        double strength = 0;
        double defence = 0;
        double health = 0;
        for (int i = 0; i < itemsOwned.size(); i++) {
            switch (itemsOwned.get(i).getTypeOfBoost()) {
                case "strenght":
                    strength += itemsOwned.get(i).getBoost();
                case "defence":
                    defence += itemsOwned.get(i).getBoost();

                case "health":
                    health += itemsOwned.get(i).getBoost();

            }
        }
        if (strength!=0 && defence!=0 && health!=0) {
            strength = (strength + 100) / 100;
            defence = (defence + 100) / 100;
            health = (health + 100) / 100;
            army.bonusStrenght(strength);
            army.bonusDefense(defence);
            army.bonusMaxHealth(health);
        }
            return true;
    }

    /**
     * Searches for an item by its name in the inventory.
     *
     * @param itemName The name of the item to search for.
     * @return The found item, or null if not found.
     */

    public Items findItem(String itemName) {
        for (Items items : itemsOwned) {
            if (items.getNameOfItem().equalsIgnoreCase(itemName)) {
                return items;
            }
        }
        System.out.println("Tento item nemáš v inventáři.");
        return null;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public ArrayList<Items> getItemsOwned() {
        return itemsOwned;
    }

    public void setItemsOwned(ArrayList<Items> itemsOwned) {
        this.itemsOwned = itemsOwned;
    }

    @Override
    public String toString() {
        return "{" +
                "penize = " + balance +
                ", itemy = " + itemsOwned +
                '}';
    }
}
