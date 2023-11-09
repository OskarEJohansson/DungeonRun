package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Scanner;

public class NewCombatControl {

    public void minionBattleControl(PlayerControl player, MapControl mapControl, MenuControl menuControl, NewCombatControl newCombatControl) {

        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, mapControl.currentLevel.getMinionMonsterList().size());

        boolean on = true;
        do {
            player.getHero().resetTurningPoints();

            minionResetTurningPoints(mapControl);
            minionBattle(player, mapControl, menuControl);

            if (hasPlayerKilledAllTheEnemies(mapControl, player)) {
                return;
            }
            if (player.isPlayerKilledInCombat(player)) {
                resetMinionAndBossHealthAndTurningPointsWhenPlayerIsKilled(mapControl);
                return;
            }
            if (player.getHero().getTurningPoints() > 0)
                on = menuControl.playerMinionBattleOptions(player, mapControl, newCombatControl);

            pressEnterToContinue();

        } while (on);
    }

    public boolean hasPlayerKilledAllTheEnemies(MapControl mapControl, PlayerControl player) {
        if (checkEnemyList(mapControl) == 0) {
            System.out.println("////    \033[0;31m  You have killed all the monsters!   \033[0m   ////\n");
            player.levelUp(player);
            return true;
        }
        return false;
    }

    public void minionBattle(PlayerControl player, MapControl mapControl, MenuControl menuControl) {
        for (EnemyParentModel monster : mapControl.currentLevel.getMinionMonsterList()) {
            while (monster.getTurningPoints() > 0) {
                minionAttackPlayer(player, monster, mapControl, menuControl);
                if (player.getHero().getHealthPoints() <= 0) {
                    return;
                }
            }
        }
    }

    public void minionAttackPlayer(PlayerControl player, EnemyParentModel monster, MapControl mapControl, MenuControl menuControl) {
        System.out.printf(">>>>     \033[4;31m%s %d attacks!\033[0m     <<<<\n", monster.getName(), mapControl.currentLevel.getMinionMonsterList().indexOf(monster) + 1);
        player.takeDamage(player, player.block(player), monster.attack());
        menuControl.getStatus(player);
    }

    private int checkEnemyList(MapControl mapControl) {
        mapControl.currentLevel.getMinionMonsterList().removeIf(c -> c.getHealthPoints() <= 0);
        return mapControl.currentLevel.getMinionMonsterList().size();
    }

    private void minionResetTurningPoints(MapControl mapControl) {
        for (EnemyParentModel monster : mapControl.currentLevel.getMinionMonsterList()) {
            monster.resetTurningPoints();
        }
    }

    public void playerAttackCurrantMinion(EnemyParentModel currantMonster, PlayerControl player) {
        if (currantMonster.getHealthPoints() > 0 && !currantMonster.isKilled()) {
            currantMonster.takeDamage(currantMonster.block(), player.attack(player));
            currantMonster.getStatus();
        }
    }

    public boolean checkIfPlayerHasKilledCurrantMinion(EnemyParentModel currantMonster, PlayerControl player) {
        if (currantMonster.getHealthPoints() <= 0 && !currantMonster.isKilled()) {
            ifPlayerHasKilledTheCurrantEnemy(player, currantMonster);
            return true;
        }
        return false;
    }

    public boolean checkIfPlayerIsOutOfTurningPoints(PlayerControl player) {
        if (player.getHero().getTurningPoints() <= 0) {
            System.out.println("You are out of Turning Points!");
            return true;
        }
        return false;
    }

    public void iterateMinionMonsterListAndAttackMonster(PlayerControl player, MapControl mapControl) {

        for (EnemyParentModel currantMonster : mapControl.currentLevel.getMinionMonsterList()) {
            if (checkIfPlayerIsOutOfTurningPoints(player)) {
                return;
            }

            while (player.getHero().getTurningPoints() >= player.getHero().getWeapon().getTurnPoints()) {
                playerAttackCurrantMinion(currantMonster, player);

                if (checkIfPlayerHasKilledCurrantMinion(currantMonster, player)) {
                    break;
                }
            }
        }
    }

    public void resetMinionAndBossHealthAndTurningPointsWhenPlayerIsKilled(MapControl mapControl) {
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
        monster.setKilled(true);
        return true;
    }

    public void pressEnterToContinue(){
        System.out.println("\n \033[42mGet ready for a new round!\033[0m\n \033[42mPress Enter to continue \033[0m\n");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }

}
