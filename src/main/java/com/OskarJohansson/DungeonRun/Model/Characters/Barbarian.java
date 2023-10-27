package com.OskarJohansson.DungeonRun.Model.Characters;

public class Barbarian extends Character {
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
        this.intelligence = 1;
        this.agility = 2;

        this.armour = 2;
        this.healthPoints = 3;
        this.turningPoints = 0;
    }

    @Override
    public String getHeroClass() {
        return heroClass;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public int getArmour() {
        return armour;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public int getTurningPoints() {
        return turningPoints;
    }
}
