package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.ICA;

import com.OskarJohansson.DungeonRun.Model.Menu.MainMenu;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Monster.icaBoss;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapObject {

    List<Monster> monsterList;
    Level level;
    ICA ica;
    Monster icaBoss;

    public MapObject() {
        this.monsterList = new ArrayList<>();
        this.level = new Level();
        this.ica = new ICA();
        this.icaBoss = new icaBoss();
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

    public void setMap(int choice) {
        switch (choice) {
            case 1 -> {
                this.level = this.ica;
                this.monsterList = this.ica.getMinionMonsterList();
            }
        }
    }

    public void minionBattle(Player player) {
        this.monsterList.forEach(monster -> {
            while (monster.getTurningPoints() > 0) {
                System.out.printf("Monster %d attacks!\n", monsterList.indexOf(monster) + 1);
                player.takeDamage(player.block(), monster.attack());
                player.getStatus();
                break;
            }
        });
    }


    public void playerBattle(Player player) {
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

    public void minionBattleControl(Player player, MainMenu mainMenu, MapObject map) {

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

    public void bossBattle(Player player) {
        while (this.icaBoss.getTurningPoints() > 0) {
            System.out.printf("%s attacks!\n", icaBoss.getName());
            player.takeDamage(player.block(), icaBoss.attack());
            player.getStatus();
        }
    }

    public void playerBossBattle(Player player) {
        System.out.printf("""
                %s's turn!
                Press enter to continue!
                                
                """, player.getName());

        new Scanner(System.in).nextLine();
        if (player.getTurningPoints() >= 0) {
            if (this.icaBoss.getHealthPoints() > 0 && !icaBoss.isKilled()) {
                icaBoss.getStatus();
                icaBoss.takeDamage(icaBoss.block(), player.attack());
            }
            if (icaBoss.getHealthPoints() <= 0 && !icaBoss.isKilled()) {
                System.out.printf("You killed the %s and gained %d experience points! \n", icaBoss.getName(), icaBoss.getExperiencePoints());
                player.setKillList(1);
                player.setExperiencePoints(icaBoss.getExperiencePoints());
                player.setGold(icaBoss.getGold());
                icaBoss.setKilled(true);
            }
        }
    }

    public void bossBattleControl(Player player) {

        System.out.printf("""
                You are being attacked by %s!
                                
                """, this.icaBoss.getName());
        do {
            bossBattle(player);
            playerBossBattle(player);
            if (this.icaBoss.isKilled()) {
                System.out.printf("You have killed %s!", icaBoss.getName());
                player.levelUp();
                player.resetTurningPoints();
            }
            player.resetTurningPoints();
            icaBoss.resetTurningPoints();
        } while (!icaBoss.isKilled());
    }
}



