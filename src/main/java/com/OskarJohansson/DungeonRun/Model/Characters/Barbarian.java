package com.OskarJohansson.DungeonRun.Model.Characters;

public class Barbarian extends Character {

    private int strength;
    private int intelligence;
    private int agility;

    private int armour;
    private int healthPoints;
    private int turningPoints;

    public Barbarian() {
        this.strength = 5;
        this.intelligence = 1;
        this.agility = 2;

        this.armour = 2;
        this.healthPoints = 3;
        this.turningPoints = 0;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getArmour() {
        return this.armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getTurningPoints() {
        return turningPoints;
    }

    public void setTurningPoints(int turningPoints) {
        this.turningPoints = turningPoints;
    }
}