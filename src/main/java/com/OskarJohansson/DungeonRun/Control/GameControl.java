package com.OskarJohansson.DungeonRun.Control;

import java.util.Scanner;

public class GameControl {

    PlayerControl player;
    MapControl map;
    MenuControl mainMenu;
    ShopControl shopControl;
    CombatControl combatControl;


    public GameControl() {
        System.out.printf("""
                                
                ++++|        Welcome to STI Dungeon Run!        |++++
                """);

        this.player = new PlayerControl();
        this.map = new MapControl();
        this.mainMenu = new MenuControl();
        this.shopControl = new ShopControl();
        this.combatControl = new CombatControl();

    }

    public void gameFlow(){

        player.setNameAndCharacter();

        mainMenu.mainMenu(player, mainMenu, map, shopControl, combatControl);

    }
}

