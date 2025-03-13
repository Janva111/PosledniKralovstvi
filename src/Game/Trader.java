package Game;

import java.util.ArrayList;
import java.util.Random;

public class Trader {
    private ArrayList<Items> items = new ArrayList<>(4);
    private static Items item;
    private boolean talking = false;
    private Random rand = new Random();
    public Trader(Items item) {
        this.item = item;
    }

    public void generateItems() {
        for (int i = 0; i < 4; i++) {
            int generate = rand.nextInt(8) + 1;
            switch (generate) {
                case 1:
                    items.add(item.findItem("mec"));
                    break;
                case 2:
                    items.add(item.findItem("kopi"));
                    break;
                case 3:
                    items.add(item.findItem("stit"));
                    break;
                case 4:
                    items.add(item.findItem("brneni"));
                    break;
                case 5:
                    items.add(item.findItem("katapult"));
                    break;
                case 6:
                    items.add(item.findItem("ozivovaciTotem"));
                    break;
                case 7:
                    items.add(item.findItem("lektvarRozzureni"));
                    break;
                case 8:
                    items.add(item.findItem("elixirOdolnosti"));
                    break;
                default:
                    break;
            }
        }
    }

    public void removeItems(){
        for (int i = 0; i < items.size(); i++) {
            items.remove(i);
        }
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
