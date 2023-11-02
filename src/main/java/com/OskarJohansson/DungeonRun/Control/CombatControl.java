package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.EnemyParentModel;

import java.util.Iterator;
import java.util.Scanner;

public class CombatControl {

    public void playerMinionBattleOptions(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                   
                   +++++|                                   Actions                                             |+++++
                   ____________________________________________________________________________________________________                         
                   #1 - Attack!  |   #2 - Drink Potion |   #3 - Prepare Block for next Round   |   #4 - Flee!  |
                                
                >>>>    %s's turn! <<<<
                >>>>  Turning points: %d  <<<<
                                
                Choose Action: 
                                
                """, player.getHero().getName(), player.getHero().getTurningPoints());


        boolean on = true;
        do {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    playerMinionBattle(player, mapControl);
                }
                case 2 -> player.drinkHealthPotion();
                case 3 -> {
                    System.out.println("BUILD A BLOCK METHOD");
                    on = false;
                }
                case 4 -> {
                    player.flee();
                    on = false;
                }
                default -> System.out.println("Input must be 1-4!");
            }
        } while (on);
    }

    public void playerBossBattleOptions(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                   
                   +++++|                                   Actions                                             |+++++
                   ____________________________________________________________________________________________________                         
                   #1 - Attack!  |   #2 - Drink Potion |   #3 - Prepare Block for next Round   |   #4 - Flee!  |
                                
                >>>>    %s's turn! <<<<
                >>>>  Turning points: %d  <<<<
                                
                Choose Action: 
                                
                """, player.getHero().getName(), player.getHero().getTurningPoints());


        boolean on = true;
        do {
            switch (new UserInputControl().inputInt(new Scanner(System.in))) {
                case 1 -> {
                    playerBossBattle(player, mapControl);
                    on = false;
                }
                case 2 -> player.drinkHealthPotion();
                case 3 -> {
                    System.out.println("BUILD A BLOCK METHOD");
                    on = false;
                }
                case 4 -> {
                    player.flee();
                    on = false;
                }
                default -> System.out.println("Input must be 1-4!");
            }
        } while (on);
    }

    public void minionBattleControl(PlayerControl player, MapControl mapControl) {
        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, mapControl.getMonsterList().size());

        boolean on = true;

        while (on) {

            player.resetTurningPoints();
            minionResetTurningPoints(mapControl);

            minionBattle(player, mapControl);
            checkEnemyList(mapControl);
            if (mapControl.getMonsterList().size() == 0) {
                player.levelUp();
                return;
            }
            if (player.checkHealthPoints()) {
                isPlayerKilled(mapControl);
                return;
            }
            if (isAllMinionsKilled(mapControl, player)) {
                return;
            }
            playerMinionBattleOptions(player, mapControl);

            System.out.println("End of round! Press Enter to continue");
            new Scanner(System.in).nextLine();
        }
    }

    private void minionResetTurningPoints(MapControl mapControl) {
        mapControl.getMonsterList().forEach(c -> c.resetTurningPoints() );
    }

    public void isPlayerKilled(MapControl mapControl) {
        mapControl.getMonsterList().forEach(c -> {
            c.resetTurningPoints();
            c.resetHealthPoints();
        });
    }

    public boolean isAllMinionsKilled(MapControl mapControl, PlayerControl player) {

        if (mapControl.getMonsterList().size() <= 0) {

            System.out.println("////    You have killed all the monsters!   ////\n");

            player.levelUp();
            return true;

        }
        return false;
    }

    public void minionBattle(PlayerControl player, MapControl mapControl) {
        mapControl.getMonsterList().forEach(monster -> {
            while (monster.getTurningPoints() > 0) {
                minionAttack(player, monster, mapControl);
            }
        });
    }

    public void minionAttack(PlayerControl player, EnemyParentModel monster, MapControl mapControl) {
        System.out.printf(">>>>     Monster %d attacks!     <<<<\n", mapControl.getMonsterList().indexOf(monster) + 1);
        player.takeDamage(player.block(), monster.attack());
        player.getStatus();
    }

    public void playerMinionBattle(PlayerControl player, MapControl mapControl) {

        for (EnemyParentModel monster : mapControl.getMonsterList()) {
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
            if (player.getHero().getTurningPoints() > 0) {
                System.out.println("You dont have enough Turning Points!");

            } else System.out.println("You are out of Turning Points!");
        }
    }

    private int checkEnemyList(MapControl mapControl) {
        Iterator<EnemyParentModel> iterator = mapControl.getMonsterList().iterator();

        while (iterator.hasNext()) {
            EnemyParentModel c = iterator.next();
            if (c.getHealthPoints() <= 0) {
                iterator.remove();
            }
        }
        return mapControl.getMonsterList().size();
    }

    private boolean ifEnemyIsKilled(PlayerControl player, EnemyParentModel monster) {
        System.out.printf("////     You killed the monster and gained %d experience points!     //// \n", monster.getExperiencePoints());
        player.getHero().setKillList(1);
        player.getHero().setExperiencePoints(monster.getExperiencePoints());
        player.getHero().setGold(monster.getGold());
        return true;
    }

    public void playerBossBattle(PlayerControl player, MapControl mapControl) {
        if (player.getHero().getTurningPoints() >= 0) {
            if (mapControl.getBoss().getHealthPoints() > 0 && !mapControl.getBoss().isKilled()) {
                mapControl.getBoss().getStatus();
                mapControl.getBoss().takeDamage(mapControl.getBoss().block(), player.attack());
            }
            if (mapControl.getBoss().getHealthPoints() <= 0 && !mapControl.getBoss().isKilled()) {
                System.out.printf("////     You killed %s and gained %d experience points!      ////\n", mapControl.getBoss().getName(), mapControl.getBoss().getExperiencePoints());
                player.getHero().setKillList(1);
                player.getHero().setExperiencePoints(mapControl.getBoss().getExperiencePoints());
                player.getHero().setGold(mapControl.getBoss().getGold());
                mapControl.getBoss().setKilled(true);
            }
        }
    }

    public void bossBattle(PlayerControl player, MapControl mapControl) {
        while (mapControl.getBoss().getTurningPoints() > 0) {
            System.out.printf(">>>>     %s attacks!     <<<<\n", mapControl.getBoss().getName());
            player.takeDamage(player.block(), mapControl.getBoss().attack());
            player.getStatus();
        }
    }

    public void bossBattleControl(PlayerControl player, MapControl mapControl) {

        System.out.printf("""
                You are being attacked by %s!
                                
                """, mapControl.getBoss().getName());

        boolean on = true;

        while (on) {

            player.resetTurningPoints();
            mapControl.getBoss().resetTurningPoints();

            bossBattle(player, mapControl);
            playerBossBattle(player, mapControl);

            if (mapControl.getBoss().isKilled()) {
                player.levelUp();
                return;
            }
            if (player.checkHealthPoints()) {
                isPlayerKilled(mapControl);
                return;
            }
            if (isAllMinionsKilled(mapControl, player)) {
                return;
            }
            playerBossBattleOptions(player, mapControl);

            System.out.println("End of round! Press Enter to continue");
            new Scanner(System.in).nextLine();
        }
    }
}
