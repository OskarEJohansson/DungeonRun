package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;

public class EnemyParentModel implements CombatInterface {

    private String name;
    private int healthPoints;
    private int healthPointsBase;
    private int damage;
    private int turningPoints;
    private int turningPointsBase;
    private int attackCost;
    private int experiencePoints;
    private int gold;
    private int level;
    private boolean killed;
    private boolean allMonstersKilled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getHealthPointsBase() {return healthPointsBase;}

    public void setHealthPointsBase(int healthPointsBase) {this.healthPointsBase = healthPointsBase;}

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

    public int getTurningPointsBase() {
        return turningPointsBase;
    }

    public void setTurningPointsBase(int turningPointsBase) {
        this.turningPointsBase = turningPointsBase;
    }

    public int getAttackCost() {
        return attackCost;
    }

    public void setAttackCost(int attackCost) {
        this.attackCost = attackCost;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
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

    @Override
    public int attack() {
        return 0;
    }

    @Override
    public boolean block() {

        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                 ++++                    Enemy Stats                     ++++
                 ____________________________________________________________                
                 Enemy   %s  |   Health Points   %d  |   Turning Points  %d  |
                                 
                 """, this.getName(), this.getHealthPoints(), this.getTurningPoints());
    }

    @Override
    public void takeDamage(Boolean takeDamage, int damage) {
    }

    @Override
    public void resetTurningPoints() {
        this.turningPoints = this.turningPointsBase;
    }

    @Override
    public void resetHealthPoints() {
        this.healthPoints = this.healthPointsBase;
    }

}