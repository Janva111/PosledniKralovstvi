package City;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoadMap {

    private String start = "Hellas";
    private String currentPosition = start;

    private FileReader fileReader;

    public boolean loadMap(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Movement.txt"));
            String line;
            while((line = br.readLine()) != null){

            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
