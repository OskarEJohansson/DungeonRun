package com.OskarJohansson.DungeonRun;

import com.OskarJohansson.DungeonRun.Model.*;
import com.OskarJohansson.DungeonRun.Model.Map.Map;
import com.OskarJohansson.DungeonRun.Model.Menu.MainMenu;
import com.OskarJohansson.DungeonRun.Model.Monster.Minion;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GameFlow {

    Player player;

    public GameFlow(){
        this.player = new Player();
    }


    public void main(String[] args) {

        MainMenu menu = new MainMenu();
        menu.mainMenu(this.player, new Map());


//        gameList.forEach(c -> {
//            if (c instanceof Minion) {
//                while (((Minion) c).getTurningPoints() > 0) {
//                    if (((Minion) c).getHealthPoints() < 0) {
//                        gameList.remove(c);
//                        break;
//                    }
//                    player1.takeDamage(player1.block(), monster.attack());
//                    player1.getStatus();
//                }
//            } else if (c instanceof Player) {
//
//                while (((Player) c).getTurningPoints() > 0) {
//
//                    player1.getStatus();
//                    System.out.printf("""
//                            %s's turn. Do you want to attack or flee?
//
//                            Attack: 1
//                            Flee: 2
//                            Input:
//                            """, player1.getName());
//
//
//                    boolean monsterKilled = false;
//                    boolean flee = false;
//
//                    do
//                        switch (new Scanner(System.in).nextInt()) {
//
//                            case 1 -> {
//                                monster.takeDamage(monster.block(), player1.attack());
//
//                                if (monster.getHealthPoints() <= 0) {
//
//                                    player1.setKillList(1);
//                                    player1.setExperiencePoints(player1.getExperiencePoints() + monster.getExperiencePoints());
//                                    System.out.println("You killed the monster!");
//                                    player1.getStatus();
//                                }
//                                monsterKilled = true;
//                            }
//                            case 2 -> {
//                                player1.flee();
//                                System.out.println("You are fleeing from the battle like a coward!");
//                                flee = true;
//                            }
//                            default -> System.out.println("Input must be 1 or 2!");
//
//                        } while (!monsterKilled || flee);
//                }
//            }
//        });
//
//    }
    }
}

