package com.OskarJohansson.DungeonRun.Model.Monster;

import com.OskarJohansson.DungeonRun.Control.CombatInterface;

import java.util.Random;

public class EnemyParentModel implements CombatInterface {

    private String name;
    private int healthPoints;
    private int healthPointsBase;
    private int damageMin;
    private int damageMax;
    private int turningPoints;
    private int turningPointsBase;
    private int attackCost;
    private int experiencePoints;
    private int gold;
    private int level;
    private boolean killed;

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

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
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


    public int attack() {
        this.setTurningPoints(this.getTurningPoints() - this.getAttackCost());
        return new Random().nextInt(getDamageMin(), getDamageMax());
    }

    @Override
    public boolean block() {

        return false;
    }

    @Override
    public boolean flee() {
        return true;
    }

    public void getStatus() {
        System.out.printf("""
                 ++++                    Enemy Stats                     ++++
                 ____________________________________________________________                
                 Enemy   %s  |   Health Points   %d  |   Turning Points  %d  |
                                 
                 """, this.getName(), this.getHealthPoints(), this.getTurningPoints());
    }

    public void takeDamage(Boolean takeDamage, int damage) {
        if (!takeDamage) {
            this.setHealthPoints(this.getHealthPoints() - damage);
            System.out.printf(">>>>    \033[0;91m%s takes %d in damage!\033[0m    <<<<\n",this.getName(), damage );

        }
    }

    public void resetTurningPoints() {
        setTurningPoints(getTurningPointsBase());
    }


    public void resetHealthPoints() {
        this.healthPoints = this.healthPointsBase;
    }

}