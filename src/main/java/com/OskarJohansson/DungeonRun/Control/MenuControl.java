package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Characters.CodeMonkey;
import com.OskarJohansson.DungeonRun.Repository.PlayerManager;

import java.util.Scanner;

public class MenuControl {


    public void mainMenu(PlayerControl player, MenuControl menuControl, MapControl mapControl, ShopControl shopControl, BossCombatControl bossCombatControl, MonsterCombatControl monsterCombatControl) {
        boolean on = true;

        do {
            System.out.printf("""
                                         
                    +++++|                                          \033[42m   Main Menu   \033[0m                                                         |+++++
                    ______________________________________________________________________________________________________________________________                         
                    #1 - Show %s the %s's Level  |   #2 - Show Stats  |   #3 - Show MAP   |   #4 - Enter SHOP   |   #5 - Save Game   |
                                         
                     """, player.getHero().getName(), player.getHero().getHeroClass());

            switch (UserInputControl.inputInt()) {
                case 1 -> getPlayerStats(player);
                case 2 -> getStatus(player);
                case 3 -> mapMenu(mapControl, player, bossCombatControl, menuControl, monsterCombatControl);
                case 4 -> shopControl.shop(player);
                case 5 -> savePlayer(player);
                default -> System.out.println("Input must be 1 - 5!");
            }
        } while (on);
    }

    public void savePlayer(PlayerControl player) {
        PlayerManager playerManager = new PlayerManager();
        playerManager.saveHeroToFile(player.getHero());
        System.out.println("Game saved!");
    }

    public void loadPlayer(PlayerControl player) {
        PlayerManager playerManager = new PlayerManager();
        player.setHero(playerManager.loadHeroFromFile());
    }

    public void createNewPlayer(PlayerControl player) {
        setNameAndCharacter(player);
    }

