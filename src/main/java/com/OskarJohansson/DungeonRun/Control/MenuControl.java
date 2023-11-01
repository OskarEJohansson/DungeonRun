package com.OskarJohansson.DungeonRun.Control;

import java.util.Scanner;

public class MenuControl {


    public void mainMenu(PlayerControl player, MenuControl mainMenu, MapControl map) {
        boolean on = true;

        do {
            System.out.printf("""
                                        
                   +++++|                       Main Menu                          |+++++
                   ______________________________________________________________________                    
                   #1 - Show %s the %s STATS  |   #2 - Show MAP   |   #3 - Enter SHOP   |
                                        
                    """, player.getName(), player.getHeroClass());

            switch (new UserInput().inputInt(new Scanner(System.in))) {
                case 1 -> player.getPlayerStats();
                case 2 -> mapMenu(map, mainMenu, player);
                case 3 -> System.out.println("ENTER SHOP");
                default -> System.out.println("Input must be 1 - 3!");
            }
        } while (on);
    }

    public void mapMenu(MapControl map, MenuControl mainMenu, PlayerControl player) {
        System.out.println("""
                +++++|                                  Explore the world of STI!                                          |+++++
                _________________________________________________________________________________________________________________               
                #1 - Battle the Minions of ICA  |   #2 - Defeat the PT's of Sats    |   #3 - Challenge the Wizards of Kjell&Co  |
                                
                """);

        switch(new UserInput().inputInt(new Scanner(System.in))){
            case 1 -> {
                map.setMap(1);
                System.out.println("Entering the Dungeons of Ica");
                mapStructure(map, player);
            }
            case 2 -> {
                map.setMap(2);
                System.out.println("Entering the Dungeons of Sats");
                mapStructure(map, player);
            }
            case 3 -> {
                map.setMap(3);
                System.out.println("Entering the Dungeons of Kjell & Co");
                mapStructure(map, player);
            }
            default -> System.out.println("Input must be 1 - 3!");
        }
    }
    public void mapStructure(MapControl map, PlayerControl player) {

        boolean on = true;

        do {
            System.out.printf("""
                    +++++|                              Level %s                           |+++++
                    +++++|                              %s                                 |+++++
                    _____________________________________________________________________________
                    #1 - Enter Kill Zone!    |   #2 - Enter Boss Zone!    |   #3 - Leave Level! |
                    """, map.getLevelNumber(), map.getLevelName());
            switch (new UserInput().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    System.out.println("You are entering the kill zone!");
                    map.minionBattleControl(player);
                }
                case 2 -> {
                    System.out.println("You are about to challenging the stage Boss!");
                    map.bossBattleControl(player);
                    on = false;
                }
                case 3 -> {
                    System.out.println("You are leaving the Level!");
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");

            }
        } while (on) ;
    }
}

