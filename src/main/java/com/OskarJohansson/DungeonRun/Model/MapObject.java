package com.OskarJohansson.DungeonRun.Model;

import com.OskarJohansson.DungeonRun.Model.Map.Level;
import com.OskarJohansson.DungeonRun.Model.Map.ICA;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Monster.Monster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapObject {

    List<Monster> monsterList;
    Level level;
    ICA ica;

    public MapObject() {
        this.monsterList = new ArrayList<>();
        this.level = new Level();
        this.ica = new ICA();
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
                this.monsterList = this.ica.getMonsterList();
            }
        }
    }

    public void minionBattle(Player player) {
        this.monsterList.forEach(monster -> {
            if (this.monsterList.size() == 0) {
                System.out.println("You have killed all the monsters!");
                player.levelUp();
                player.getStatus();
                return;
            }
                while (monster.getTurningPoints() > 0) {
                    if (monster.getHealthPoints() < 0) {
                        monsterList.remove(monster);
                        break;
                    } else {
                        System.out.printf("Monster %d attacks!\n", monsterList.indexOf(monster) + 1);
                        player.takeDamage(player.block(), monster.attack());
                        player.getStatus();
                        break;
                    }
                }
        });
    }

    public void playerBattle(Player player) {
        System.out.printf("""
                %s's turn!
                                
                """, player.getName());

        System.out.println("Press enter to continue!");
        new Scanner(System.in).nextLine();

        while (player.getTurningPoints() >= 0) {
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

    public void battle(Player player) {

        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, monsterList.size() - 1);

        minionBattle(player);
        playerBattle(player);

    }
}

