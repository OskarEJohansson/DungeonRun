package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

public class CombatControl {

    public void combat(Monster monster, Player player){

        System.out.println("You are attacked by a monster!");


        player.dodge();

        if(player.getTurningPoints() > 0){

            int damage = player.attack();
            int turningPoints = player.getWeapon().getTurnPoints();
            player.setTurningPoints(player.getTurningPoints() - turningPoints);
            System.out.println(player.getName() + "inflicts " + damage + "health points of damage. ");
            monster.setHealthPoints(monster.getHealthPoints() - damage);

        }
    }
}
