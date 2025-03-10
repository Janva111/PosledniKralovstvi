package Command.Console;

import Command.Command;
import Command.Inventory.*;
import Command.Others.Armada;
import Command.Others.Pohyb;
import Command.Others.Osvobodit;
import Command.Others.Prikazy;
import Command.Others.Ukoncit;
import Command.Trader.KoupitPredmet;
import Command.Trader.Obchodnik;
import Command.Trader.ProdatPredmet;
import Game.*;
import Game.Map.LoadMap;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private Army army;
    private Inventory inventory;
    private Trader trader;
    private Items items;
    private Game game;
    private LoadMap loadMap;

    private boolean exit = false;
    private HashMap<String, Command> mapOfCommands = new HashMap<>();
    public static String commandList = "commandHistori.txt";
    public void inicialization(Army army, Inventory inventory, Trader trader, Items items, Fight fight, Game game, LoadMap loadMap) {
        mapOfCommands.put("pohyb",new Pohyb(game, loadMap));
        mapOfCommands.put("armada", new Armada(army));
        mapOfCommands.put("ukoncit", new Ukoncit());
        mapOfCommands.put("prikazy", new Prikazy());
        mapOfCommands.put("inventar", new Inventar(inventory));
        mapOfCommands.put("pouzit elixir odolnosti", new PouzitElixirOdolnosti(army, inventory));
        mapOfCommands.put("pouzit lektvar rozzureni", new PouzitLektvarRozzureni(army, inventory));
        mapOfCommands.put("pouzit ozdravovaci totem", new PouzitOzdravovaciTotem(army, inventory));
        mapOfCommands.put("obchodnik", new Obchodnik(trader));
        mapOfCommands.put("osvobodit", new Osvobodit(fight,army));
        mapOfCommands.put("koupit predmet", new KoupitPredmet(trader, inventory));
        mapOfCommands.put("prodat predmet", new ProdatPredmet(trader, inventory));
        mapOfCommands.put("pouzit itemy", new PouzitItemy(inventory));

        // add commands
    }

    private Scanner scanner = new Scanner(System.in);

    private void make(){
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommad(command);
        if(mapOfCommands.containsKey(command)){
            System.out.println(">> "+mapOfCommands.get(command).execute());
            exit = mapOfCommands.get(command).exit();
        }else{
            System.out.println(">> Not define command");
        }
    }

    public void start(Army army, Inventory inventory, Trader trader, Items items,Fight fight, Game game, LoadMap loadMap) {
        inicialization(army,inventory,trader,items,fight, game, loadMap);
        try{
            do{
                make();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void saveCommad(String command){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandList,true))){
            bw.write(command);
            bw.newLine();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
