package com.OskarJohansson.DungeonRun.Controll;

import com.OskarJohansson.DungeonRun.Model.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

public class CombatControll {
    public void combat(Monster monster, Player player){

        System.out.println("You are attacked by a monster!");
        player.attack();

    }


}
