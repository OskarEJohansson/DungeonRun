package com.OskarJohansson.DungeonRun.Model.Characters;

public class Barbarian extends Character {

    private int strength;
    private int intelligence;
    private int agility;

    private int armor;
    private int healthPoints;
    private int turningPoints;

    public Barbarian() {
        this.strength = 5;
        this.intelligence = 1;
        this.agility = 2;

        this.armor = 2;
        this.healthPoints = 3;
        this.turningPoints = 0;
    }
}