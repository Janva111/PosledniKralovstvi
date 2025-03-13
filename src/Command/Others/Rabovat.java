package Command.Others;

import Command.Command;
import Game.Game;
import Game.Inventory;
import Game.Items;

import java.util.Random;

public class Rabovat extends Command {
    private static Game game;
    private static Inventory inventory;
    private static Items item;

    public Rabovat(Game game, Inventory inventory) {
        this.game = game;
        this.inventory = inventory;
    }

    @Override
    public String execute() {
        if (game.getCurrentCity().isTaken() == true) {
            Random rand = new Random();
            int generate = rand.nextInt(8) + 1;
            switch (generate) {
                case 1:
                    inventory.getItemsOwned().add(item.getItems().get("mec"));
                    break;
                case 2:
                    inventory.getItemsOwned().add(item.getItems().get("kopi"));
                    break;
                case 3:
                    inventory.getItemsOwned().add(item.getItems().get("stit"));
                    break;
                case 4:
                    inventory.getItemsOwned().add(item.getItems().get("brneni"));
                    break;
                case 5:
                    inventory.getItemsOwned().add(item.getItems().get("katapult"));
                    break;
                case 6:
                    inventory.getItemsOwned().add(item.getItems().get("ozivovacitotem"));
                    break;
                case 7:
                    inventory.getItemsOwned().add(item.getItems().get("lektvarrozzureni"));
                    break;
                case 8:
                    inventory.getItemsOwned().add(item.getItems().get("elixirodolnosti"));
                    break;
                default:
                    break;
            }
        }else {
            System.out.println("Nelze rabovat v neobsayeném městě.");
        }
        return "--------------------------------------------------------";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
