package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Map.KjellCO;
import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.ICA;

import com.OskarJohansson.DungeonRun.Model.Map.Sats;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapControl {

    List<Monster> monsterList;
    Level level;
    ICA ica;
    Sats sats;
    KjellCO kjellCo;
    Monster boss;
    String levelName;
    String levelNumber;

    public MapControl() {
        this.monsterList = new ArrayList<>();
        this.level = new Level();
        this.ica = new ICA();
        this.sats = new Sats();
        this.kjellCo = new KjellCO();
        this.boss = new Monster();
        this.levelName = "";
        this.levelNumber = "";
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }
    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
    public Level getLevel() {
        return level;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public void setMap(int choice) {
        switch (choice) {
            case 1 -> {
                this.level = this.ica;
                this.monsterList = this.ica.getMinionMonsterList();
                this.boss = this.ica.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
            case 2 -> {
                this.level = this.sats;
                this.monsterList = this.sats.getMinionMonsterList();
                this.boss = this.sats.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
            case 3 -> {
                this.level = this.kjellCo;
                this.monsterList = this.kjellCo.getMinionMonsterList();
                this.boss = this.kjellCo.getFinalBoss();
                this.levelName = this.level.getLevelName();
                this.levelNumber = this.level.getLevelNumber();
            }
        }
    }

    public void minionBattle(PlayerControl player) {
        this.monsterList.forEach(monster -> {
            while (monster.getTurningPoints() > 0) {
                System.out.printf("Monster %d attacks!\n", monsterList.indexOf(monster) + 1);
                player.takeDamage(player.block(), monster.attack());
                player.getStatus();
                break;
            }
        });
    }


    public void playerBattle(PlayerControl player) {
        System.out.printf("""
                %s's turn!
                Press enter to continue!
                                
                """, player.getName());

        new Scanner(System.in).nextLine();

        if (player.getTurningPoints() >= 0) {

            for (Monster monster : monsterList) {
                if (monster.getHealthPoints() > 0 && !monster.isKilled()) {
                    monster.getStatus();
                    monster.takeDamage(monster.block(), player.attack());
                }
                if (monster.getHealthPoints() <= 0 && !monster.isKilled()) {
                    System.out.printf("You killed the monster and gained %d experience points! \n", monster.getExperiencePoints());
                    player.setKillList(1);
                    player.setExperiencePoints(monster.getExperiencePoints());
                    player.setGold(monster.getGold());
                    monster.setKilled(true);
                }
            }
        }
    }

    public void minionBattleControl(PlayerControl player) {

        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, monsterList.size() - 1);

        do {
            minionBattle(player);
            playerBattle(player);
            checkEnemyList();
            if (this.monsterList.size() <= 0) {
                System.out.println("You have killed all the monsters!");
                player.levelUp();
                player.resetTurningPoints();
            }
            player.resetTurningPoints();
            System.out.println("End of round! Press Enter to continue");
            player.getStatus();
            new Scanner(System.in).nextLine();

        } while (checkEnemyList() != 0);
    }

    private int checkEnemyList() {
        Iterator<Monster> iterator = this.monsterList.iterator();

        while (iterator.hasNext()) {
            Monster c = iterator.next();
            if (c.getHealthPoints() <= 0) {
                iterator.remove();
            }
        }
        return this.monsterList.size();
    }

    public void bossBattle(PlayerControl player) {
        while (this.boss.getTurningPoints() > 0) {
            System.out.printf("%s attacks!\n", boss.getName());
            player.takeDamage(player.block(), boss.attack());
            player.getStatus();
        }
    }

    public void playerBossBattle(PlayerControl player) {
        System.out.printf("""
                %s's turn!
                Press enter to continue!
                                
                """, player.getName());

        new Scanner(System.in).nextLine();
        if (player.getTurningPoints() >= 0) {
            if (this.boss.getHealthPoints() > 0 && !boss.isKilled()) {
                boss.getStatus();
                boss.takeDamage(boss.block(), player.attack());
            }
            if (boss.getHealthPoints() <= 0 && !boss.isKilled()) {
                System.out.printf("You killed the %s and gained %d experience points! \n", boss.getName(), boss.getExperiencePoints());
                player.setKillList(1);
                player.setExperiencePoints(boss.getExperiencePoints());
                player.setGold(boss.getGold());
                boss.setKilled(true);
            }
        }
    }

    public void bossBattleControl(PlayerControl player) {

        System.out.printf("""
                You are being attacked by %s!
                                
                """, this.boss.getName());
        do {
            bossBattle(player);
            playerBossBattle(player);
            if (this.boss.isKilled()) {
                System.out.printf("You have killed %s!", boss.getName());
                player.levelUp();
                player.resetTurningPoints();
            }
            player.resetTurningPoints();
            boss.resetTurningPoints();
        } while (!boss.isKilled());
    }
}



