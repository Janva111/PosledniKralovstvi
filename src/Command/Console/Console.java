package Command.Console;

import Command.Command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private boolean exit = false;
    private HashMap<String, Command> mapOfCommands = new HashMap<>();
    public static String commandList = "commandList.txt";
    public void inicializace(){

    }

    private Scanner scanner = new Scanner(System.in);

    private void proved(){
        System.out.print(">>");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommad(command);
        if(mapOfCommands.containsKey(command)){
            System.out.println(">> "+mapOfCommands.get(command).execute());
            exit = mapOfCommands.get(command).exit();
        }else{
            System.out.println(">> Nedefinovany prikaz");
        }
    }

    public void start(){
        inicializace();
        try{
            do{
                proved();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void saveCommad(String prikaz){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(commandList,true))){
            bw.write(prikaz);
            bw.newLine();
        }catch(Exception e){

        }
    }
}