    public void mapMenu(MapControl mapControl, PlayerControl player, BossCombatControl bossCombatControl, MenuControl menuControl, MonsterCombatControl monsterCombatControl) {

        boolean on = true;
        do {
            System.out.println("""
                    +++++|                           \033[42m   Explore the world of STI!   \033[0m                            +++++
                    ________________________________________________________________________________________________________________             
                    #1 - Battle the Minions of ICA  |   #2 - Defeat the PT's of Sats    |   #3 - Challenge the Wizards of Kjell&Co  |
                    #4 - Conquer the Tower of the Teachers Lounge  |   #5 - Drink potion  |   #6 - Return to main menu  |
                                    
                    """);

            switch (UserInputControl.inputInt()) {
                case 1 -> {
                    mapControl.setMap(1);
                    System.out.println("Entering the Dungeons of Ica");
                    mapStructure(mapControl, player, bossCombatControl, menuControl, monsterCombatControl);
                }
                case 2 -> {
                    if (player.getHero().getLevel() < 2) {
                        System.out.println("You must be level 2 to enter Sats!");
                        return;
                    }
                    mapControl.setMap(2);
                    System.out.println("Entering the Dungeons of Sats");
                    mapStructure(mapControl, player, bossCombatControl, menuControl, monsterCombatControl);
                }
                case 3 -> {
                    if (player.getHero().getLevel() < 3) {
                        System.out.println("You must be level 3 to enter Kjell & Co !");
                        return;
                    }
                    mapControl.setMap(3);
                    System.out.println("Entering the Dungeons of Kjell & Co");
                    mapStructure(mapControl, player, bossCombatControl, menuControl, monsterCombatControl);

                }
                case 4 -> {
                    if (player.getHero().getLevel() < 4) {
                        System.out.println("You must be level 5 to enter Teacher Lounge!");
                    }
                    if (!player.getHero().isCodeBreaker()) {
                        System.out.println("You can't crack the security code to break in to the Tower! Defeat the Nerd Wizard of Kjell & Co to attain the Code Breaker!");
                        return;
                    }
                    mapControl.setMap(4);
                    System.out.println("Entering the Tower of The Teachers Lounge");
                    mapStructure(mapControl, player, bossCombatControl, menuControl, monsterCombatControl);
                }
                case 5 -> {
                    player.drinkHealthPotion(player);
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

    public void mapStructure(MapControl mapControl, PlayerControl player, BossCombatControl bossCombatControl1, MenuControl menuControl, MonsterCombatControl monsterCombatControl) {

        boolean on = true;

        do {
            System.out.printf("""
                    +++++|                          \033[42m   Level %s   \033[0m                           |+++++
                    +++++|                      \033[42m    %s  \033[0m                       |+++++
                    _____________________________________________________________________________
                    #1 - Enter Kill Zone!    |   #2 - Enter Boss Zone!    |   #3 - Leave Level! |
                    """, mapControl.currentLevel.getLevelNumber(), mapControl.currentLevel.getLevelName());

            switch (UserInputControl.inputInt()) {
                case 1 -> {
                    System.out.println("You are entering the kill zone!");
                    monsterCombatControl.monsterBattleControl(player, mapControl, menuControl, monsterCombatControl);
                }
                case 2 -> {
                    System.out.println("You are about to challenging the stage Boss!");
                    bossCombatControl1.bossBattleControl(player, mapControl, menuControl, bossCombatControl1);
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

            switch (UserInputControl.inputInt()) {
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

    public void getPlayerStats(PlayerControl player) {
        player.levelUp(player);
        System.out.printf("""
                ++++|                                         \033[0;35m    Stats   \033[0m                                                                                 |++++
                ________________________________________________________________________________________________________________________________________________             
                Level  \033[1;33m%d\033[0m   |   Experience Points   \033[1;33m%d/%d\033[0m  |   Strength    \033[1;35m%d\033[0m  |   Intelligence   \033[1;32m%d\033[0m  |   Agility   \033[1;31m%d\033[0m  |   Weapon   \033[4;31m%s\033[0m    |   HealthPotions   \033[0;34m%d\033[0m   |
                                
                """, player.getHero().getLevel(), player.getHero().getExperiencePoints(), player.getHero().getLevel() * 10, player.getHero().getStrength(), player.getHero().getIntelligence(), player.getHero().getAgility(), player.getHero().getWeapon().getName(), player.getHero().getPotionStash().size());
    }

    public void getStatus(PlayerControl player) {
        player.levelUp(player);
        System.out.printf("""
                ++++|                                           \033[0;35m  Stats   \033[0m                                                                       |++++
                ______________________________________________________________________________________________________________________________________
                %s the %s   |   Death count   \033[0;31m%d\033[0m    |   Kill count   \033[0;31m%d\033[0m  |   Health Points   \033[0;34m%d/%d\033[0m  |   Turning Points  \033[1;31m%d/%d\033[0m   |   Gold    \033[1;33m%d\033[0m |
                                
                """, player.getHero().getName(), player.getHero().getHeroClass(), player.getHero().getDeathCount(), player.getHero().getKillList(), player.getHero().getHealthPoints(), player.getHero().getHealthPointsBase(), player.getHero().getTurningPoints(), player.getHero().getTurningPointsBase(), player.getHero().getGold());
    }

    public void displayPlayerOptionsInBattleOptions(PlayerControl player) {
        System.out.printf("""
                   
                   +++++|                                   Actions                               |+++++
                   _______________________________________________________________________________\s
                   #1 - Attack!  |   #2 - Drink Potion |   #3 - Flee!   |
                                
                >>>>    %s's turn! <<<<
                >>>>  Turning points: %d  <<<<
                                
                Choose Action:\s
                                
                """, player.getHero().getName(), player.getHero().getTurningPoints());
    }

    public boolean playerMinionBattleOptions(PlayerControl player, MapControl mapControl, MonsterCombatControl monsterCombatControl) {
        boolean on = true;
        while (on) {

            displayPlayerOptionsInBattleOptions(player);

            switch (UserInputControl.inputInt()) {
                case 1 -> {
                    monsterCombatControl.iterateMinionMonsterListAndAttackMonster(player, mapControl);
                    on = false;
                }
                case 2 -> player.drinkHealthPotion(player);
                case 3 -> {
                    player.flee(player);
                    return false;
                }
                default -> System.out.println("Input must be 1-3!");
            }
        }
        return true;
    }

    public Boolean playerBossBattleOptions(PlayerControl player, MapControl mapControl, BossCombatControl bossCombatControl) {
        boolean on = true;
        while (on) {

            displayPlayerOptionsInBattleOptions(player);

            switch (UserInputControl.inputInt()) {
                case 1 -> {
                    bossCombatControl.playerAttackBoss(player, mapControl);
                    on = false;
                }
                case 2 -> player.drinkHealthPotion(player);
                case 3 -> {
                    player.flee(player);
                    return false;
                }
                default -> System.out.println("Input must be 1-3!");
            }
        }
        return true;
    }
}

