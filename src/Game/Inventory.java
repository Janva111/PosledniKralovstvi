package Game;

import java.util.ArrayList;

public class Inventory {
    private int balance;
    private ArrayList<Items> itemsOwned;

    public Inventory() {
        this.balance = 0;
        itemsOwned = new ArrayList<>();
    }

    public void addItem(Items item) {
        itemsOwned.add(item);
    }

    public void removeItem(String item) {
        itemsOwned.remove(item);
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
