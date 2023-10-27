package com.OskarJohansson.DungeonRun.Model;

import com.OskarJohansson.DungeonRun.Control.Combat;
import com.OskarJohansson.DungeonRun.Model.Characters.Assassin;
import com.OskarJohansson.DungeonRun.Model.Characters.Barbarian;
import com.OskarJohansson.DungeonRun.Model.Characters.Character;
import com.OskarJohansson.DungeonRun.Model.Characters.Coder;
import com.OskarJohansson.DungeonRun.Model.Weapon.Drone;
import com.OskarJohansson.DungeonRun.Model.Weapon.Knife;
import com.OskarJohansson.DungeonRun.Model.Weapon.Sword;
import com.OskarJohansson.DungeonRun.Model.Weapon.Weapon;

import java.util.Random;

public class Player implements Combat {

    private String name;
    private Weapon weapon;
    private Character character;
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

    public void setCharacter(Character character) {
        this.character = character;
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

    public Character getCharacter() {
        return this.character;
    }

    public void setCharacter(int choice) {




        switch (choice) {
            case 1 -> {
                setCharacter(new Barbarian());
                setHeroClass(character.getHeroClass());
                setWeapon(new Sword());
                setStrength(character.getStrength());
                setIntelligence(character.getIntelligence());
                setAgility(character.getAgility());
                setHealthPoints(this.healthPoints += character.getHealthPoints());
                setTurningPoints(this.turningPoints += character.getTurningPoints());
                setArmour(this.armour = character.getArmour());
            }
            case 2 -> {
                setCharacter(new Coder());
                setHeroClass(character.getHeroClass());
                setWeapon(new Drone());
                setStrength(character.getStrength());
                setIntelligence(character.getIntelligence());
                setAgility(character.getAgility());
                setHealthPoints(this.healthPoints += character.getHealthPoints());
                setTurningPoints(this.turningPoints += character.getTurningPoints());
                setArmour(this.armour = character.getArmour());
            }
            case 3 -> {
                setCharacter(new Assassin());
                setHeroClass(character.getHeroClass());
                setWeapon(new Knife());
                setStrength(character.getStrength());
                setIntelligence(character.getIntelligence());
                setAgility(character.getAgility());
                setHealthPoints(this.healthPoints += character.getHealthPoints());
                setTurningPoints(this.turningPoints += character.getTurningPoints());
                setArmour(this.armour = character.getArmour());
            }
            default -> System.out.println("Input must be an integer 1-3");
        }
    }

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
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

    @Override
    public int attack() {
        return getWeapon().getDamage();
    }

    @Override
    public int block() {
        return 0;
    }

    @Override
    public int flee() {
        return this.agility;

    }

    @Override
    public void getStatus() {

    }

    @Override
    public int dodge() {
        return this.agility;
    }
}
