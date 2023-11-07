package com.OskarJohansson.DungeonRun.Control;

import java.util.Scanner;

public class GameControl {

    PlayerControl player;
    MapControl map;
    MenuControl menuControl;
    ShopControl shopControl;
    CombatControl combatControl;


    public GameControl() {

        this.player = new PlayerControl();
        this.map = new MapControl();
        this.menuControl = new MenuControl();
        this.shopControl = new ShopControl();
        this.combatControl = new CombatControl();

    }

    public void gameFlow() {

        System.out.printf("""
                               
                ++++|      \033[42m  Welcome to STI Dungeon Run!  \033[0m      |++++
                                
                _____________________________________________________                        
                #1 - Create a New Player    |   #2 - Load Game      |
                    
                """);

        boolean on = true;
        while (on)
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    menuControl.createNewPlayer(player);
                    on = false;
                }
                case 2 -> {
                    menuControl.loadPlayer(player);
                    on = false;
                }
                default -> System.out.println("Input must be 1 or 2!");
            }
        menuControl.mainMenu(player, menuControl, map, shopControl, combatControl);
    }
}

