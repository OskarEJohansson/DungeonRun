package com.OskarJohansson.DungeonRun.Control;

import java.util.Random;

public class Randomizer {

    public int randomizer(int minNumber, int maxNumber){
        return new Random().nextInt(minNumber, maxNumber);
    }
}
