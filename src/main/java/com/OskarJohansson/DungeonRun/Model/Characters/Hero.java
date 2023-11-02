package com.OskarJohansson.DungeonRun.Model.Characters;

import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private WeaponParentModel weapon;
    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;
    private int healthPoints = 5;
    private int healthPointsBase = 5;
    private int turningPoints = 5;
    private int turningPointsBase = 5;
    private int armour = 1;
    private int experiencePoints = 0;
    private int gold = 10;
    private int level = 1;
    private int killList = 0;
    private List<HealthPotion> potionStash = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponParentModel getWeapon() {
        return weapon;
    }

    public void setWeapon(WeaponParentModel weapon) {
        this.weapon = weapon;
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

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void addHealthPoints(int healthPoints){
        this.healthPoints += healthPoints;
    }

    public int getHealthPointsBase() {
        return healthPointsBase;
    }

    public void setHealthPointsBase(int healthPointsBase) {
        this.healthPointsBase = healthPointsBase;
    }

    public int getTurningPoints() {
        return turningPoints;
    }

    public void setTurningPoints(int turningPoints) {
        this.turningPoints -= turningPoints;
    }

    public int getTurningPointsBase() {
        return turningPointsBase;
    }

    public void setTurningPointsBase(int turningPointsBase) {
        this.turningPointsBase = turningPointsBase;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
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
        this.gold += gold;
    }

    public void resetGold(){
        this.gold = 0;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getKillList() {
        return killList;
    }

    public void setKillList(int killList) {
        this.killList += killList;
    }

    public List<HealthPotion> getPotionStash() {
        return potionStash;
    }

    public void addPotionStash(HealthPotion potion) {
        this.potionStash.add(potion);
    }

}
