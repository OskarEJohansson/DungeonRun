package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.Combat;

public class Monster extends Combat {

    private int healthPoints;
    private int damage;
    private int turningPoints;
    private int experiencePoints;
    private int gold;

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTurningPoints() {
        return turningPoints;
    }

    public void setTurningPoints(int turningPoints) {
        this.turningPoints = turningPoints;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int attack() {

        return 0;
    }

    @Override
    public void block() {

    }

    @Override
    public void flee() {

    }

    @Override
    public void getStatus() {

    }

    @Override
    public int dodge() {

        return 0;
    }
}
