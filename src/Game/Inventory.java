package Game;

import java.util.ArrayList;

public class Inventory {
    private int balance;
    private ArrayList<Items> itemsOwned;

    public Inventory() {
        this.balance = 0;
        itemsOwned = new ArrayList<>();
    }

    // shromazdi vsechny boosty z itemu a vylepsi tim armadu
    public void useItems() {
        double strength = 0;
        double defence = 0;
        double health = 0;
        for (int i = 0; i < itemsOwned.size(); i++) {
            switch (itemsOwned.get(i).getTypeOfBoost()) {
                case "strenght":
                    strength += itemsOwned.get(i).getBoost();
                    strength = (strength + 100) / 100;
                case "defence":
                    defence += itemsOwned.get(i).getBoost();
                    defence = (defence + 100) / 100;
                case "health":
                    health += itemsOwned.get(i).getBoost();
                    health = (health + 100) / 100;
            }
        }


    }

    public void addItem(Items item) {
        itemsOwned.add(item);
    }

    // dopsat removeItem a add item
    public void removeItem(String item) {
        if (itemsOwned.contains(item)) {
            itemsOwned.remove(item);
        }
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
