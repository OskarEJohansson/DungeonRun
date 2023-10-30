package com.OskarJohansson.DungeonRun;

import com.OskarJohansson.DungeonRun.Model.*;
import com.OskarJohansson.DungeonRun.Model.MapObject;
import com.OskarJohansson.DungeonRun.Model.Menu.MainMenu;

public class GameFlow {

    Player player;
    MapObject map;
    MainMenu mainMenu;


    public GameFlow(){
        System.out.printf("""
                Welcome to STI Dungeon Run!
                Pick your Hero and fight your way through dungeon of STI!
                
                """);
        this.player = new Player();
        this.map = new MapObject();
        this.mainMenu = new MainMenu();

    }

    public void gameFlow(){
        mainMenu.mainMenu(player, map);



    }
}

