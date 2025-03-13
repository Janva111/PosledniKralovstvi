package Command.Trader;

import Command.Command;
import Game.Inventory;
import Game.Items;
import Game.Trader;

import java.util.Scanner;

public class ProdatPredmet extends Command {
    private static Trader trader;
    private static Inventory inventory;

    public ProdatPredmet(Trader trader, Inventory inventory) {
        this.trader = trader;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        if (trader.isTalking() == true){
            if (inventory.getItemsOwned()!=null) {
                System.out.println(inventory.getItemsOwned());
                System.out.println("Napis jméno itemu, který chceš prodat:");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine().trim().toLowerCase();

                Items changingItem = inventory.findItem(input);
                if (changingItem != null) {
                    inventory.getItemsOwned().remove(changingItem);
                    inventory.addBalance(changingItem.getPrice()/2);
                }

            }else {
                System.out.println("Nemáš žádné itemy.");
            }
        }else {
            System.out.println("Tuto možnost nelze provést. Nejsi u obchodníka.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}