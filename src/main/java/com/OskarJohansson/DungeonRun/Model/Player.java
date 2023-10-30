package com.OskarJohansson.DungeonRun.Model;

import com.OskarJohansson.DungeonRun.Control.Combat;
import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Weapon.Sword;

import java.util.Random;

public class Player implements Combat {

    private String name;
    private Sword weapon;
    private Barbarian barbarian;
    private String heroClass;
    private int strength;
    private int intelligence;
    private int agility;
    private int healthPoints = 5;
    private int turningPoints = 5;
    private int armour = 1;
    private int experiencePoints = 0;
    private int gold = 0;
    private int level = 1;
    private int killList  = 0;

    public void setCharacter() {
        this.name = "PlayerTheBarbarian";
        this.barbarian = new Barbarian();
        this.strength = getCharacter().getStrength();
        this.armour = getCharacter().getArmour();
        this.agility = getCharacter().getAgility();
        this.weapon = new Sword();
    }

    public int getKillList() {
        return killList;
    }

    public void setKillList(int killList) {
        this.killList += killList;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Barbarian getCharacter() {
        return this.barbarian;
    }

    public void setCharacter(int choice) {

    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
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
        this.experiencePoints += experiencePoints;
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

    @Override
    public int attack() {
        this.turningPoints -= weapon.getTurnPoints();
        return this.weapon.getDamage();
    }

    @Override
    public boolean block() {

        if (new Random().nextInt(level, agility) < 10 / 2) {
            System.out.println("Player blocked the attack successfully!\n");
            return true;
        } else
            System.out.println("Player fails to blocked the hit!\n");
        return false;
    }

    @Override
    public void takeDamage(Boolean block, int damage) {
        if (!block){
            this.healthPoints -= damage;
        }
    }

    @Override
    public boolean flee() {
        return this.turningPoints > 2;
    }

    @Override
    public void getStatus() {
        System.out.printf("""
                %s
                Health Points        %d
                Turning Points       %d
                Experience Points    %d
                
                """ , this.name, this.healthPoints, this.turningPoints, this.experiencePoints);

    }




}
