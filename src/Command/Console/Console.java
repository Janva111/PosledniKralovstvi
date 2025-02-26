package Command.Console;

import Command.Command;
import Command.Movement.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Console {

    private boolean exit = false;
    private HashMap<String, Command> mapOfCommands = new HashMap<>();
    public static String commandList = "commandList.txt";
    public void inicialization(){
        mapOfCommands.put("jdi argolis", new jdiArgolis());
        mapOfCommands.put("jdi delos", new jdiDelos());
        mapOfCommands.put("jdi lakedaimon", new jdiLakedaimon());
        mapOfCommands.put("jdi miradell", new jdiMiradell());
        mapOfCommands.put("jdi nythrador", new jdiNythrador());
        mapOfCommands.put("jdi solmora", new jdiSolmora());
        mapOfCommands.put("jdi sylvaria", new jdiSylvaria());
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
