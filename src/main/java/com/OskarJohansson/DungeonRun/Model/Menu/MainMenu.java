package com.OskarJohansson.DungeonRun.Model.Menu;

import com.OskarJohansson.DungeonRun.Model.MapObject;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Scanner;

public class MainMenu {


    public void mainMenu(Player player, MapObject map) {
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
                case 2 -> mapMenu(map, player);
                case 3 -> System.out.println("ENTER SHOP");
            }
        } while (on);
    }

    public void mapMenu(MapObject map, Player player) {
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
                mapStructure(map, player);
            }
            case 2 -> System.out.println("MAP.SETMAP(SATS)");
            case 3 -> System.out.println("MAP.SETMAP(KJELLCO)");
        }
    }
    public void mapStructure(MapObject map, Player player) {

        System.out.println("Welcome to Level 1!");
        boolean on = true;

        System.out.println("""
                #1 - Enter KillZone!
                #2 - Leave Level!
                """);
        do
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    System.out.println("Enter kill zone!");
                    map.battle(player);
                }
                case 2 -> {
                    System.out.println("You are leaving the Level!");
                    on = false;
                }
            } while (on);
    }
}

