package com.OskarJohansson.DungeonRun.Model.Monster;

public class Minion extends Monster {

    private String name;
    private int healthPoints;
    private int damage;
    private int turningPoints;
    private int attackCost;
    private int experiencePoints;
    private int gold;
    private int level;
    private int armour;

    public Minion(){
        this.name = "Minion";
        this.healthPoints = 3;
        this.damage = 1;
        this.attackCost = 1;
        this.turningPoints = 5;
        this.experiencePoints = 1;
        this.gold = 1;
        this.level = 1;
        this.armour = 2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getTurningPoints() {
        return turningPoints;
    }

    @Override
    public int getAttackCost() {
        return attackCost;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getArmour() {
        return armour;
    }
}
