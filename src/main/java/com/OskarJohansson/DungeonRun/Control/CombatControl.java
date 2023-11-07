package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Iterator;
import java.util.Scanner;

public class CombatControl {

    public boolean playerMinionBattleOptions(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                   
                   +++++|                                   Actions                               |+++++
                   _______________________________________________________________________________                         
                   #1 - Attack!  |   #2 - Drink Potion |   #3 - Flee!   |
                                
                >>>>    %s's turn! <<<<
                >>>>  Turning points: %d  <<<<
                                
                Choose Action: 
                                
                """, player.getHero().getName(), player.getHero().getTurningPoints());


        boolean on = true;
        while (on) {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    playerMinionBattle(player, mapControl);
                    on = false;
                }
                case 2 -> player.drinkHealthPotion();
                case 3 -> {
                    player.flee();
                    return false;
                }
                default -> System.out.println("Input must be 1-3!");
            }
        }
        return true;
    }

    public Boolean playerBossBattleOptions(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                   
                   +++++|                                   \033[0;32m    Actions      \033[0m                                            |+++++
                   ____________________________________________________________________________________________________                         
                   #1   -   Attack!   |   #2   -   Drink Potion   |   #3   -   Flee!  |
                                
                >>>>    %s's turn! <<<<
                >>>>  Turning points: %d  <<<<
                                
                Choose Action: 
                                
                """, player.getHero().getName(), player.getHero().getTurningPoints());

