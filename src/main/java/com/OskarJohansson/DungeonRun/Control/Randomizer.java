package com.OskarJohansson.DungeonRun.Control;
import java.util.Random;

public class Randomizer {

    public int randomizer(int level, int agility){
        return new Random().nextInt(level, agility);
    }

    public boolean dodge(int monsterLevel, int playerAgility ){
        return new Random().nextInt(monsterLevel,playerAgility) < playerAgility/2;
    }

    public boolean block(int level, int armour){
        return new Random().nextInt(level, armour) < armour/2;
    }
}
