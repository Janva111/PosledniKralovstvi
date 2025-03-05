package Game;

import java.util.Random;

public class Items {
    private String nameOfItem;
    private int price;
    private String quantity;
    Random rand = new Random();


    public Items(String nameOfItem) {
        this.nameOfItem = nameOfItem;
        setPrice();
        setQuantity();
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

    public void setPrice() {
        this.price = 0;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity() {
        this.quantity = "";
    }
}
