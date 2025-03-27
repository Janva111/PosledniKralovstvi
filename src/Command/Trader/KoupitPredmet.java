package Command.Trader;

import Command.Command;
import Game.Inventory;
import Game.Items;
import Game.Trader;

import java.util.Scanner;

/**
 * Command to purchase an item from the trader.
 * This command allows the player to buy an item from the trader's inventory,
 * if the player is currently talking to the trader.
 */
public class KoupitPredmet extends Command {
    private Trader trader;
    private Inventory inventory;

    public KoupitPredmet(Trader trader, Inventory inventory) {
        this.trader = trader;
        this.inventory = inventory;
    }

    /**
     * Executes the command to purchase an item from the trader.
     * The player enters the name of the item they want to buy,
     * and the item is removed from the trader's inventory and added to the player's inventory.
     *
     * If the player is not talking to the trader, the action cannot be performed.
     *
     * @return A message indicating the completion of the action.
     */
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
                inventory.addBalance(-1 * changingItem.getPrice());
            }else {
                System.out.println("Tento item neexistuje" + "\n"
                        + "--------------------------------------------------------");
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
