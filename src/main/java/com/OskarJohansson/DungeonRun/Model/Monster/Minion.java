package com.OskarJohansson.DungeonRun.Model.Monster;

public class Minion extends Monster {

    private int healthPoints;
    private int damage;
    private int turningPoints;
    private int experiencePoints;
    private int gold;

    public Minion(){
        this.healthPoints = 3;
        this.damage = 1;
        this.turningPoints = 2;
        this.experiencePoints = 1;
        this.gold = 1;
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    @Override
    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getTurningPoints() {
        return turningPoints;
    }

    @Override
    public void setTurningPoints(int turningPoints) {
        this.turningPoints = turningPoints;
    }

    @Override
    public int getExperiencePoints() {
        return experiencePoints;
    }

    @Override
    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    @Override
    public int getGold() {
        return gold;
    }

    @Override
    public void setGold(int gold) {
        this.gold = gold;
    }


}
