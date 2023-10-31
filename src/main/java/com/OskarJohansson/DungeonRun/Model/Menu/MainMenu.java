package com.OskarJohansson.DungeonRun.Model.Menu;

import com.OskarJohansson.DungeonRun.Control.MapObject;
import com.OskarJohansson.DungeonRun.Control.Player;

import java.util.Scanner;

public class MainMenu {


    public void mainMenu(Player player,MainMenu mainMenu, MapObject map) {
        boolean on = true;

        do {
            System.out.println("""
                                        
                    Main Menu.
                                        
                    #1 - Show PLAYER STATS
                    #2 - show MAP
                    #3 - enter SHOP
                                        
                    """);

            switch (new Scanner(System.in).nextInt()) {
                case 1 -> player.getStatus();
                case 2 -> mapMenu(map, mainMenu, player);
                case 3 -> System.out.println("ENTER SHOP");
            }
        } while (on);
    }

    public void mapMenu(MapObject map, MainMenu mainMenu, Player player) {
        System.out.println("""
                Explore the world of STI!
                                
                #1 - Battle the Minions of ICA
                #2 - Defeat the PT's of SATS
                #3 - Challage the Wizzards of Kjell&Co
                                
                """);

        switch(new Scanner(System.in).nextInt()){
            case 1 -> {
                map.setMap(1);
                System.out.println("Get ready for battle!");
                mapStructure(map, mainMenu, player);
            }
            case 2 -> System.out.println("MAP.SETMAP(SATS)");
            case 3 -> System.out.println("MAP.SETMAP(KJELLCO)");
        }
    }
    public void mapStructure(MapObject map, MainMenu mainMenu, Player player) {

        System.out.println("Welcome to Level 1!");
        boolean on = true;

        do {
            System.out.println("""
                    Menu - Level 1
                    #1 - Enter KillZone!
                    #2 - Enter BossZone!
                    #3 - Leave Level!
                    """);
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    System.out.println("Enter kill zone!");
                    map.minionBattleControl(player, mainMenu, map);
                }
                case 2 -> {
                    System.out.println("Enter Boss fight zone!");
                    map.bossBattleControl(player);
                    on = false;
                }
                case 3 -> {
                    System.out.println("You are leaving the Level!");
                    on = false;
                }
            }
        } while (on) ;
    }
}

