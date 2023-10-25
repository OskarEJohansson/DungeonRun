package com.OskarJohansson.DungeonRun.Model.Characters;

public class Coder extends Character {

    private int strength;
    private int intelligence;
    private int agility;

    private int armor;
    private int healthPoints;
    private int turningPoints;

    public Coder() {
        this.strength = 1;
        this.intelligence = 5;
        this.agility = 2;

        this.armor = 2;
        this.healthPoints = 3;
        this.turningPoints = 0;
    }
}
