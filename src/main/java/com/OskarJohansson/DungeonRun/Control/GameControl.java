package com.OskarJohansson.DungeonRun.Control;

public class GameControl {

    PlayerControl player;
    MapControl map;
    MenuControl mainMenu;


    public GameControl(){
        System.out.printf("""
                
                ++++|        Welcome to STI Dungeon Run!        |++++
                
                """);
        this.player = new PlayerControl();
        this.map = new MapControl();
        this.mainMenu = new MenuControl();

    }

    public void gameFlow(){
        mainMenu.mainMenu(player,mainMenu, map);



    }
}

