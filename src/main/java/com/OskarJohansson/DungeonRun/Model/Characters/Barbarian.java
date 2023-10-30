package com.OskarJohansson.DungeonRun.Model.Characters;

public class Barbarian{

    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;

    private int armour;
    private int healthPoints;
    private int turningPoints;

    public Barbarian() {
        this.heroClass = "Barbarian";
        this.strength = 5;
        this.intelligence = 5;
        this.agility = 5;

        this.armour = 5;
        this.healthPoints = 5;
        this.turningPoints = 3;
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