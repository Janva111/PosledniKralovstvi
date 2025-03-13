package Command.Trader;

import Command.Command;
import Game.Inventory;
import Game.Items;
import Game.Trader;

import java.util.Scanner;

public class KoupitPredmet extends Command {
    private static Trader trader;
    private static Inventory inventory;

    public KoupitPredmet(Trader trader, Inventory inventory) {
        this.trader = trader;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        if (trader.isTalking() == true){
            System.out.println("Zadej jméno itemu, který chceš koupit:" );
            Scanner scan  = new Scanner(System.in);
            String input = scan.nextLine().trim().toLowerCase();

            Items changingItem = trader.findItem(input);
            if (changingItem != null) {
                trader.getItems().remove(changingItem);
                inventory.getItemsOwned().add(changingItem);
            }else {
                System.out.println("Tento item neexistuje");
            }

            System.out.println("Koupil jsi: "+ changingItem);
            System.out.println(trader.toString());
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
