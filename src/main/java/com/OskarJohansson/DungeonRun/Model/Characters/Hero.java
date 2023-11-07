package com.OskarJohansson.DungeonRun.Model.Characters;

import com.OskarJohansson.DungeonRun.Model.Items.Potions.HealthPotion;
import com.OskarJohansson.DungeonRun.Model.Items.Weapon.WeaponParentModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hero implements Serializable {

    private String name;
    private WeaponParentModel weapon;
    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;
    private int healthPoints = 100;
    private int healthPointsBase = 100;
    private int turningPoints = 1;
    private int turningPointsBase = 1;
    private int experiencePoints = 100;
    private int gold = 0;
    private int level = 10;
    private int killList = 0;
    private boolean codeBreaker = false;
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
        this.strength += strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence += intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility += agility;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints += healthPoints;
    }

    public void addHealthPoints(int healthPoints) {
        this.healthPoints += healthPoints;
    }

    public int getHealthPointsBase() {
        return healthPointsBase;
    }

    public void setHealthPointsBase(int healthPointsBase) {
        this.healthPointsBase += healthPointsBase;
    }

    public void resetHealthPoints(){
        this.healthPoints = this.healthPointsBase;
    }

    public int getTurningPoints() {
        return turningPoints;
    }
    public void setTurningPoints(int turningPoints) {
        this.turningPoints += turningPoints;
    }

    public int getTurningPointsBase() {
        return turningPointsBase;
    }

    public void setTurningPointsBase(int turningPointsBase) {
        this.turningPointsBase += turningPointsBase;
    }

    public void resetTurningPoints(){
        this.turningPoints = turningPointsBase;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints += experiencePoints;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
    }

    public void resetGold() {
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

    public boolean isCodeBreaker() {
        return codeBreaker;
    }

    public void setCodeBreaker(boolean codeBreaker) {
        this.codeBreaker = codeBreaker;
    }

    public List<HealthPotion> getPotionStash() {
        return potionStash;
    }

    public void addPotionStash(HealthPotion potion) {
        this.potionStash.add(potion);
    }

}
