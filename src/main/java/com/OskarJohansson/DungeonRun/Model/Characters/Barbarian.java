package com.OskarJohansson.DungeonRun.Model.Characters;

import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponClassOne.Sword;

public class Barbarian extends Hero{

    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;

    private int armour;
    private int healthPoints;
    private int turningPoints;

    public Barbarian() {
        this.setHeroClass("Barbarian");
        this.setStrength(5);
        this.setIntelligence(5);
        this.setAgility(5);
        this.setArmour(5);
        this.setHealthPoints(5);
        this.setHealthPointsBase(5);
        this.setTurningPoints(5);
        this.setWeapon(new Sword());
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
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