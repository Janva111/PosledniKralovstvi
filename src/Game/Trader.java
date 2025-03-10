package Game;

import java.util.ArrayList;

public class Trader {
    private ArrayList<Items> items = new ArrayList<>();
    private static Items item;
    private boolean talking = false;

    public Trader(Items item) {
        this.item = item;
    }

    private void GenerateItems() {

    }

    public void buy() {

    }

    public void sell() {

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
        return "Nabidka = {" +
                "Item = " + items +
                '}';
    }
}
