package Game;

import Game.Map.City;
import Game.Map.LoadMap;

public class Game {

    private City currentCity;

    public Game(){


    }


    public Game(City startingCity){
        this.currentCity = startingCity;
    }

    public void startGame(){
        LoadMap loadMap = new LoadMap();
        if (!loadMap.loadMap()){
            System.out.println("Load map failed");
            return;
        }
        // startovni lokace
        City startingCity = loadMap.findCity("hellas");
        if (startingCity == null){
            System.out.println("Starting city not found");
            return;
        }
        Game game = new Game(startingCity);
        Movement movement = new Movement();


    }


}
