package Game;

import java.util.ArrayList;

public class Inventory {
    private int balance = 0;
    private ArrayList<Items> itemsOwned = new ArrayList<>();

    public Inventory(ArrayList<Items> itemsOwned, int balance) {
        this.itemsOwned = itemsOwned;
        this.balance = balance;
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
}
