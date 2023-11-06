package com.OskarJohansson.DungeonRun.Model.Items.Weapon;

import java.io.Serializable;

public class WeaponParentModel implements Serializable  {

    private String name;
    private String weaponClass;
    private int damage;
    private int turnPoints;
    private int minimumLevel;
    private int cost;
    private String soundOfAttack;

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getWeaponClass() {
        return weaponClass;
    }
    public void setWeaponClass(String weaponClass) {
        this.weaponClass = weaponClass;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getTurnPoints() {
        return turnPoints;
    }

    public void setTurnPoints(int turnPoints) {
        this.turnPoints = turnPoints;
    }

    public int getMinimumLevel() {return minimumLevel;}

    public void setMinimumLevel(int minimumLevel) {this.minimumLevel = minimumLevel;}

    public int getCost() {return cost;}

    public void setCost(int cost) {this.cost = cost;}

    public String getSoundOfAttack() {
        return soundOfAttack;
    }

    public void setSoundOfAttack(String soundOfAttack) {
        this.soundOfAttack = soundOfAttack;
    }
}
