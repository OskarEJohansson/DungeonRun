package com.OskarJohansson.DungeonRun.Model.Map;

import com.OskarJohansson.DungeonRun.Model.Monster.Minion;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {

    List<Minion> monsterList = new ArrayList<>();

    public Map() {
        for (int i = 0; i < 3; i++) {
            monsterList.add(new Minion());
        }
        Minion allMonstersKilled = new Minion();
        allMonstersKilled.setAllMonstersKilled(true);
        monsterList.add(allMonstersKilled);
    }

    public void mapStructure(Player player) {
        System.out.println("Welcome to Level 1!");
        boolean on = true;

        do
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> {
                    System.out.println("Enter kill zone!");
                    battle(player);
                }
                case 2 -> {
                    System.out.println("You are leaving the Level!");
                    on = false;
                }
            } while (on);
    }


    public void battle(Player player) {

        System.out.printf("""
                You are being attacked by %d monsters!
                                
                """, monsterList.size() - 1);

        this.monsterList.forEach(c -> {
            if (c instanceof Minion) {
                while (c.getTurningPoints() > 0) {
                    if (c.getHealthPoints() < 0) {
                        monsterList.remove(c);
                        break;
                    } else {
                        System.out.printf("Monster %d attacks!\n", monsterList.indexOf(c) + 1);
                        player.takeDamage(player.block(), c.attack());
                        player.getStatus();
                    }
                }
            }
        });

        System.out.printf("""
                %s's turn!
                                
                """, player.getName());

        while (player.getTurningPoints() > 0) {
            for (Minion monster : monsterList) {
                if (monster.getHealthPoints() > 0 && monster.isKilled() == false) {
                    monster.getStatus();
                    monster.takeDamage(monster.block(), player.attack());
                }
                if (monster.getHealthPoints() <= 0 && monster.isKilled() == false) {
                    System.out.printf("You killed the monster and gained %d experience points! \n", monster.getExperiencePoints());
                    player.setKillList(1);
                    player.setExperiencePoints(monster.getExperiencePoints());
                    player.setGold(monster.getGold());
                    monster.setKilled(true);
                }
                if (monster.isAllMonstersKilled() == true) {
                    System.out.println("You have killed all the monsters!");
                    player.levelUp();
                    player.getStatus();
                    return;
                }
            }
        }
    }
}

