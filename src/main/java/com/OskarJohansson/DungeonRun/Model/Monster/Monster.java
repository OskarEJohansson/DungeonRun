package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.Combat;

import java.util.Random;

public class Monster implements Combat {

    private String name;
    private int healthPoints;
    private int damage;
    private int turningPoints;
    private int attackCost;
    private int experiencePoints;
    private int gold;
    private int level;
    private int armour;
    private boolean killed;
    private boolean allMonstersKilled;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
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

    public boolean isKilled() {
        return killed;
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isAllMonstersKilled() {
        return allMonstersKilled;
    }

    public void setAllMonstersKilled(boolean allMonstersKilled) {
        this.allMonstersKilled = allMonstersKilled;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public int attack() {
        this.turningPoints -= this.attackCost;
        return this.damage;
    }

    @Override
    public boolean block() {

        if (new Random().nextInt(1, 2) > 10) {
            System.out.println("Monster blocked the attack successfully!");
            return true;
        }
        System.out.println("Monster fails to blocked the attack\n");
        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                                
                Enemey               %s
                Health Points        %d
                Turning Points       %d
                                
                """, this.name, this.healthPoints, this.turningPoints);
    }

    @Override
    public void takeDamage(Boolean takeDamage, int damage) {
        if (!takeDamage) {
            this.healthPoints -= damage;
        }
    }
}