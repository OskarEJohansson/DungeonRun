package com.OskarJohansson.DungeonRun.Control;

import java.util.Scanner;

public class MenuControl {


    public void mainMenu(PlayerControl player, MenuControl mainMenu, MapControl mapControl, ShopControl shopControl, CombatControl combatControl) {
        boolean on = true;

        do {
            System.out.printf("""
                                         
                    +++++|                                \033[42m   Main Menu   \033[0m                                         |+++++
                    ____________________________________________________________________________________________________                         
                    #1 - Show %s the %s Level  |   #2 - Show Stats  |   #3 - Show MAP   |   #4 - Enter SHOP   |
                                         
                     """, player.getHero().getName(), player.getHero().getHeroClass());

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> player.getPlayerStats();
                case 2 -> player.getStatus();
                case 3 -> mapMenu(mapControl, mainMenu, player, combatControl);
                case 4 -> shopControl.shop(player);
                default -> System.out.println("Input must be 1 - 4!");
            }
        } while (on);
    }

    public void loadPlayer(){

    }

    public void createNewPlayer(){

    }

    public void mapMenu(MapControl mapControl, MenuControl mainMenu, PlayerControl player, CombatControl combatControl) {

        boolean on = true;
        do {
            System.out.println("""
                    +++++|                                   \033[42m   Explore the world of STI!   \033[0m                                                                    |+++++
                    ______________________________________________________________________________________________________________________________________________                
                    #1 - Battle the Minions of ICA  |   #2 - Defeat the PT's of Sats    |   #3 - Challenge the Wizards of Kjell&Co  |   #4 - Return to main menu  |
                                    
                    """);

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    mapControl.setMap(1);
                    System.out.println("Entering the Dungeons of Ica");
                    mapStructure(mapControl, player, combatControl);
                }
                case 2 -> {
                    if (player.getHero().getLevel() < 2) {
                        System.out.println("You must be level 2 to enter Sats!");
                        break;
                    }
                    mapControl.setMap(2);
                    System.out.println("Entering the Dungeons of Sats");
                    mapStructure(mapControl, player, combatControl);
                }
                case 3 -> {
                    if (player.getHero().getLevel() < 3) {
                        System.out.println("You must be level 3 to enter Kjell & Co !");
                        break;
                    }
                    mapControl.setMap(3);
                    System.out.println("Entering the Dungeons of Kjell & Co");
                    mapStructure(mapControl, player, combatControl);
                }
                case 4 -> {
                    System.out.println("Returning to Main Menu");
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");
            }
        } while (on);
    }

    public void mapStructure(MapControl mapControl, PlayerControl player, CombatControl combatControl) {

        boolean on = true;

        do {
            System.out.printf("""
                    +++++|                          \033[42m   Level %s   \033[0m                           |+++++
                    +++++|                      \033[42m    %s  \033[0m                     |+++++
                    _____________________________________________________________________________
                    #1 - Enter Kill Zone!    |   #2 - Enter Boss Zone!    |   #3 - Leave Level! |
                    """, mapControl.currentLevel.getLevelNumber(), mapControl.currentLevel.getLevelName());

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    System.out.println("You are entering the kill zone!");
                    combatControl.minionBattleControl(player, mapControl);
                }
                case 2 -> {
                    System.out.println("You are about to challenging the stage Boss!");
                    combatControl.bossBattleControl(player, mapControl);
                    on = false;
                }
                case 3 -> {
                    System.out.println("You are leaving the Level!");
                    on = false;
                }
                default -> System.out.println("Input must be 1 - 3!");

            }
        } while (on);
    }
}

