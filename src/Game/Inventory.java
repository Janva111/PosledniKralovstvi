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
    public void useItems(Army army) {
        double strength = 0;
        double defence = 0;
        double health = 0;
        for (int i = 0; i < itemsOwned.size(); i++) {
            switch (itemsOwned.get(i).getTypeOfBoost()) {
                case "strenght":
                    strength += itemsOwned.get(i).getBoost();
                    strength = (strength + 100) / 100;
                    army.bonusStrenght(strength);
                case "defence":
                    defence += itemsOwned.get(i).getBoost();
                    defence = (defence + 100) / 100;
                    army.bonusDefense(defence);
                case "health":
                    health += itemsOwned.get(i).getBoost();
                    health = (health + 100) / 100;
                    army.bonusMaxHealth(health);
            }
        }


    }

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
