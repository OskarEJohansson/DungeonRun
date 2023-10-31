package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.ICA;

import com.OskarJohansson.DungeonRun.Model.Menu.MainMenu;
import com.OskarJohansson.DungeonRun.Model.Monster.Minion;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MapObject {

    List<Minion> minionMonsterList;
    Level level;
    ICA ica;

    public MapObject() {
        this.minionMonsterList = new ArrayList<>();
        this.level = new Level();
        this.ica = new ICA();
    }

    public List<Minion> getMinionMonsterList() {
        return minionMonsterList;
    }

    public void setMinionMonsterList(List<Minion> minionMonsterList) {
        this.minionMonsterList = minionMonsterList;
    }

    public Level getLevel() {
        return level;
    }

    public void setMap(int choice) {
        switch (choice) {
            case 1 -> {
                this.level = this.ica;
                this.minionMonsterList = this.ica.getMinionMonsterList();
            }
        }
    }

    public void minionBattle(Player player) {
        this.minionMonsterList.forEach(monster -> {
            while (monster.getTurningPoints() > 0) {
                if (monster.getHealthPoints() < 0) {
                    minionMonsterList.remove(monster);
                    break;
                } else {
                    System.out.printf("Monster %d attacks!\n", minionMonsterList.indexOf(monster) + 1);
                    player.takeDamage(player.block(), monster.attack());
                    player.getStatus();
                    break;
                }
            }
        });
    }

    public void playerBattle(Player player, MainMenu mainMenu, MapObject map) {
        System.out.printf("""
                %s's turn!
                Press enter to continue!
                                
                """, player.getName());

        new Scanner(System.in).nextLine();

        if (player.getTurningPoints() >= 0) {

            for (Minion monster : minionMonsterList) {
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

    public void battle(Player player, MainMenu mainMenu, MapObject map) {

        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, minionMonsterList.size() - 1);

        do {
            minionBattle(player);
            playerBattle(player, mainMenu, map);
            checkEnemyList();
            if (this.minionMonsterList.size() <= 0) {
                System.out.println("You have killed all the monsters!");
                player.levelUp();
                player.resetTurningPoints();
            }
        } while (checkEnemyList() != 0);


    }

    private int checkEnemyList() {
        Iterator<Minion> iterator = this.minionMonsterList.iterator();

        while(iterator.hasNext()){
            Minion c = iterator.next();
            if(c.getHealthPoints() <= 0){
                iterator.remove();
            }
        }
        return this.minionMonsterList.size();
    }
}



