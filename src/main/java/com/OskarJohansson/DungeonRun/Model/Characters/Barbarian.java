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
        this.setHealthPoints(5);
        this.setHealthPointsBase(5);
        this.setTurningPoints(5);
        this.setTurningPointsBase(5);
        this.setWeapon(new Sword());
    }
}