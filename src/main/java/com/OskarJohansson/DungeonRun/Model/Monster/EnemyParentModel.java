package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;

public class EnemyParentModel implements CombatInterface {

    private String name;
    private int healthPoints;
    private int damage;
    private int turningPoints;
    private int turningpointsBase;
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

    public int getTurningpointsBase() {
        return turningpointsBase;
    }

    public void setTurningpointsBase(int turningpointsBase) {
        this.turningpointsBase = turningpointsBase;
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

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
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
    }

    @Override
    public void takeDamage(Boolean takeDamage, int damage) {

    }

    @Override
    public void resetTurningPoints() {
        this.turningPoints = this.turningpointsBase;
    }
}