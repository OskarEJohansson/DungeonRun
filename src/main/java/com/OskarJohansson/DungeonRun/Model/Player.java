package com.OskarJohansson.DungeonRun.Model;

import com.OskarJohansson.DungeonRun.Controll.Combat;

import java.util.Random;

public class Player implements Combat {

    private String name;
    private Character character;
    private Weapon weapon;
    private int healthPoints;
    private int turnPoints;
    private int experiencePoints;
    private int gold;
    private int level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(int choice) {
        switch (choice) {
            case 1 -> {
                this.character = Character.Barbarian;
                this.weapon = Weapon.Sword;
            }
            case 2 -> {
                this.character = Character.Coder;
                this.weapon = Weapon.Computer;
            }
            case 3 -> {
                this.character = Character.Assassin;
                this.weapon = Weapon.Knife;
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
    public void attack() {

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
}
