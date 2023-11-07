package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Characters.CodeMonkey;
import com.OskarJohansson.DungeonRun.Repository.PlayerManager;

import java.util.Scanner;

public class MenuControl {


    public void mainMenu(PlayerControl player, MenuControl mainMenu, MapControl mapControl, ShopControl shopControl, CombatControl combatControl) {
        boolean on = true;

        do {
            System.out.printf("""
                                         
                    +++++|                                          \033[42m   Main Menu   \033[0m                                                         |+++++
                    ______________________________________________________________________________________________________________________________                         
                    #1 - Show %s the %s's Level  |   #2 - Show Stats  |   #3 - Show MAP   |   #4 - Enter SHOP   |   #5 - Save Game   |
                                         
                     """, player.getHero().getName(), player.getHero().getHeroClass());

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> player.getPlayerStats();
                case 2 -> player.getStatus();
                case 3 -> mapMenu(mapControl, player, combatControl);
                case 4 -> shopControl.shop(player);
                case 5 -> savePlayer(player);
                default -> System.out.println("Input must be 1 - 5!");
            }
        } while (on);
    }

    public void savePlayer(PlayerControl player){
        PlayerManager playerManager = new PlayerManager();
        playerManager.saveHeroToFile(player.getHero());
        System.out.println("Game saved!");
    }

    public void loadPlayer(PlayerControl player){
        PlayerManager playerManager = new PlayerManager();
        player.setHero(playerManager.loadHeroFromFile());
    }

    public void createNewPlayer(PlayerControl player){
        setNameAndCharacter(player);
    }

    public void mapMenu(MapControl mapControl, PlayerControl player, CombatControl combatControl) {

        boolean on = true;
        do {
            System.out.println("""
                    +++++|                           \033[42m   Explore the world of STI!   \033[0m                            +++++
                    ________________________________________________________________________________________________________________             
                    #1 - Battle the Minions of ICA  |   #2 - Defeat the PT's of Sats    |   #3 - Challenge the Wizards of Kjell&Co  |
                    #4 - Conquer the Tower of the Teachers Lounge  |   #5 - Drink potion  |   #6 - Return to main menu  |
                                    
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
                    if (player.getHero().getLevel() < 4 ) {
                        System.out.println("You must be level 5 to enter Teacher Lounge!");
                    }
                    if (!player.getHero().isCodeBreaker())
                    {
                        System.out.println("You can't crack the security code to break in to the Tower! Defeat the Nerd Wizard of Kjell & Co to attain the Code Breaker!");
                        break;
                    }
                    mapControl.setMap(4);
                    System.out.println("Entering the Tower of The Teachers Lounge");
                    mapStructure(mapControl, player, combatControl);
                }
                case 5 -> {
                    player.drinkHealthPotion();
                    on = false;
                }
                case 6 -> {
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
                    +++++|                      \033[42m    %s  \033[0m                       |+++++
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

    public void setNameAndCharacter(PlayerControl player) {
        setCharacter(player);
        System.out.printf("You have chosen to play as a %s\n", player.getHero().getHeroClass());
        System.out.println("Chose a name for your Hero: ");
        player.getHero().setName(new Scanner(System.in).nextLine());
        System.out.printf("Welcome %s the %s ", player.getHero().getName(), player.getHero().getHeroClass());
    }

    public void setCharacter(PlayerControl player) {

        boolean on = true;
        do {
            System.out.printf("""
                              
                    ++++|                 \033[0;92m    Pick a Hero \033[0m               |++++
                    _________________________________________________________              
                          |   #1 - Barbarian  |   #2 - Code Monkey   |
                                    
                    """);

            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    player.setHero(new Barbarian());
                    on = false;
                }
                case 2 -> {
                    player.setHero(new CodeMonkey());
                    on = false;
                }

                default -> System.out.println("Input must be 1 - 2!");
            }
        } while (on);
    }
}

