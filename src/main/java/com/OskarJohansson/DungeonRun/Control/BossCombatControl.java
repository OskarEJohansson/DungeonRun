package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BossCombatControl {

    public void bossBattleControl(PlayerControl player, MapControl mapControl, MenuControl menuControl, BossCombatControl bossCombatControl) {

        System.out.println(displayBossNameInBattle(mapControl));

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

            if (player.getHero().getTurningPoints() > 0)
                on = menuControl.playerBossBattleOptions(player, mapControl, bossCombatControl);

            System.out.println("\n \033[42mGet ready for a new round!\033[0m\n \033[42mPress Enter to continue \033[0m\n");
            Scanner sc = new Scanner(System.in);
            sc.nextLine();

        } while (on);
    }

    public String displayBossNameInBattle(MapControl mapControl) {
        return System.out.printf("""
                You are being attacked by %s!
                                
                """, mapControl.currentLevel.getFinalBoss().getName()).toString();
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
            if (isBossKilled(mapControl, player)) {
                if (isBossNerdWizard(mapControl, player)) ;
                return;
            }
        }
        if (player.getHero().getTurningPoints() <= 0) {
            System.out.println("You are out of Turning Points!");
        }
    }

    public void resetMinionAndBossHealthAndTurningPointsWhenPlayerHasDied(MapControl mapControl) {
        mapControl.currentLevel.getMonsterList().forEach(c -> {
            c.resetTurningPoints();
            c.resetHealthPoints();
        });
        mapControl.currentLevel.getFinalBoss().resetHealthPoints();
        mapControl.currentLevel.getFinalBoss().resetTurningPoints();
    }

    public boolean isBossKilled(MapControl mapControl, PlayerControl player) {
        if (mapControl.currentLevel.getFinalBoss().getHealthPoints() <= 0 && !mapControl.currentLevel.getFinalBoss().isKilled()) {
            System.out.printf("////     \033[0;31mYou killed %s and gained %d experience points!\033[0m     ////\n", mapControl.currentLevel.getFinalBoss().getName(), mapControl.currentLevel.getFinalBoss().getExperiencePoints());
            player.getHero().setKillList(1);
            player.getHero().setExperiencePoints(mapControl.currentLevel.getFinalBoss().getExperiencePoints());
            player.getHero().setGold(mapControl.currentLevel.getFinalBoss().getGold());
            mapControl.currentLevel.getFinalBoss().setKilled(true);
            return true;
        }
        return false;
    }

    public boolean isBossNerdWizard(MapControl mapControl, PlayerControl player) {
        if (Objects.equals(mapControl.currentLevel.getFinalBoss().getName(), "Nerd Wizard")) {
            player.getHero().setCodeBreaker(true);
            return true;
        }
        return false;
    }
}
