package Command.Trader;

import Command.Command;
import Game.Inventory;
import Game.Items;
import Game.Trader;

import java.util.Scanner;

/**
 * Command for selling an item to the trader.
 * This command allows the player to sell an item from their inventory if they are currently interacting with a trader.
 * The player will receive half of the item's price upon successful sale.
 */

public class ProdatPredmet extends Command {
    private Trader trader;
    private Inventory inventory;

    public ProdatPredmet(Trader trader, Inventory inventory) {
        this.trader = trader;
        this.inventory = inventory;
    }

    /**
     * Executes the command to sell an item from the player's inventory.
     * If the player is talking to the trader, they can choose an item to sell.
     * The item is removed from the inventory, and the player receives half of the item's price as balance.
     *
     * @return A message indicating the completion of the action.
     */
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