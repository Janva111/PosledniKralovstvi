package Command.Console;

import Command.Command;
import Command.Inventory.Inventar;
import Command.Inventory.PouzitElixirOdolnosti;
import Command.Inventory.PouzitLektvarRozzureni;
import Command.Inventory.PouzitOzdravovaciTotem;
import Command.Movement.*;
import Command.Others.Armada;
import Command.Others.Prikazy;
import Command.Others.Ukoncit;
import Command.Trader.Obchodnik;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private boolean exit = false;
    private HashMap<String, Command> mapOfCommands = new HashMap<>();
    public static String commandList = "commandHistori.txt";
    public void inicialization(){
        mapOfCommands.put("jdi argolis", new jdiArgolis());
        mapOfCommands.put("jdi delos", new jdiDelos());
        mapOfCommands.put("jdi lakedaimon", new jdiLakedaimon());
        mapOfCommands.put("jdi miradell", new jdiMiradell());
        mapOfCommands.put("jdi nythrador", new jdiNythrador());
        mapOfCommands.put("jdi solmora", new jdiSolmora());
        mapOfCommands.put("jdi sylvaria", new jdiSylvaria());
        mapOfCommands.put("armada", new Armada());
        mapOfCommands.put("ukoncit", new Ukoncit());
        mapOfCommands.put("prikazy", new Prikazy());
        mapOfCommands.put("inventar", new Inventar());
        mapOfCommands.put("pouzit elixir odolnosti", new PouzitElixirOdolnosti());
        mapOfCommands.put("pouzit lektvar rozzureni", new PouzitLektvarRozzureni());
        mapOfCommands.put("pouzit ozdravovaci totem", new PouzitOzdravovaciTotem());
        mapOfCommands.put("obchodnik", new Obchodnik());
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

    public void start(){
        inicialization();
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
