package Game;

import Game.Map.City;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class Items {
    private String nameOfItem;
    private int price;
    private String typeOfBoost;
    private int boost;
    private HashMap<String, Items> items = new HashMap<String, Items>();
    ;
    Random rand = new Random();

    public Items(String nameOfItem, int price, String typeOfBoost, int boost) {
        this.nameOfItem = nameOfItem;
        this.price = price;
        this.typeOfBoost = typeOfBoost;
        this.boost = boost;
    }

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
                items.put(nameOfItem, new Items(nameOfItem, price, typeOfBoost, boost));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
}