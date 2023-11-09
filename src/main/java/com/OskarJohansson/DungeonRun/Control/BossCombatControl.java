package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Objects;
import java.util.Scanner;

public class BossCombatControl {

    public Boolean playerBossBattleOptions(PlayerControl player, MapControl mapControl) {
        boolean on = true;
        while (on) {

            System.out.printf("""
                       
                       +++++|                                   \033[0;32m    Actions      \033[0m                                            |+++++
                       ____________________________________________________________________________________________________\s
                       #1   -   Attack!   |   #2   -   Drink Potion   |   #3   -   Flee!  |
                                    
                    >>>>    %s's turn! <<<<
                    >>>>  Turning points: %d  <<<<
                                    
                    Choose Action:\s
                                    
                    """, player.getHero().getName(), player.getHero().getTurningPoints());


            switch (UserInputControl.inputInt()) {
                case 1 -> {
                    playerAttackBoss(player, mapControl);
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

    public void bossBattleControl(PlayerControl player, MapControl mapControl, MenuControl menuControl) {
        System.out.printf("""
                You are being attacked by %s!
                                
                """, mapControl.currentLevel.getFinalBoss().getName());

        boolean on = true;
        do {
            player.getHero().resetTurningPoints();
            mapControl.currentLevel.getFinalBoss().resetTurningPoints();

            if (!mapControl.currentLevel.getFinalBoss().isKilled()) {
                bossAttack(player, mapControl, menuControl);
            }
            if (mapControl.currentLevel.getFinalBoss().isKilled()) {
                player.levelUp(player);
                return;
            }
            if (player.isPlayerKilledInCombat(player)) {
                resetMinionAndBossHealthAndTurningPointsWhenPlayerHasDied(mapControl);
                return;
            }

            if (player.getHero().getTurningPoints() > 0) on = playerBossBattleOptions(player, mapControl);

            System.out.println("\n \033[42mGet ready for a new round!\033[0m\n \033[42mPress Enter to continue \033[0m\n");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

        } while (on);
    }

    public void bossAttack(PlayerControl player, MapControl mapControl, MenuControl menuControl) {
        while (mapControl.currentLevel.getFinalBoss().getTurningPoints() > 0) {
            System.out.printf(">>>>     \033[4;31m%s attacks!\033[0m     <<<<\n", mapControl.currentLevel.getFinalBoss().getName());
            player.takeDamage(player, player.block(player), mapControl.currentLevel.getFinalBoss().attack());
            menuControl.getStatus(player);
            if (player.getHero().getHealthPoints() <= 0) {
                return;
            }
        }
    }

    public void playerAttackBoss(PlayerControl player, MapControl mapControl) {

        while (player.getHero().getTurningPoints() > 0) {
            if (mapControl.currentLevel.getFinalBoss().getHealthPoints() > 0 && !mapControl.currentLevel.getFinalBoss().isKilled()) {
                mapControl.currentLevel.getFinalBoss().getStatus();
                mapControl.currentLevel.getFinalBoss().takeDamage(mapControl.currentLevel.getFinalBoss().block(), player.attack(player));
            }

            if (mapControl.currentLevel.getFinalBoss().getHealthPoints() <= 0 && !mapControl.currentLevel.getFinalBoss().isKilled()) {
                System.out.printf("////     \033[0;31mYou killed %s and gained %d experience points!\033[0m     ////\n", mapControl.currentLevel.getFinalBoss().getName(), mapControl.currentLevel.getFinalBoss().getExperiencePoints());
                player.getHero().setKillList(1);
                player.getHero().setExperiencePoints(mapControl.currentLevel.getFinalBoss().getExperiencePoints());
                player.getHero().setGold(mapControl.currentLevel.getFinalBoss().getGold());
                mapControl.currentLevel.getFinalBoss().setKilled(true);

                if (Objects.equals(mapControl.currentLevel.getFinalBoss().getName(), "Nerd Wizard")) {
                    player.getHero().setCodeBreaker(true);
                }
                return;
            }
            if (player.getHero().getTurningPoints() <= 0) {
                System.out.println("You are out of Turning Points!");
                return;
            }
        }
    }

    public void resetMinionAndBossHealthAndTurningPointsWhenPlayerHasDied(MapControl mapControl) {
        mapControl.currentLevel.getMinionMonsterList().forEach(c -> {
            c.resetTurningPoints();
            c.resetHealthPoints();
        });
        mapControl.currentLevel.getFinalBoss().resetHealthPoints();
        mapControl.currentLevel.getFinalBoss().resetTurningPoints();
    }

    public boolean ifPlayerHasKilledTheCurrantEnemy(PlayerControl player, EnemyParentModel monster) {
        System.out.printf("////     You killed the monster and gained %d experience points!    //// \n", monster.getExperiencePoints());
        player.getHero().setKillList(1);
        player.getHero().setExperiencePoints(monster.getExperiencePoints());
        player.getHero().setGold(monster.getGold());
        return true;
    }
}