        boolean on = true;
        while (on) {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    playerBossBattle(player, mapControl);
                    on = false;
                }
                case 2 -> player.drinkHealthPotion();
                case 3 -> {
                    player.flee();
                    return false;
                }
                default -> System.out.println("Input must be 1-3!");
            }
        }
        return true;
    }

    private void minionResetTurningPoints(MapControl mapControl) {
        mapControl.currentLevel.getMinionMonsterList().forEach(c -> c.resetTurningPoints());
    }

    public void isPlayerKilled(MapControl mapControl) {
        mapControl.currentLevel.getMinionMonsterList().forEach(c -> {
            c.resetTurningPoints();
            c.resetHealthPoints();
        });
    }

    public void minionBattle(PlayerControl player, MapControl mapControl) {

        for (EnemyParentModel monster : mapControl.currentLevel.getMinionMonsterList()) {
            while (monster.getTurningPoints() > 0) {
                minionAttack(player, monster, mapControl);
                if (player.getHero().getHealthPoints() <= 0) {
                    return;
                }
            }
        }
    }


    public void minionAttack(PlayerControl player, EnemyParentModel monster, MapControl mapControl) {
        System.out.printf(">>>>     \033[4;31mMonster %d attacks!\033[0m     <<<<\n", mapControl.currentLevel.getMinionMonsterList().indexOf(monster) + 1);
        player.takeDamage(player.block(), monster.attack());
        player.getStatus();
    }

    public void playerMinionBattle(PlayerControl player, MapControl mapControl) {

        for (EnemyParentModel monster : mapControl.currentLevel.getMinionMonsterList()) {
            if (player.getHero().getTurningPoints() >= player.getHero().getWeapon().getTurnPoints()) {
                if (monster.getHealthPoints() > 0 && !monster.isKilled()) {
                    monster.getStatus();
                    monster.takeDamage(monster.block(), player.attack());
                }
                if (monster.getHealthPoints() <= 0 && !monster.isKilled()) {
                    ifEnemyIsKilled(player, monster);
                    monster.setKilled(true);
                }
            }
            if (player.getHero().getTurningPoints() <= 0) {
                System.out.println("You are out of Turning Points!");
            }
        }
    }

    private int checkEnemyList(MapControl mapControl) {
        Iterator<EnemyParentModel> iterator = mapControl.currentLevel.getMinionMonsterList().iterator();

        while (iterator.hasNext()) {
            EnemyParentModel c = iterator.next();
            if (c.getHealthPoints() <= 0) {
                iterator.remove();
            }
        }
        return mapControl.currentLevel.getMinionMonsterList().size();
    }

    private boolean ifEnemyIsKilled(PlayerControl player, EnemyParentModel monster) {
        System.out.printf("////     You killed the monster and gained %d experience points!     //// \n", monster.getExperiencePoints());
        player.getHero().setKillList(1);
        player.getHero().setExperiencePoints(monster.getExperiencePoints());
        player.getHero().setGold(monster.getGold());
        return true;
    }

    public void playerBossBattle(PlayerControl player, MapControl mapControl) {
        if (player.getHero().getTurningPoints() > 0) {
            if (mapControl.currentLevel.getFinalBoss().getHealthPoints() > 0 && !mapControl.currentLevel.getFinalBoss().isKilled()) {
                mapControl.currentLevel.getFinalBoss().getStatus();
                mapControl.currentLevel.getFinalBoss().takeDamage(mapControl.currentLevel.getFinalBoss().block(), player.attack());
            }
            if (mapControl.currentLevel.getFinalBoss().getHealthPoints() <= 0 && !mapControl.currentLevel.getFinalBoss().isKilled()) {
                System.out.printf("////     \033[0;31mYou killed %s and gained %d experience points!\033[0m      ////\n", mapControl.currentLevel.getFinalBoss().getName(), mapControl.currentLevel.getFinalBoss().getExperiencePoints());
                player.getHero().setKillList(1);
                player.getHero().setExperiencePoints(mapControl.currentLevel.getFinalBoss().getExperiencePoints());
                player.getHero().setGold(mapControl.currentLevel.getFinalBoss().getGold());
                mapControl.currentLevel.getFinalBoss().setKilled(true);
            }
        }
        if (player.getHero().getTurningPoints() <= 0) {
            System.out.println("You are out of Turning Points!");
        }
    }

    public void bossBattle(PlayerControl player, MapControl mapControl) {
        while (mapControl.currentLevel.getFinalBoss().getTurningPoints() > 0) {
            System.out.printf(">>>>     \033[4;31m%s attacks!\033[0m     <<<<\n", mapControl.currentLevel.getFinalBoss().getName());
            player.takeDamage(player.block(), mapControl.currentLevel.getFinalBoss().attack());
            if (player.getHero().getHealthPoints() <= 0) {
                return;
            }
        }
    }

    public void minionBattleControl(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, mapControl.currentLevel.getMinionMonsterList().size());

        boolean on = true;
        do {

            player.resetTurningPoints();
            minionResetTurningPoints(mapControl);
            minionBattle(player, mapControl);
            if (checkEnemyList(mapControl) == 0) {

                System.out.println("////    \033[0;31m  You have killed all the monsters!   \033[0m   ////\n");
                player.levelUp();
                return;
            }
            if (player.checkHealthPoints()) {
                isPlayerKilled(mapControl);
                return;
            }

            Boolean flee = playerMinionBattleOptions(player, mapControl);
            on = flee;

            System.out.println("\n \033[42mGet ready for a new round!\033[0m\n \033[42mPress Enter to continue \033[0m\n");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

        } while (on);
    }

    public void bossBattleControl(PlayerControl player, MapControl mapControl) {

        System.out.printf("""
                You are being attacked by %s!
                                
                """, mapControl.currentLevel.getFinalBoss().getName());
        boolean on = true;
        do {
            player.resetTurningPoints();
            mapControl.currentLevel.getFinalBoss().resetTurningPoints();

            bossBattle(player, mapControl);
            playerBossBattle(player, mapControl);

            if (mapControl.currentLevel.getFinalBoss().isKilled()) {
                player.levelUp();
                return;
            }
            if (player.checkHealthPoints()) {
                isPlayerKilled(mapControl);
                return;
            }

            Boolean flee = playerBossBattleOptions(player, mapControl);
            on = flee;

            System.out.println("\n \033[42mGet ready for a new round!\033[0m\n \033[42mPress Enter to continue \033[0m\n");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

        } while (on);
    }
}
