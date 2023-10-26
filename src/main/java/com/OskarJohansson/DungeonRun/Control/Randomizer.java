package com.OskarJohansson.DungeonRun.Control;

import com.OskarJohansson.DungeonRun.Model.Monster.Monster;
import com.OskarJohansson.DungeonRun.Model.Player;

import java.util.Random;

public class Randomizer {

    public int randomizer(int level, int agility){
        return new Random().nextInt(level, agility);
    }
}
