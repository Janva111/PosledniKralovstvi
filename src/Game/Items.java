package Game;

import Game.Map.City;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Items {
    private String nameOfItem;
    private int price;
    private String boost;
    private HashMap<String, Items> items = new HashMap<String, Items>();;
    Random rand = new Random();

    public Items(String nameOfItem, int price) {
        this.nameOfItem = nameOfItem;
        this.price = price;
        this.boost = boost;
    }

    public Items() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("cities.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");

                // creates items
                nameOfItem = split[0];
                price = Integer.parseInt(split[1]);
                items.put(nameOfItem, new Items(nameOfItem, price));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}