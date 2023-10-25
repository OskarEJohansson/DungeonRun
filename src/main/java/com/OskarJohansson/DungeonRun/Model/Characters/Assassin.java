package com.OskarJohansson.DungeonRun.Model.Characters;

public class Assassin extends Character{

    private int strength;
    private int intelligence;
    private int agility;

    private int armor;
    private int healthPoints;
    private int turningPoints;

    public Assassin() {
        this.strength = 1;
        this.intelligence = 3;
        this.agility = 5;

        this.armor = 1;
        this.healthPoints = 5;
        this.turningPoints = 5;
    }

}
