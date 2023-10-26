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
    private int strength;
    private int intelligence;
    private int agility;
    private int healthPoints = 5;
    private int turningPoints = 5;
    private int experiencePoints = 0;
    private int gold = 0;
    private int level = 1;

    public int getTurningPoints() {
        return turningPoints;
    }

    public void setTurningPoints(int turningPoints) {
        this.turningPoints = turningPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter(){
        return this.character;
    }


    public void setCharacter(int choice) {

        switch (choice) {
            case 1 -> {
                this.character = new Barbarian();
                this.weapon = new Sword();
                this.strength = character.getStrength();
                this.intelligence = character.getIntelligence();
                this.agility = character.getAgility();
            }
            case 2 -> {
                character = new Coder();
                this.weapon = new Drone();
                this.strength = character.getStrength();
                this.intelligence = character.getIntelligence();
                this.agility = character.getAgility();
            }
            case 3 -> {
                this.character = new Assassin();
                this.weapon = new Knife();
                this.strength = character.getStrength();
                this.intelligence = character.getIntelligence();
                this.agility = character.getAgility();
            }
            default -> System.out.println("Input must be an integer 1-3");
        }
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

        return new Random().nextInt(2, this.weapon.getDamage());
    }

    @Override
    public void block() {

    }

    @Override
    public void flee() {

    }

    @Override
    public void getStatus() {

    }

    @Override
    public int dodge() {
        return this.agility;
    }
}
